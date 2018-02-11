/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AutomataFD;

import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import practica3.Proceso;

/**
 *
 * @author Ana
 */
public class AFD implements Cloneable, Proceso {
    /**
     * Indica cuáles son los estados finales.
     */
    private HashSet<Integer> estadosFinales;
    
    /**
     * Indica la lista de transiciones del AFD.
     */
    private HashSet<TransicionAFD> transiciones;
    
    /**
     * Constructor por defecto. Inicializa el autómata sin estados ni transiciones.
     */
    public AFD(){
        estadosFinales = new HashSet<>();
        transiciones = new HashSet<>();
    }
    
    /**
     * Añade una transición al autómata.
     * @param origen Estado desde el que parte la transición.
     * @param simbolo Símbolo de la transición.
     * @param destino Estado al que se llega desde origen con el símbolo 'simbolo'.
     */
    public void agregarTransicion(int origen, char simbolo, int destino){
        transiciones.add(new TransicionAFD(origen, simbolo, destino));
                
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
    public HashSet<TransicionAFD> getTransiciones() {
        return transiciones;
    } 
    
    /**
     * Busca el estado destino correspondiente al estado origen y al símbolo dado.
     * @param estado Estado origen.
     * @param simbolo Símbolo de la transición.
     * @return Estado destino de la transición o -1 en caso de que no exista dicha transición.
     */
    public int transicion(int estado, char simbolo){
        int destino = -1;
        
        for (TransicionAFD transicion : transiciones) {
            if(transicion.getEstadoOrigen() == estado 
                    && transicion.getSimbolo() == simbolo){
                destino = transicion.getEstadoDestino();
                break;
            }
        }
 
        return destino;
    }

    @Override
    public boolean esFinal(int estado) {
        return estadosFinales.contains(estado);
    }

    @Override
    public boolean reconocer(String cadena) {
        char[] simbolos = cadena.toCharArray();
        int estado = 0; //El estado inicial es siempre 0
        for(char simbolo : simbolos){
            estado = transicion(estado,simbolo);
        }
        
        return esFinal(estado);
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        AFD automata = new AFD();
        
        //copiamos cada transición en el nuevo autómata
        for(TransicionAFD transicion : transiciones){
            try {
                automata.transiciones.add((TransicionAFD) transicion.clone());
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(AFD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //copiamos cada estado final en el nuevo autómata
        for(Integer estado : estadosFinales){
            automata.estadosFinales.add(estado);
        }
        
        return automata;
    }
}
