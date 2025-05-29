/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOSalida;

import java.util.Date;

/**
 * DTOSalidaCaja: Muestra datos completos de caja.
 *
 * @author SDavidLedesma
 */
public class DTOSalidaCaja {

    private String idCaja;
    private Date fechaHoraApertura;
    private double montoInicial;
    private Date fechaHoraCierre;
    private double montoFinal;
    private double totalVentas;
    private String observaciones;
    private String idUsuarioApertura;
    private String usuarioApertura; // nombre
    private String idUsuarioCierre;
    private String usuarioCierre; // nombre

    /**
     * constructor por omisino
     */
    public DTOSalidaCaja() {
    }

    /**
     * constructor que inicializa los atributos
     * @param idCaja
     * @param fechaHoraApertura
     * @param montoInicial
     * @param fechaHoraCierre
     * @param montoFinal
     * @param totalVentas
     * @param observaciones
     * @param idUsuarioApertura
     * @param usuarioApertura
     * @param idUsuarioCierre
     * @param usuarioCierre 
     */
    public DTOSalidaCaja(String idCaja, Date fechaHoraApertura, double montoInicial, Date fechaHoraCierre, double montoFinal, double totalVentas, String observaciones, String idUsuarioApertura, String usuarioApertura, String idUsuarioCierre, String usuarioCierre) {
        this.idCaja = idCaja;
        this.fechaHoraApertura = fechaHoraApertura;
        this.montoInicial = montoInicial;
        this.fechaHoraCierre = fechaHoraCierre;
        this.montoFinal = montoFinal;
        this.totalVentas = totalVentas;
        this.observaciones = observaciones;
        this.idUsuarioApertura = idUsuarioApertura;
        this.usuarioApertura = usuarioApertura;
        this.idUsuarioCierre = idUsuarioCierre;
        this.usuarioCierre = usuarioCierre;
    }

    //getters y setters
    public String getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(String idCaja) {
        this.idCaja = idCaja;
    }

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

    public Date getFechaHoraCierre() {
        return fechaHoraCierre;
    }

    public void setFechaHoraCierre(Date fechaHoraCierre) {
        this.fechaHoraCierre = fechaHoraCierre;
    }

    public double getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(double montoFinal) {
        this.montoFinal = montoFinal;
    }

    public double getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(double totalVentas) {
        this.totalVentas = totalVentas;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getIdUsuarioApertura() {
        return idUsuarioApertura;
    }

    public void setIdUsuarioApertura(String idUsuarioApertura) {
        this.idUsuarioApertura = idUsuarioApertura;
    }

    public String getUsuarioApertura() {
        return usuarioApertura;
    }

    public void setUsuarioApertura(String usuarioApertura) {
        this.usuarioApertura = usuarioApertura;
    }

    public String getIdUsuarioCierre() {
        return idUsuarioCierre;
    }

    public void setIdUsuarioCierre(String idUsuarioCierre) {
        this.idUsuarioCierre = idUsuarioCierre;
    }

    public String getUsuarioCierre() {
        return usuarioCierre;
    }

    public void setUsuarioCierre(String usuarioCierre) {
        this.usuarioCierre = usuarioCierre;
    }

    @Override
    public String toString() {
        return "DTOSalidaCaja{" + "idCaja=" + idCaja + ", fechaHoraApertura=" + fechaHoraApertura + ", montoInicial=" + montoInicial + ", fechaHoraCierre=" + fechaHoraCierre + ", montoFinal=" + montoFinal + ", totalVentas=" + totalVentas + ", observaciones=" + observaciones + ", idUsuarioApertura=" + idUsuarioApertura + ", usuarioApertura=" + usuarioApertura + ", idUsuarioCierre=" + idUsuarioCierre + ", usuarioCierre=" + usuarioCierre + '}';
    }
    
    
    
    
}
