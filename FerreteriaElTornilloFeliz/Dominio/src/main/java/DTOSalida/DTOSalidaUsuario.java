/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOSalida;

/**
 * DTOSalidaUsuario: Muestra de usuario.
 *
 * @author SDavidLedesma
 */
public class DTOSalidaUsuario {

    private String idUsaurio;
    private String nombreUsuario;
    private String nombreCompleto;

    /**
     * constructor por omision
     */
    public DTOSalidaUsuario() {
    }

    /**
     * constructor que inicializa los atributos
     *
     * @param idUsaurio
     * @param nombreUsuario
     * @param nombreCompleto
     */
    public DTOSalidaUsuario(String idUsaurio, String nombreUsuario, String nombreCompleto) {
        this.idUsaurio = idUsaurio;
        this.nombreUsuario = nombreUsuario;
        this.nombreCompleto = nombreCompleto;
    }

    //getters y setters
    public String getIdUsaurio() {
        return idUsaurio;
    }

    public void setIdUsaurio(String idUsaurio) {
        this.idUsaurio = idUsaurio;
    }

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
        return "DTOSalidaUsuario{" + "idUsaurio=" + idUsaurio + ", nombreUsuario=" + nombreUsuario + ", nombreCompleto=" + nombreCompleto + '}';
    }

}
