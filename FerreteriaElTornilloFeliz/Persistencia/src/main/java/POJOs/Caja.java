/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJOs;

import java.io.Serializable;
import java.util.Date;
import org.bson.types.ObjectId;

/**
 * Representa la caja diaria de la ferretería.
 *
 * @author SDavidLedesma
 */
public class Caja implements Serializable {

    private ObjectId id;
    private Date fechaHoraApertura;
    private double montoInicial;
    private Date fechaHoraCierre;
    private double montoFinal;
    private double totalVentas;
    private String observaciones;
    private ObjectId idUsuarioApertura;
    private String usuarioApertura;
    private ObjectId idUsuarioCierre;
    private String usuarioCierre;

    /**
     * constructor por omisino
     */
    public Caja() {
    }

    /**
     * constructor que incializa los atributos
     *
     * @param id
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
    public Caja(ObjectId id, Date fechaHoraApertura, double montoInicial, Date fechaHoraCierre, double montoFinal, double totalVentas, String observaciones, ObjectId idUsuarioApertura, String usuarioApertura, ObjectId idUsuarioCierre, String usuarioCierre) {
        this.id = id;
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
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
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

    public ObjectId getIdUsuarioApertura() {
        return idUsuarioApertura;
    }

    public void setIdUsuarioApertura(ObjectId idUsuarioApertura) {
        this.idUsuarioApertura = idUsuarioApertura;
    }

    public String getUsuarioApertura() {
        return usuarioApertura;
    }

    public void setUsuarioApertura(String usuarioApertura) {
        this.usuarioApertura = usuarioApertura;
    }

    public ObjectId getIdUsuarioCierre() {
        return idUsuarioCierre;
    }

    public void setIdUsuarioCierre(ObjectId idUsuarioCierre) {
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
        return "Caja{" + "id=" + id + ", fechaHoraApertura=" + fechaHoraApertura + ", montoInicial=" + montoInicial + ", fechaHoraCierre=" + fechaHoraCierre + ", montoFinal=" + montoFinal + ", totalVentas=" + totalVentas + ", observaciones=" + observaciones + ", idUsuarioApertura=" + idUsuarioApertura + ", usuarioApertura=" + usuarioApertura + ", idUsuarioCierre=" + idUsuarioCierre + ", usuarioCierre=" + usuarioCierre + '}';
    }

}
