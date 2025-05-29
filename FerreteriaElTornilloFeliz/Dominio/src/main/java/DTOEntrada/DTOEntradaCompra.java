/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOEntrada;

import java.util.Date;
import java.util.List;

/**
 * DTOEntradaCompra: Datos para registrar una compra.
 *
 * @author SDavidLedesma
 */
public class DTOEntradaCompra {

    private Date fechaHora;
    private String idProveedor; // opcional
    private List<DTOEntradaDetalleCompra> detalles;
    private double total;
    private String idUsuario;

    /**
     * constructor por omision
     */
    public DTOEntradaCompra() {
    }

    /**
     * constructor que inicializa los atributos
     *
     * @param fechaHora
     * @param idProveedor
     * @param detalles
     * @param total
     * @param idUsuario
     */
    public DTOEntradaCompra(Date fechaHora, String idProveedor, List<DTOEntradaDetalleCompra> detalles, double total, String idUsuario) {
        this.fechaHora = fechaHora;
        this.idProveedor = idProveedor;
        this.detalles = detalles;
        this.total = total;
        this.idUsuario = idUsuario;
    }

    //getters y setters
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

    public List<DTOEntradaDetalleCompra> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DTOEntradaDetalleCompra> detalles) {
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

    @Override
    public String toString() {
        return "DTOEntradaCompra{" + "fechaHora=" + fechaHora + ", idProveedor=" + idProveedor + ", detalles=" + detalles + ", total=" + total + ", idUsuario=" + idUsuario + '}';
    }

}
