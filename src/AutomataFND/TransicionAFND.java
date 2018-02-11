/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AutomataFND;

import java.util.HashSet;
import java.util.Objects;

/**
 *
 * @author ana
 */
public class TransicionAFND implements Cloneable{
    
    private final int estadoOrigen;
    private final char simbolo;
    private final HashSet<Integer> estadosDestino;
    
    /**
     * Constructor.
     * @param estadoOrigen Estado inicial de la transición.
     * @param simbolo Símbolo con el que se llega a los estados destinos desde el estado origen.
     * @param estadosDestino Estados a los que se puede llegar desde el estado origen
     * consumiendo el símbolo pasado por parámetro.
     */
    public TransicionAFND(int estadoOrigen, char simbolo, HashSet<Integer> estadosDestino){
        this.estadoOrigen = estadoOrigen;
        this.simbolo = simbolo;
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
     * Devuelve el símbolo de la transición.
     * @return Símbolo de la transición.
     */
    public char getSimbolo() {
        return simbolo;
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
        int hash = this.estadoOrigen;
        hash = 41 * hash + this.estadoOrigen;
        hash = 41 * hash + this.simbolo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TransicionAFND other = (TransicionAFND) obj;
        if (this.estadoOrigen != other.estadoOrigen) {
            return false;
        }
        if (this.simbolo != other.simbolo) {
            return false;
        }
        return Objects.equals(this.estadosDestino, other.estadosDestino);
    }
   
    @Override
    protected Object clone() throws CloneNotSupportedException {

        TransicionAFND transicion = new TransicionAFND(this.estadoOrigen, this.simbolo, new HashSet<>());

        for (int estado : estadosDestino)
            transicion.estadosDestino.add(estado);

        return transicion;
    }

}
