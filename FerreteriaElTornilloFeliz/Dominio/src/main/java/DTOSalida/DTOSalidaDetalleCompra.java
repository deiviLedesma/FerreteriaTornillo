/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOSalida;

/**
 * DTOSalidaDetalleCompra: Item comprado (salida).
 *
 * @author SDavidLedesma
 */
public class DTOSalidaDetalleCompra {

    private String idProducto;
    private String nombreProducto;
    private int cantidad;
    private double precioUnitario;
    private double subtotal;

    /**
     * constructor por omision
     */
    public DTOSalidaDetalleCompra() {
    }

    /**
     * constructor que inicializa los atributos
     *
     * @param idProducto
     * @param nombreProducto
     * @param cantidad
     * @param precioUnitario
     * @param subtotal
     */
    public DTOSalidaDetalleCompra(String idProducto, String nombreProducto, int cantidad, double precioUnitario, double subtotal) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
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
        return "DTOSalidaDetalleCompra{" + "idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + ", subtotal=" + subtotal + '}';
    }

}
