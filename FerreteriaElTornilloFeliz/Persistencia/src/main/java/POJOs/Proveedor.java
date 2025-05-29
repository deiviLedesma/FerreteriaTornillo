/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJOs;

import java.io.Serializable;
import org.bson.types.ObjectId;

/**
 * Representa un proveedor.
 *
 * @author SDavidLedesma
 */
public class Proveedor implements Serializable {

    private ObjectId id;
    private String nombre;
    private String correo;
    private String telefono;
    private String direccion;

    /**
     * constructor por omision
     */
    public Proveedor() {
    }

    /**
     * constructor que incializa los atributos
     *
     * @param id
     * @param nombre
     * @param correo
     * @param telefono
     * @param direccion
     */
    public Proveedor(ObjectId id, String nombre, String correo, String telefono, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    //getetrs y setters
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
        return "Proveedor{" + "id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", telefono=" + telefono + ", direccion=" + direccion + '}';
    }

}
