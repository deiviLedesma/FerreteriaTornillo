/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOSalida;

/**
 *
 * DTOSalidaUnidadMedida Representa los datos de una unidad de medida para
 * mostrar.
 *
 * @author SDavidLedesma
 */
public class DTOSalidaUnidadMedida {

    private String idUnidadMedida;
    private String nombre;

    /**
     * constructor por omision
     */
    public DTOSalidaUnidadMedida() {
    }

    /**
     * csontructor que inicializa lso atributos
     *
     * @param idUnidadMedida
     * @param nombre
     */
    public DTOSalidaUnidadMedida(String idUnidadMedida, String nombre) {
        this.idUnidadMedida = idUnidadMedida;
        this.nombre = nombre;
    }

    //getters y setters
    public String getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(String idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "DTOSalidaUnidadMedida{" + "idUnidadMedida=" + idUnidadMedida + ", nombre=" + nombre + '}';
    }

}
