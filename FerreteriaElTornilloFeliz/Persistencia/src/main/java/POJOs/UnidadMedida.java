/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJOs;

import java.io.Serializable;
import org.bson.types.ObjectId;

/**
 * Representa una unidad de medida.
 *
 * @author SDavidLedesma
 */
public class UnidadMedida implements Serializable {

    private ObjectId id;
    private String nombre;

    /**
     * constructor por omision
     */
    public UnidadMedida() {
    }

    /**
     * constructor que incializa los atributos
     *
     * @param id
     * @param nombre
     */
    public UnidadMedida(ObjectId id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    @Override
    public String toString() {
        return "UnidadMedida{" + "id=" + id + ", nombre=" + nombre + '}';
    }

}
