/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOSalida;

import java.util.Date;

/**
 * DTOSalidaDevolucion: Datos completos de devolución.
 *
 * @author SDavidLedesma
 */
public class DTOSalidaDevolucion {

    private String idDevolucion;
    private Date fecha;
    private String motivo;
    private String idUsuario;
    private String usuario; // nombre
    private String tipo;
    private String idVenta;
    private String venta; // info venta
    private String idProducto;
    private String producto; // nombre producto
    private int cantidad;
    private String decision;

    /**
     * constructor por omision
     */
    public DTOSalidaDevolucion() {
    }

    /**
     * constructor que incializa los atributos
     * @param idDevolucion
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
    public DTOSalidaDevolucion(String idDevolucion, Date fecha, String motivo, String idUsuario, String usuario, String tipo, String idVenta, String venta, String idProducto, String producto, int cantidad, String decision) {
        this.idDevolucion = idDevolucion;
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
    public String getIdDevolucion() {
        return idDevolucion;
    }

    public void setIdDevolucion(String idDevolucion) {
        this.idDevolucion = idDevolucion;
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

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
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

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public String getVenta() {
        return venta;
    }

    public void setVenta(String venta) {
        this.venta = venta;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
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
        return "DTOSalidaDevolucion{" + "idDevolucion=" + idDevolucion + ", fecha=" + fecha + ", motivo=" + motivo + ", idUsuario=" + idUsuario + ", usuario=" + usuario + ", tipo=" + tipo + ", idVenta=" + idVenta + ", venta=" + venta + ", idProducto=" + idProducto + ", producto=" + producto + ", cantidad=" + cantidad + ", decision=" + decision + '}';
    }
    
    
    
    
}
