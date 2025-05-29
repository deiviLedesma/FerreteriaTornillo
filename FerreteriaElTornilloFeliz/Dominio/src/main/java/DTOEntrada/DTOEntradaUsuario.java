/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOEntrada;

/**
 * DTOEntradaUsuario: Crear/modificar usuario.
 *
 * @author SDavidLedesma
 */
public class DTOEntradaUsuario {

    private String nombreUsuario;
    private String nombreCompleto;

    /**
     * constructor por omision
     */
    public DTOEntradaUsuario() {
    }

    /**
     * constructor que inicializa los atributos
     *
     * @param nombreUsuario
     * @param nombreCompleto
     */
    public DTOEntradaUsuario(String nombreUsuario, String nombreCompleto) {
        this.nombreUsuario = nombreUsuario;
        this.nombreCompleto = nombreCompleto;
    }

    //getters y setters
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    @Override
    public String toString() {
        return "DTOEntradaUsuario{" + "nombreUsuario=" + nombreUsuario + ", nombreCompleto=" + nombreCompleto + '}';
    }

}
