/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOEntrada;

/**
 * DTOEntradaUnidadMedida Representa los datos para crear o modificar una unidad
 * de medida.
 *
 * @author SDavidLedesma
 */
public class DTOEntradaUnidadMedida {

    private String nombre;

    /**
     * constructor por omision
     */
    public DTOEntradaUnidadMedida() {
    }

    /**
     * constructor que inicializa los atributos
     *
     * @param nombre
     */
    public DTOEntradaUnidadMedida(String nombre) {
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
        return "DTOEntradaUnidadMedida{" + "nombre=" + nombre + '}';
    }

}
