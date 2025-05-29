/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOEntrada;

import java.util.Date;

/**
 * DTOEntradaCaja: Abrir una caja.
 *
 * @author SDavidLedesma
 */
public class DTOEntradaCaja {

    private Date fechaHoraApertura;
    private double montoInicial;
    private String idUsuario; // responsable

    /**
     * constructor por omision
     */
    public DTOEntradaCaja() {
    }

    /**
     * constructor que inicializa los atributos
     *
     * @param fechaHoraApertura
     * @param montoInicial
     * @param idUsuario
     */
    public DTOEntradaCaja(Date fechaHoraApertura, double montoInicial, String idUsuario) {
        this.fechaHoraApertura = fechaHoraApertura;
        this.montoInicial = montoInicial;
        this.idUsuario = idUsuario;
    }

    //getters y setters
    public Date getFechaHoraApertura() {
        return fechaHoraApertura;
    }

    public void setFechaHoraApertura(Date fechaHoraApertura) {
        this.fechaHoraApertura = fechaHoraApertura;
    }

    public double getMontoInicial() {
        return montoInicial;
    }

    public void setMontoInicial(double montoInicial) {
        this.montoInicial = montoInicial;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "DTOEntradaCaja{" + "fechaHoraApertura=" + fechaHoraApertura + ", montoInicial=" + montoInicial + ", idUsuario=" + idUsuario + '}';
    }

}
