/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3;

import AutomataFD.*;
import AutomataFND.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 *
 * @author Ana
 */
public class Manejar {
    private AFD afd;
    private AFND afnd;
    private File fgraph;
    private BufferedWriter salidaGraph;
    private int opc;
    private String outPath;
    
    /**
     * Constructor.
     * @param opc 0 si el autómata que queremos es un autómata finito determinista, 
     * 1 si queremos un autómata finito no determinista.
     */
    public Manejar(int opc) {
        this.opc = opc;
    }

    /**
     * Devuelve el autómata finito determinista creado a partir del fichero.
     * @return El autómata finito determinista creado a partir del fichero.
     */
    public AFD getAfd() {
        return afd;
    }

    /**
     * Devuelve el autómata finito no determinista creado a partir del fichero.
     * @return El autómata finito no determinista creado a partir del fichero.
     */
    public AFND getAfnd() {
        return afnd;
    }

    /**
     * Devuelve la ruta donde se encuentra la imagen del autómata.
     * @return La ruta donde se encuentra la imagen del autómata.
     */
    public String getOutPath() {
        return outPath;
    }
    
    /**
     * Lee un fichero con la descripción del autómata y crea un AFD si opc vale 
     * 0 y un AFND para cualquier otro valor de opc
     * @param ruta Ruta del fichero que contiene la descripción del autómata.
     */
    public void leerFichero(String ruta) throws IOException {
       
        BufferedReader entrada = new BufferedReader(new FileReader(ruta));
        //si es un AFD
        if(opc == 0){
            afd = new AFD();
            //leo la primera linea que es la que tiene los estados finales
            String linea = entrada.readLine();
            StringTokenizer token = new StringTokenizer(linea);
            token.nextToken();  //tiene EF:
            HashSet<Integer> estFin = new HashSet<>();
            while(token.hasMoreTokens()){
                estFin.add(Integer.parseInt(token.nextToken()));
            }
            afd.setEstadosFinales(estFin);

            linea = entrada.readLine();
            while(!linea.equals("EOF")){
                token = new StringTokenizer(linea);
                int origen = Integer.parseInt(token.nextToken());
                char simbolo = token.nextToken().charAt(0);
                int destino = Integer.parseInt(token.nextToken());
                afd.agregarTransicion(origen, simbolo, destino);
                linea = entrada.readLine();
            }
        }
        //si es un AFND
        else{
            afnd = new AFND();
            //leo la primera linea que es la que tiene los estados finales

                String linea = entrada.readLine();
                StringTokenizer token = new StringTokenizer(linea);
                token.nextToken();  //tiene EF:
                HashSet<Integer> estFin = new HashSet<>();
                while(token.hasMoreTokens()){
                    estFin.add(Integer.parseInt(token.nextToken()));
                }
                afnd.setEstadosFinales(estFin);

                linea = entrada.readLine(); //será la T de las transiciones
                linea = entrada.readLine();
                while(!linea.equals("L")){    //mientras no llegue a las transiciones lambda
                    token = new StringTokenizer(linea);
                    int origen = Integer.parseInt(token.nextToken());
                    char simbolo = token.nextToken().charAt(0);
                    HashSet<Integer> destinos = new HashSet<>();
                    while(token.hasMoreTokens()){
                        destinos.add(Integer.parseInt(token.nextToken()));
                    }
                    afnd.agregarTransicion(origen, simbolo, destinos);
                    linea = entrada.readLine();
                }

                linea = entrada.readLine();
                while(!linea.equals("EOF")){
                    token = new StringTokenizer(linea);
                    int origen = Integer.parseInt(token.nextToken());
                    HashSet<Integer> destinos = new HashSet<>();
                    while(token.hasMoreTokens()){
                        destinos.add(Integer.parseInt(token.nextToken()));
                    }
                    afnd.agregarTransicionLambda(origen, destinos);
                    linea = entrada.readLine();
                }
        } 
    }
    
    /**
     * Crea un fichero con la estructura graphviz y genera la imagen del autómata
     */
    public void crearFichero() throws IOException {
        HashSet<Integer> estFinales = new HashSet<>();
        
        if(opc == 0){
            
            estFinales = afd.getEstadosFinales();
            
            fgraph = new File("src\\graphviz\\AFD.txt");   //creamos el fichero con el nombre que tendrá
            
            salidaGraph = new BufferedWriter(new FileWriter(fgraph));
            salidaGraph.write("digraph AFD {\n");                
                      
        }
        else{
            
            estFinales = afnd.getEstadosFinales();
            
            fgraph = new File("src\\graphviz\\AFND.txt");   //creamos el fichero con el nombre que tendrá
            
            salidaGraph = new BufferedWriter(new FileWriter(fgraph));
            salidaGraph.write("digraph AFND {\n");
            
        }
        
        salidaGraph.write("\t rankdir=LR;\n");  //para que vaya de derecha a izquierda
        salidaGraph.write("\t size=\"8,5\"\n");
        salidaGraph.write("\t node [shape = doublecircle, style=filled, fillcolor=gray]; ");
        
        
        //Añadimos los estados finales
        int tam = estFinales.size() - 1;
        int contador = 0;
        for (Integer estado : estFinales){
            if(contador < tam){
                salidaGraph.write(estado + " ");
                contador++;
            }
            else{
                salidaGraph.write(estado + ";\n");
            }            
        }
        
        salidaGraph.write("\t node [shape = circle, fillcolor=white];\n");
        
        //Añadimos las transiciones
        if(opc == 0){
            HashSet<TransicionAFD> transiciones = afd.getTransiciones();
            
            for (TransicionAFD transicion : transiciones){
                int origen = transicion.getEstadoOrigen();
                char simbolo = transicion.getSimbolo();
                int destino = transicion.getEstadoDestino();
                
                salidaGraph.write("\t " + origen + " -> " + destino + " [ label = \"" + simbolo + "\" ];\n" );
            }   
        }
        
        else{
            HashSet<TransicionAFND> transiciones = afnd.getTransiciones();
            
            for (TransicionAFND transicion : transiciones){
                int origen = transicion.getEstadoOrigen();
                char simbolo = transicion.getSimbolo();
                HashSet<Integer> destinos = transicion.getEstadosDestino();
                
                for (Integer destino : destinos){
                    salidaGraph.write("\t " + origen + " -> " + destino + " [ label = \"" + simbolo + "\" ];\n" );
                }                
            }
            
            HashSet<TransicionLambda> transicionesL = afnd.getTransicionesLambda();
            char simbolo = 955; //955 = lambda
            
            for(TransicionLambda transicion : transicionesL){
                int origen = transicion.getEstadoOrigen();
                HashSet<Integer> destinos = transicion.getEstadosDestino();
                
                for(Integer destino : destinos){
                    salidaGraph.write("\t " + origen + " -> " + destino + " [ label = \"" + simbolo + "\" ];\n" );
                }
            }     
        }
 
        //Fin del fichero
        salidaGraph.write("}");
        salidaGraph.close();
        generarImagen();
    }
    
    /**
     * Genera una imagen jpg a partir de un fichero graphviz.
     */
    private void generarImagen() throws IOException {
        //ruta del ejecutable
        String path = "graphviz\\release\\bin\\dot.exe";
        
        //ruta del fichero y de la imagen de salida
        String filePath;
        if(opc == 0){
            filePath = "src\\graphviz\\AFD.txt";
            outPath = "src\\graphviz\\AFDs.jpg";
        }
        else{
            filePath = "src\\graphviz\\AFND.txt";
            outPath = "src\\graphviz\\AFNDs.jpg";
        }
        
        //tipo de imagen de salida
        String tParametro = "-Tjpg";
        String oParametro = "-o";
        
        //concatenamos los string para crear el comando de consola
        String[] cmd = new String[5];
        cmd[0] = path;
        cmd[1] = tParametro;
        cmd[2] = filePath;
        cmd[3] = oParametro;
        cmd[4] = outPath;
        
        Runtime rt = Runtime.getRuntime();
        
        //ejecutamos
        rt.exec(cmd);
    }
    
}
