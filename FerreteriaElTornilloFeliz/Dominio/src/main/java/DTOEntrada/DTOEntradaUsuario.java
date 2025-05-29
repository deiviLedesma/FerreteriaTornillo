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
    private String contrasena;

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
     * @param contrasena
     */
    public DTOEntradaUsuario(String nombreUsuario, String nombreCompleto, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.nombreCompleto = nombreCompleto;
        this.contrasena = contrasena;
    }

    //getters y setters
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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
        return "DTOEntradaUsuario{" + "nombreUsuario=" + nombreUsuario + ", nombreCompleto=" + nombreCompleto + ", contrasena=" + contrasena + '}';
    }

}
