/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOSalida;

import java.util.Date;
import java.util.List;

/**
 * DTOSalidaCompra: Compra completa (salida).
 *
 * @author SDavidLedesma
 */
public class DTOSalidaCompra {

    private String idCompra;
    private Date fechaHora;
    private String idProveedor;
    private String proveedor; // nombre proveedor
    private List<DTOSalidaDetalleCompra> detalles;
    private double total;
    private String idUsuario;
    private String usuario; // nombre usuario

    /**
     * constructor por omision
     */
    public DTOSalidaCompra() {
    }

    /**
     * constructor que incializa los atributos
     *
     * @param idCompra
     * @param fechaHora
     * @param idProveedor
     * @param proveedor
     * @param detalles
     * @param total
     * @param idUsuario
     * @param usuario
     */
    public DTOSalidaCompra(String idCompra, Date fechaHora, String idProveedor, String proveedor, List<DTOSalidaDetalleCompra> detalles, double total, String idUsuario, String usuario) {
        this.idCompra = idCompra;
        this.fechaHora = fechaHora;
        this.idProveedor = idProveedor;
        this.proveedor = proveedor;
        this.detalles = detalles;
        this.total = total;
        this.idUsuario = idUsuario;
        this.usuario = usuario;
    }

    public String getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(String idCompra) {
        this.idCompra = idCompra;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public List<DTOSalidaDetalleCompra> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DTOSalidaDetalleCompra> detalles) {
        this.detalles = detalles;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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

    @Override
    public String toString() {
        return "DTOSalidaCompra{" + "idCompra=" + idCompra + ", fechaHora=" + fechaHora + ", idProveedor=" + idProveedor + ", proveedor=" + proveedor + ", detalles=" + detalles + ", total=" + total + ", idUsuario=" + idUsuario + ", usuario=" + usuario + '}';
    }

}
