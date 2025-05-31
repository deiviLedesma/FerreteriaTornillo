/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOEntrada.DTOEntradaUsuario;
import DTOSalida.DTOSalidaUsuario;
import Excepcion.NegocioException;
import java.util.List;

/**
 *
 * @author SDavidLedesma
 */
public interface IUsuarioBO {

    DTOSalidaUsuario registrarUsuario(DTOEntradaUsuario dto) throws NegocioException;

    List<DTOSalidaUsuario> consultarTodos() throws NegocioException;

    DTOSalidaUsuario buscarPorId(String idUsuario) throws NegocioException;

    DTOSalidaUsuario actualizarUsuario(DTOSalidaUsuario dto) throws NegocioException;

    void eliminarUsuario(String idUsuario) throws NegocioException;

    DTOSalidaUsuario validarCredenciales(String nombreUsuario, String contrasena) throws NegocioException;

}
