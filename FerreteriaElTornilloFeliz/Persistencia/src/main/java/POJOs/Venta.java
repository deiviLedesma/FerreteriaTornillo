/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJOs;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Representa una venta de productos.
 *
 * @author SDavidLedesma
 */
public class Venta implements Serializable {

    private ObjectId id;
    private Date fechaHora;
    private List<DetalleVenta> detalles;
    private double total;
    private ObjectId idUsuario;
    private String usuario; // nombre usuario
    private ObjectId idCaja;
    private String caja; // nombre caja

    /**
     * constructor por omision
     */
    public Venta() {
    }

    /**
     * constructor que inicializa los atributos
     *
     * @param id
     * @param fechaHora
     * @param detalles
     * @param total
     * @param idUsuario
     * @param usuario
     * @param idCaja
     * @param caja
     */
    public Venta(ObjectId id, Date fechaHora, List<DetalleVenta> detalles, double total, ObjectId idUsuario, String usuario, ObjectId idCaja, String caja) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.detalles = detalles;
        this.total = total;
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.idCaja = idCaja;
        this.caja = caja;
    }

    //getters y setters
    public ObjectId getId() {
        return id;
    }
    
    

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public List<DetalleVenta> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleVenta> detalles) {
        this.detalles = detalles;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ObjectId getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(ObjectId idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public ObjectId getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(ObjectId idCaja) {
        this.idCaja = idCaja;
    }

    public String getCaja() {
        return caja;
    }

    public void setCaja(String caja) {
        this.caja = caja;
    }

    @Override
    public String toString() {
        return "Venta{" + "id=" + id + ", fechaHora=" + fechaHora + ", detalles=" + detalles + ", total=" + total + ", idUsuario=" + idUsuario + ", usuario=" + usuario + ", idCaja=" + idCaja + ", caja=" + caja + '}';
    }

}
