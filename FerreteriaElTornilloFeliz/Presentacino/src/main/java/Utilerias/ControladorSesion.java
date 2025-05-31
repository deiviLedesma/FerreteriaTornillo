/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilerias;

import DTOSalida.DTOSalidaCaja;
import DTOSalida.DTOSalidaUsuario;

/**
 *
 * @author SDavidLedesma
 */
public class ControladorSesion {

    private static ControladorSesion instancia;
    private DTOSalidaUsuario usuarioActual;
    private DTOSalidaCaja cajaActiva;

    public static ControladorSesion getInstancia() {
        if (instancia == null) {
            instancia = new ControladorSesion();
        }

        return instancia;
    }

    public void iniciarSesion(DTOSalidaUsuario usuario) {
        this.usuarioActual = usuario;
    }

    public DTOSalidaUsuario getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(DTOSalidaUsuario usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    public DTOSalidaCaja getCajaActiva() {
        return cajaActiva;
    }

    public void setCajaActiva(DTOSalidaCaja cajaActiva) {
        this.cajaActiva = cajaActiva;
    }

    public void cerrarSesion() {
        usuarioActual = null;
        cajaActiva = null;
    }
}
