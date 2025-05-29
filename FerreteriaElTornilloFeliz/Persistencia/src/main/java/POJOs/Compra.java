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
 * Representa una compra de productos.
 *
 * @author SDavidLedesma
 */
public class Compra implements Serializable {

    private ObjectId id;
    private Date fechaHora;
    private ObjectId idProveedor;
    private String proveedor; // nombre proveedor
    private List<DetalleCompra> detalles;
    private double total;
    private ObjectId idUsuario;
    private String usuario; // nombre usuario

    /**
     * constructor por omisoin
     */
    public Compra() {

    }

    /**
     * constructor que incializa los atributos
     * @param id
     * @param fechaHora
     * @param idProveedor
     * @param proveedor
     * @param detalles
     * @param total
     * @param idUsuario
     * @param usuario 
     */
    public Compra(ObjectId id, Date fechaHora, ObjectId idProveedor, String proveedor, List<DetalleCompra> detalles, double total, ObjectId idUsuario, String usuario) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.idProveedor = idProveedor;
        this.proveedor = proveedor;
        this.detalles = detalles;
        this.total = total;
        this.idUsuario = idUsuario;
        this.usuario = usuario;
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

    public ObjectId getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(ObjectId idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public List<DetalleCompra> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleCompra> detalles) {
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

    @Override
    public String toString() {
        return "Compra{" + "id=" + id + ", fechaHora=" + fechaHora + ", idProveedor=" + idProveedor + ", proveedor=" + proveedor + ", detalles=" + detalles + ", total=" + total + ", idUsuario=" + idUsuario + ", usuario=" + usuario + '}';
    }

}
