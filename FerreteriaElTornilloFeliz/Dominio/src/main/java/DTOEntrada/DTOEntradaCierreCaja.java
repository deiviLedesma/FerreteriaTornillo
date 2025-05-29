/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOEntrada;

import java.util.Date;

/**
 * DTOEntradaCierreCaja: Cierre de caja.
 *
 * @author SDavidLedesma
 */
public class DTOEntradaCierreCaja {

    private String idCaja;
    private Date fechaHoraCierre;
    private double montoFinal;
    private double totalVentas;
    private String observaciones; // opcional
    private String idUsuario; // responsable del cierre

    /**
     * constructor por omision
     */
    public DTOEntradaCierreCaja() {
    }

    /**
     * constructor que inicializa los atributos
     *
     * @param idCaja
     * @param fechaHoraCierre
     * @param montoFinal
     * @param totalVentas
     * @param observaciones
     * @param idUsuario
     */
    public DTOEntradaCierreCaja(String idCaja, Date fechaHoraCierre, double montoFinal, double totalVentas, String observaciones, String idUsuario) {
        this.idCaja = idCaja;
        this.fechaHoraCierre = fechaHoraCierre;
        this.montoFinal = montoFinal;
        this.totalVentas = totalVentas;
        this.observaciones = observaciones;
        this.idUsuario = idUsuario;
    }

    //getetrs y setters
    public String getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(String idCaja) {
        this.idCaja = idCaja;
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

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "DTOEntradaCierreCaja{" + "idCaja=" + idCaja + ", fechaHoraCierre=" + fechaHoraCierre + ", montoFinal=" + montoFinal + ", totalVentas=" + totalVentas + ", observaciones=" + observaciones + ", idUsuario=" + idUsuario + '}';
    }

}
