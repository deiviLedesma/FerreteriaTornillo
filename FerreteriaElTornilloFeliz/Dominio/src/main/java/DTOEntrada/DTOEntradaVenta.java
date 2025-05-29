/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOEntrada;

import java.util.Date;
import java.util.List;

/**
 * DTOEntradaVenta: Registrar una venta.
 *
 * @author SDavidLedesma
 */
public class DTOEntradaVenta {

    private Date fechaHora;
    private List<DTOEntradaDetalleVenta> detalles;
    private double total;
    private String idUsuario;
    private String idCaja; // Relación a caja activa

    /**
     * constructor por omision
     */
    public DTOEntradaVenta() {
    }

    /**
     * constructor que incializa los atributos
     *
     * @param fechaHora
     * @param detalles
     * @param total
     * @param idUsuario
     * @param idCaja
     */
    public DTOEntradaVenta(Date fechaHora, List<DTOEntradaDetalleVenta> detalles, double total, String idUsuario, String idCaja) {
        this.fechaHora = fechaHora;
        this.detalles = detalles;
        this.total = total;
        this.idUsuario = idUsuario;
        this.idCaja = idCaja;
    }

    //getters y setters
    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public List<DTOEntradaDetalleVenta> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DTOEntradaDetalleVenta> detalles) {
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

    public String getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(String idCaja) {
        this.idCaja = idCaja;
    }

    @Override
    public String toString() {
        return "DTOEntradaVenta{" + "fechaHora=" + fechaHora + ", detalles=" + detalles + ", total=" + total + ", idUsuario=" + idUsuario + ", idCaja=" + idCaja + '}';
    }

}
