/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepcion;

/**
 * Maneja todas las excepciones del paquete persistencia.
 *
 * @author SDavidLedesma
 */
public class PersistenciaException extends Exception {

    /**
     * constructor por omision
     */
    public PersistenciaException() {
    }

    /**
     * constructor que permite personalizar el mensaje
     *
     * @param message
     */
    public PersistenciaException(String message) {
        super(message);
    }

    /**
     * constructor que permite personalizar el mensaje y mostrar la cauda del
     * error
     *
     * @param message
     * @param cause
     */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

}
