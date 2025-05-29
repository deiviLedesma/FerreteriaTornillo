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

    private String idProdicto;
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
     * @param idProdicto
     * @param cantidad
     * @param precioUnitario
     */
    public DTOEntradaDetalleCompra(String idProdicto, int cantidad, double precioUnitario) {
        this.idProdicto = idProdicto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    //getters y setters
    public String getIdProdicto() {
        return idProdicto;
    }

    public void setIdProdicto(String idProdicto) {
        this.idProdicto = idProdicto;
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
        return "DTOEntradaDetalleCompra{" + "idProdicto=" + idProdicto + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + '}';
    }

}
