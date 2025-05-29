/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOSalida;

/**
 * DTOSalidaCategoria Representa los datos de una categoría para mostrar.
 *
 * @author SDavidLedesma
 */
public class DTOSalidaCategoria {

    private String idCategoria;
    private String nombre;

    /**
     * constructor por omision
     */
    public DTOSalidaCategoria() {
    }

    /**
     * constructor que inicializa lso atributos
     *
     * @param idCategoria
     * @param nombre
     */
    public DTOSalidaCategoria(String idCategoria, String nombre) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
    }

    //getters y setters
    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "DTOSalidaCategoria{" + "idCategoria=" + idCategoria + ", nombre=" + nombre + '}';
    }

}
