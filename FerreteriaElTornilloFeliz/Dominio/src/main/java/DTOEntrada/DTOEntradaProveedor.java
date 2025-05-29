/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOEntrada;

/**
 * DTOEntradaProveedor: Crear/modificar proveedor.
 *
 * @author SDavidLedesma
 */
public class DTOEntradaProveedor {

    private String nombre;
    private String correo;
    private String telefono;
    private String direccion;

    /**
     * constructor por omision
     */
    public DTOEntradaProveedor() {
    }

    /**
     * constructor que inicializa los atributos
     *
     * @param nombre
     * @param correo
     * @param telefono
     * @param direccion
     */
    public DTOEntradaProveedor(String nombre, String correo, String telefono, String direccion) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    //getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "DTOEntradaProveedor{" + "nombre=" + nombre + ", correo=" + correo + ", telefono=" + telefono + ", direccion=" + direccion + '}';
    }

}
