/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AutomataFND;

import java.util.HashSet;
import practica3.Proceso;

/**
 *
 * @author ana
 */
public class AFND implements Cloneable, Proceso{

    /**
     * Indica cuáles son los estados finales
     */
    private HashSet<Integer> estadosFinales;
    
    /**
     * Indica la lista de transiciones del AFND
     */
    private HashSet<TransicionAFND> transiciones;
    
    /**
     * Indica la lista de transiciones lambda
     */
    private HashSet<TransicionLambda> transicionesLambda;
    
    /**
     * Constructor por defecto. Inicializa el autómata sin estados ni transiciones.
     */
    public AFND(){
        estadosFinales = new HashSet<>();
        transiciones = new HashSet<>();
        transicionesLambda = new HashSet<>();
    }
    
    /**
     * Agrega una transición al autómata.
     * @param estadoOrigen Estado del que parte la transición.
     * @param simbolo Simbolo que se consume en la transición.
     * @param estadosFinales Estados a los que se puede llegar desde ese 'estadoOrigen' y ese 'símbolo'.
     */
    public void agregarTransicion(int estadoOrigen, char simbolo, HashSet<Integer> estadosFinales){
        transiciones.add(new TransicionAFND(estadoOrigen, simbolo, estadosFinales));
    }
    
    /**
     * Agrega una transición lambda al autómata.
     * @param origen Estado del que parte la transición.
     * @param estadosDestino Estados a los que se puede llegar desde el estado 
     * 'origen' mediante transiciones lambda.
     */
    public void agregarTransicionLambda(int origen, HashSet<Integer> estadosDestino){
        transicionesLambda.add(new TransicionLambda(origen, estadosDestino));
    }

    /**
     * Pone como estados finales del autómata los pasado como parámetros.
     * @param estadosFinales Estados finales del autómata.
     */
    public void setEstadosFinales(HashSet<Integer> estadosFinales) {
        this.estadosFinales = estadosFinales;
    }
    
    /**
     * Devuelve los estados finales del autómata.
     * @return los estados finales del autómata.
     */
    public HashSet<Integer> getEstadosFinales() {
        return estadosFinales;
    }

    /**
     * Devuelve las transiciones del autómata.
     * @return las transiciones del autómata.
     */
    public HashSet<TransicionAFND> getTransiciones() {
        return transiciones;
    }

    /**
     * Devuelve las transiciones lambdas del autómata.
     * @return las transiciones lambdas del autómata.
     */
    public HashSet<TransicionLambda> getTransicionesLambda() {
        return transicionesLambda;
    }
        
    @Override
    public boolean esFinal(int estado) {
        return estadosFinales.contains(estado);
    }
    
    /**
     * Comprueba si algún estado del macroestado es final y por tanto lo es el macroestado.
     * @param macroestado Macroestado que se quiere analizar.
     * @return True si algún estado del macroestado es final, False en caso contrario.
     */
    public boolean esFinal(HashSet<Integer> macroestado){
        for(Integer estado : macroestado){
            if(esFinal(estado))
                return true;
        }        
        return false;
    }

    /**
     * Busca los estdos a los que llega la transición para ese origen y ese símbolo si existe dicha transición.
     * @param estado Estado desde el que parte la transición.
     * @param simbolo Símbolo que se consume en la transición.
     * @return Conjunto de estados a los que se puede llegar partiendo del estado 
     * pasado como parámetro y consumiendo el símbolo pasada como parámetro.
     */
    public HashSet<Integer> transicion(int estado, char simbolo){
        HashSet<Integer> macroestado = new HashSet<>();
        for(TransicionAFND transicion :  transiciones){
            if(transicion.getEstadoOrigen() == estado
                    && transicion.getSimbolo() == simbolo){
                macroestado.addAll(transicion.getEstadosDestino());
                break;
            }                
        }
        
        return macroestado;
    }
    
    /**
     * Busca todas las transiciones posibles a partir de un macroestado y un símbolo.
     * @param macroestado Macroestado que se quiere analizar.
     * @param simbolo Símbolo que se consume en la transición que se busca.
     * @return 
     */
    public HashSet<Integer> transicion(HashSet<Integer> macroestado, char simbolo){
        HashSet<Integer> macro = new HashSet<>();
        
        for(Integer estado : macroestado){
            macro.addAll(transicion(estado,simbolo));
        }
        
        macro.addAll(lambda_clausura(macroestado));
        
        return macro;
    }
    
    /**
     * Busca todos los estados a los que se puede llegar partiendo del estado pasado 
     * como parátro sin consumir ningún símbolo.
     * @param estado Estado origen de las transiciones.
     * @return Conjunto de estados a los que se puede llegar sin consumir ningún 
     * símbolo partiendo del estado pasado como parámetro.
     */
    public HashSet<Integer> transicionLambda(int estado){
        HashSet<Integer> macro = new HashSet<>();
         
        for(TransicionLambda transicion : transicionesLambda){
            if(transicion.getEstadoOrigen() == estado){
                macro.addAll(transicion.getEstadosDestino());
                break;
            }
        }
        return macro;
    }
    
    /**
     * Calcula la lambda-clausura de un estado.
     * @param macroestado Macroestado inicial.
     * @return lambda-clausura del macroestado pasado como parámetro.
     */        
    public HashSet<Integer> lambda_clausura(HashSet<Integer> macroestado){
        HashSet<Integer> clausura = new HashSet<>();
        
        for(Integer estado : macroestado){  //para cada estado del macroestado miro si tiene lambda transiciones
            HashSet<Integer> aux = transicionLambda(estado);
            if(!aux.isEmpty()){    //si tiene transiciones lambda
                clausura.addAll(aux);   //añado todos los estados a la clausura y calculo la clausura de estos también
                lambda_clausura(clausura);
            }
        }
        
        return clausura;        
    }
    
    @Override
    public boolean reconocer(String cadena) {
        char[] simbolos = cadena.toCharArray();
        HashSet<Integer> macroestado = new HashSet<>();
        macroestado.add(0);
        macroestado.addAll(lambda_clausura(macroestado));
        
        for(char simbolo : simbolos){
            macroestado = transicion(macroestado, simbolo);
        }
        
        return esFinal(macroestado);
        
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException{
        AFND automata = new AFND();
        
        for (int estado : estadosFinales){
            automata.estadosFinales.add(estado);
        } 
        
        for (TransicionAFND transicion : transiciones){
            automata.transiciones.add((TransicionAFND) transicion.clone());
        }
        
        for (TransicionLambda transicion : transicionesLambda) {
            automata.transicionesLambda.add((TransicionLambda) transicion.clone());
        }
        
        return automata;
    }
}
