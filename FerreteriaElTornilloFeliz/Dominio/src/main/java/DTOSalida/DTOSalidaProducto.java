/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOSalida;

/**
 * DTOSalidaProducto Representa los datos completos de un producto para mostrar.
 *
 * @author SDavidLedesma
 */
public class DTOSalidaProducto {

    private String idProducto;
    private String nombre;
    private String descripcion;
    private String idCategoria;
    private String categoria; // nombre
    private String idUnidadMedida;
    private String unidadMedida; // nombre
    private double precioCompra;
    private double precioVenta;
    private int existencias;
    private byte[] imagen; // opcional

    // Información extra para vistas, historial, alertas:
    private boolean bajoStock; // true si está bajo el límite configurado

    /**
     * constructor por omision
     */
    public DTOSalidaProducto() {
    }

    /**
     * constructor que inializa los atributos
     *
     * @param idProducto
     * @param nombre
     * @param descripcion
     * @param idCategoria
     * @param categoria
     * @param idUnidadMedida
     * @param unidadMedida
     * @param precioCompra
     * @param precioVenta
     * @param existencias
     * @param imagen
     * @param bajoStock
     */
    public DTOSalidaProducto(String idProducto, String nombre, String descripcion, String idCategoria, String categoria, String idUnidadMedida, String unidadMedida, double precioCompra, double precioVenta, int existencias, byte[] imagen, boolean bajoStock) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idCategoria = idCategoria;
        this.categoria = categoria;
        this.idUnidadMedida = idUnidadMedida;
        this.unidadMedida = unidadMedida;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.existencias = existencias;
        this.imagen = imagen;
        this.bajoStock = bajoStock;
    }

    // Getters y setters
    public String getIdProducto() {
        return idProducto;
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

    public boolean isBajoStock() {
        return bajoStock;
    }

    public void setBajoStock(boolean bajoStock) {
        this.bajoStock = bajoStock;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "DTOSalidaProducto{" + "idProducto=" + idProducto + ", nombre=" + nombre + ", descripcion=" + descripcion + ", idCategoria=" + idCategoria + ", categoria=" + categoria + ", idUnidadMedida=" + idUnidadMedida + ", unidadMedida=" + unidadMedida + ", precioCompra=" + precioCompra + ", precioVenta=" + precioVenta + ", existencias=" + existencias + ", imagen=" + imagen + ", bajoStock=" + bajoStock + '}';
    }

}
