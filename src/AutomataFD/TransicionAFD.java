/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AutomataFD;

/**
 *
 * @author Ana
 */
public class TransicionAFD implements Cloneable{
    
    private final int estadoOrigen;
    private final char simbolo;
    private final int estadoDestino;    
    
    /**
     * Constructor que crea una transición con los atributos pasados como parámtros.
     * @param estadoOrigen Estado del que parte la transición.
     * @param simbolo Símbolo de la transición.
     * @param estadoDestino  Estado al que llega la transición a través del símbolo.
     */
    public TransicionAFD(int estadoOrigen, char simbolo, int estadoDestino){
        this.estadoOrigen = estadoOrigen;
        this.simbolo = simbolo;
        this.estadoDestino = estadoDestino;
    }

    /**
     * Devuelve el estado final de la transición.
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
     * Devuelve el estado destino de la transición.
     * @return Estado destino de la transición.
     */
    public int getEstadoDestino() {
        return estadoDestino;
    }
    
    /**
     * 
     * @param obj Objeto a comparar.
     * @return True si ambos objetos son la misma transición, False en caso contrario.
     */
    @Override
    public boolean equals(Object obj){
        if(obj == null)
            return false;
        else if(obj == this)
            return true;
        else if(obj instanceof TransicionAFD){
            TransicionAFD afd = (TransicionAFD) obj;
            return afd.estadoOrigen == this.estadoOrigen &&
                    afd.estadoDestino == this.estadoDestino &&
                    afd.simbolo == this.simbolo;
        }
        else
            return false;        
    }

    @Override
    public int hashCode() {
        int hash = this.estadoOrigen;
        hash = 41 * hash + this.estadoOrigen;
        hash = 41 * hash + this.simbolo;
        hash = 41 * hash + this.estadoDestino;
        return hash;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
}
