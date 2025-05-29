/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOEntrada;

import java.util.Date;

/**
 * DTOEntradaDevolucion: Registrar devolución.
 *
 * @author SDavidLedesma
 */
public class DTOEntradaDevolucion {

    private Date fecha;
    private String motivo;
    private String idUsuario;
    private String tipo; // "PRODUCTO" o "VENTA"
    private String idVenta; // opcional
    private String idProducto; // opcional
    private int cantidad; // cantidad de producto (si aplica)
    private String decision; // "REINTEGRAR" o "DESCARTAR"

    /**
     * constructor por omision
     */
    public DTOEntradaDevolucion() {
    }

    /**
     * constructor que inicializa los atributos
     *
     * @param fecha
     * @param motivo
     * @param idUsuario
     * @param tipo
     * @param idVenta
     * @param idProducto
     * @param cantidad
     * @param decision
     */
    public DTOEntradaDevolucion(Date fecha, String motivo, String idUsuario, String tipo, String idVenta, String idProducto, int cantidad, String decision) {
        this.fecha = fecha;
        this.motivo = motivo;
        this.idUsuario = idUsuario;
        this.tipo = tipo;
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.decision = decision;
    }

    //getters y setters
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

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
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
        return "DTOEntradaDevolucion{" + "fecha=" + fecha + ", motivo=" + motivo + ", idUsuario=" + idUsuario + ", tipo=" + tipo + ", idVenta=" + idVenta + ", idProducto=" + idProducto + ", cantidad=" + cantidad + ", decision=" + decision + '}';
    }

}
