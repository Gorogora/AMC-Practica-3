/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AutomataFND;

import java.util.HashSet;
/**
 *
 * @author ana
 */
public class TransicionLambda implements Cloneable{
    
    private final int estadoOrigen;
    private final HashSet<Integer> estadosDestino;

    /**
     * Constructor.
     * @param estadoOrigen Estado origen de la transición.
     * @param estadosDestino Estados a los que se puede llegar desde el estado origen.
     */
    public TransicionLambda(int estadoOrigen, HashSet<Integer> estadosDestino) {
        this.estadoOrigen = estadoOrigen;
        this.estadosDestino = estadosDestino;
    }

    /**
     * Devuelve el estado inicial de la transición.
     * @return Estado inicial de la transición.
     */
    public int getEstadoOrigen() {
        return estadoOrigen;
    }

    /**
     * Devuelve el conjunto de estados destinos de la transición.
     * @return Conjunto de estados destino de la transición.
     */
    public HashSet<Integer> getEstadosDestino() {
        return estadosDestino;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.estadoOrigen;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {


	if (getClass () != obj.getClass ())  { 
             return false; 
	}
        else {
           TransicionLambda ob = (TransicionLambda) obj;
           return this.estadoOrigen == ob.estadoOrigen;
         }	

    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new TransicionLambda(this.estadoOrigen, this.estadosDestino);
    }
    
}
