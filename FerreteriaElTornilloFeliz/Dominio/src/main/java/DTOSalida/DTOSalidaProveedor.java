/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOSalida;

/**
 * DTOSalidaProveedor: Muestra de proveedor.
 *
 * @author SDavidLedesma
 */
public class DTOSalidaProveedor {

    private String idProveedor;
    private String nombre;

    /**
     * csontructor por omision
     */
    public DTOSalidaProveedor() {
    }

    /**
     * constructor que inicializa los atributos
     *
     * @param idProveedor
     * @param nombre
     */
    public DTOSalidaProveedor(String idProveedor, String nombre) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
    }

    //getters y setters
    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "DTOSalidaProveedor{" + "idProveedor=" + idProveedor + ", nombre=" + nombre + '}';
    }

}
