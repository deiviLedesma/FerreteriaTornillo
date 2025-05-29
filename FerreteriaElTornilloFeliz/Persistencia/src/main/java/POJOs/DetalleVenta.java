/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJOs;

import java.io.Serializable;
import org.bson.types.ObjectId;

/**
 * Representa un producto vendido en una venta.
 *
 * @author SDavidLedesma
 */
public class DetalleVenta implements Serializable {

    private ObjectId idProducto;
    private String nombreProducto; // Redundancia útil para reportes
    private int cantidad;
    private double precioUnitario;
    private double subtotal;

    /**
     * constructor por omision
     */
    public DetalleVenta() {
    }

    /**
     * contructor para inicializar los ataributos
     * @param idProducto
     * @param nombreProducto
     * @param cantidad
     * @param precioUnitario
     * @param subtotal 
     */
    public DetalleVenta(ObjectId idProducto, String nombreProducto, int cantidad, double precioUnitario, double subtotal) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
    }

    //getters y setters
    public ObjectId getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(ObjectId idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" + "idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + ", subtotal=" + subtotal + '}';
    }

}
