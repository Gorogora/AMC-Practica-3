/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3;

/**
 *
 * @author Ana
 */
public interface Proceso {
    /**
     * Comprueba si un estado es final.
     * @param estado Estado a comprobar.
     * @return True si el estado es final, False en caso contrario.
     */
    public abstract boolean esFinal(int estado);
    
    /**
     * Analiza si la cadena pasada como parámetro pertenece al lenguaje descrito por el autómata.
     * @param cadena Cadena de texto a reconocer por el autómata.
     * @return True si la cadena es reconocida por el autómata, False en caso contrario.
     */
    public abstract boolean reconocer(String cadena);
    
    /**
     * Muestra las transiciones y estados finales.
     * @return String con las transiciones y estados finales.
     */
    @Override
    public abstract String toString();

    
    
}
