/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOEntrada;

/**
 * DTOEntradaCategoria Representa los datos para crear o modificar una
 * categoría.
 *
 * @author SDavidLedesma
 */
public class DTOEntradaCategoria {

    private String nombre;

    /**
     * constructor por omision
     */
    public DTOEntradaCategoria() {
    }

    /**
     * constructor que inicializa los atributos
     * @param nombre 
     */
    public DTOEntradaCategoria(String nombre) {
        this.nombre = nombre;
    }

    //getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "DTOEntradaCategoria{" + "nombre=" + nombre + '}';
    }

}
