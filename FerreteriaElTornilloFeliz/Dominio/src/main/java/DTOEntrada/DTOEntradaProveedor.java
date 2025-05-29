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

    /**
     * constructor por omision
     */
    public DTOEntradaProveedor() {
    }

    /**
     * constructor que inicializa los atributos
     *
     * @param nombre
     */
    public DTOEntradaProveedor(String nombre) {
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
        return "DTOEntradaProveedor{" + "nombre=" + nombre + '}';
    }

}
