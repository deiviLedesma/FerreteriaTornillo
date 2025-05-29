/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOEntrada;

/**
 * DTOEntradaProducto Representa los datos para crear o actualizar un producto.
 *
 * @author SDavidLedesma
 */
public class DTOEntradaProducto {

    private String nombre;
    private String descripcion;
    private String idCategoria;
    private String idUnidadMedida;
    private double precioCompra;
    private double precioVenta;
    private int existencias;
    private byte[] imagen; // opcional

    /**
     * constructor por omision
     */
    public DTOEntradaProducto() {
    }

    /**
     * constructor que inicializa los atributos
     *
     * @param nombre
     * @param descripcion
     * @param idCategoria
     * @param idUnidadMedida
     * @param precioCompra
     * @param precioVenta
     * @param existencias
     * @param imagen
     */
    public DTOEntradaProducto(String nombre, String descripcion, String idCategoria, String idUnidadMedida, double precioCompra, double precioVenta, int existencias, byte[] imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idCategoria = idCategoria;
        this.idUnidadMedida = idUnidadMedida;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.existencias = existencias;
        this.imagen = imagen;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(String idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "DTOEntradaProducto{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", precioCompra=" + precioCompra + ", precioVenta=" + precioVenta + ", existencias=" + existencias + ", idCategoria=" + idCategoria + ", idUnidadMedida=" + idUnidadMedida + ", imagen=" + imagen + '}';
    }

}
