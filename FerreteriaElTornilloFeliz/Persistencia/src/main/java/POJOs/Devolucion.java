/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJOs;

import java.io.Serializable;
import java.util.Date;
import org.bson.types.ObjectId;

/**
 * Representa una devolución de producto o venta.
 *
 * @author SDavidLedesma
 */
public class Devolucion implements Serializable {

    private ObjectId id;
    private Date fecha;
    private String motivo;
    private ObjectId idUsuario;
    private String usuario;
    private String tipo; // "PRODUCTO" o "VENTA"
    private ObjectId idVenta; // opcional
    private String venta; // info venta
    private ObjectId idProducto; // opcional
    private String producto; // nombre producto
    private int cantidad;
    private String decision; // "REINTEGRAR" o "DESCARTAR"

    /**
     * constructor por omision
     */
    public Devolucion() {
    }

    /**
     * constructor que inicializa los atributos
     * @param id
     * @param fecha
     * @param motivo
     * @param idUsuario
     * @param usuario
     * @param tipo
     * @param idVenta
     * @param venta
     * @param idProducto
     * @param producto
     * @param cantidad
     * @param decision 
     */
    public Devolucion(ObjectId id, Date fecha, String motivo, ObjectId idUsuario, String usuario, String tipo, ObjectId idVenta, String venta, ObjectId idProducto, String producto, int cantidad, String decision) {
        this.id = id;
        this.fecha = fecha;
        this.motivo = motivo;
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.tipo = tipo;
        this.idVenta = idVenta;
        this.venta = venta;
        this.idProducto = idProducto;
        this.producto = producto;
        this.cantidad = cantidad;
        this.decision = decision;
    }

    //getters y setters
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ObjectId getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(ObjectId idVenta) {
        this.idVenta = idVenta;
    }

    public String getVenta() {
        return venta;
    }

    public void setVenta(String venta) {
        this.venta = venta;
    }

    public ObjectId getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(ObjectId idProducto) {
        this.idProducto = idProducto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    @Override
    public String toString() {
        return "Devolucion{" + "id=" + id + ", fecha=" + fecha + ", motivo=" + motivo + ", idUsuario=" + idUsuario + ", usuario=" + usuario + ", tipo=" + tipo + ", idVenta=" + idVenta + ", venta=" + venta + ", idProducto=" + idProducto + ", producto=" + producto + ", cantidad=" + cantidad + ", decision=" + decision + '}';
    }

}
