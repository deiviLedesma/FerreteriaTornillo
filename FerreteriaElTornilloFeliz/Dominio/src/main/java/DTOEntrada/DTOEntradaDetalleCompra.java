/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOEntrada;

/**
 * DTOEntradaDetalleCompra: Item comprado (entrada).
 *
 * @author SDavidLedesma
 */
public class DTOEntradaDetalleCompra {

    private String idProducto;
    private int cantidad;
    private double precioUnitario;

    /**
     * constructor por omision
     */
    public DTOEntradaDetalleCompra() {
    }

    /**
     * constructor que inicializa los atributos
     *
     * @param idProducto
     * @param cantidad
     * @param precioUnitario
     */
    public DTOEntradaDetalleCompra(String idProducto, int cantidad, double precioUnitario) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    //getters y setters
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

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    @Override
    public String toString() {
        return "DTOEntradaDetalleCompra{" + "idProducto=" + idProducto + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + '}';
    }

}
