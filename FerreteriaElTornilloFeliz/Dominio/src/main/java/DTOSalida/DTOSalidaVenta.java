/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOSalida;

import java.util.Date;
import java.util.List;

/**
 * DTOSalidaVenta: Venta completa (salida).
 *
 * @author SDavidLedesma
 */
public class DTOSalidaVenta {

    private String idVenta;
    private Date fechaHora;
    private List<DTOSalidaDetalleVenta> detalles;
    private double total;
    private String idUsuario;
    private String usuario; // nombre
    private String idCaja;
    private String caja; // identificador o nombre caja

    /**
     * constructor por omision
     */
    public DTOSalidaVenta() {
    }

    /**
     * constructor que incializa los atributos
     *
     * @param idVenta
     * @param fechaHora
     * @param detalles
     * @param total
     * @param idUsuario
     * @param usuario
     * @param idCaja
     * @param caja
     */
    public DTOSalidaVenta(String idVenta, Date fechaHora, List<DTOSalidaDetalleVenta> detalles, double total, String idUsuario, String usuario, String idCaja, String caja) {
        this.idVenta = idVenta;
        this.fechaHora = fechaHora;
        this.detalles = detalles;
        this.total = total;
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.idCaja = idCaja;
        this.caja = caja;
    }

    //getters y setters
    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public List<DTOSalidaDetalleVenta> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DTOSalidaDetalleVenta> detalles) {
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

    public String getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(String idCaja) {
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
        return "DTOSalidaVenta{" + "idVenta=" + idVenta + ", fechaHora=" + fechaHora + ", detalles=" + detalles + ", total=" + total + ", idUsuario=" + idUsuario + ", usuario=" + usuario + ", idCaja=" + idCaja + ", caja=" + caja + '}';
    }

}
