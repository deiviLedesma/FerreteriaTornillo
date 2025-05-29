/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJOs;

import java.io.Serializable;
import org.bson.types.ObjectId;

/**
 * Representa un producto de inventario.
 *
 * @author SDavidLedesma
 */
public class Producto implements Serializable {

    private ObjectId id;
    private String nombre;
    private String descripcion;
    private ObjectId idCategoria;
    private ObjectId idUnidadMedida;
    private double precioCompra;
    private double precioVenta;
    private int existencias;
    private byte[] imagen; // Opcional
    private boolean bajoStock; // Para alertas
    private String fechaAlta; // Opcional, formato ISO8601
    private String fechaModificacion;

    /**
     * constructor por omision
     */
    public Producto() {

    }

    /**
     * constructor que incializa los atributos
     *
     * @param id
     * @param nombre
     * @param descripcion
     * @param idCategoria
     * @param idUnidadMedida
     * @param precioCompra
     * @param precioVenta
     * @param existencias
     * @param imagen
     * @param bajoStock
     * @param fechaAlta
     * @param fechaModificacion
     */
    public Producto(ObjectId id, String nombre, String descripcion, ObjectId idCategoria, ObjectId idUnidadMedida, double precioCompra, double precioVenta, int existencias, byte[] imagen, boolean bajoStock, String fechaAlta, String fechaModificacion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idCategoria = idCategoria;
        this.idUnidadMedida = idUnidadMedida;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.existencias = existencias;
        this.imagen = imagen;
        this.bajoStock = bajoStock;
        this.fechaAlta = fechaAlta;
        this.fechaModificacion = fechaModificacion;
    }

    //getters y setters
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
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

    public ObjectId getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(ObjectId idCategoria) {
        this.idCategoria = idCategoria;
    }

    public ObjectId getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(ObjectId idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
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

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public boolean isBajoStock() {
        return bajoStock;
    }

    public void setBajoStock(boolean bajoStock) {
        this.bajoStock = bajoStock;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", idCategoria=" + idCategoria + ", idUnidadMedida=" + idUnidadMedida + ", precioCompra=" + precioCompra + ", precioVenta=" + precioVenta + ", existencias=" + existencias + ", imagen=" + imagen + ", bajoStock=" + bajoStock + ", fechaAlta=" + fechaAlta + ", fechaModificacion=" + fechaModificacion + '}';
    }

}
