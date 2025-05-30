/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import DAO.UsuarioDAO;
import DTOEntrada.DTOEntradaUsuario;
import DTOSalida.DTOSalidaUsuario;
import Excepcion.NegocioException;
import Mappers.UsuarioMapper;
import POJOs.Usuario;
import Excepcion.PersistenciaException;
import java.util.ArrayList;
import java.util.List;

/**
 * Business Object para la gestión de usuarios. Propaga errores como
 * NegocioException.
 *
 * @author SDavidLedesma
 */
public class UsuarioBO {

    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    public void registrarUsuario(DTOEntradaUsuario dto) throws NegocioException {
        try {
            Usuario usuario = UsuarioMapper.toEntityFromEntrada(dto);
            usuarioDAO.insertar(usuario);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al registrar usuario: " + ex.getMessage(), ex);
        }
    }

    public List<DTOSalidaUsuario> consultarTodos() throws NegocioException {
        try {
            List<DTOSalidaUsuario> lista = new ArrayList<>();
            for (Usuario u : usuarioDAO.buscarTodos()) {
                lista.add(UsuarioMapper.toDTOSalida(u));
            }
            return lista;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al consultar usuarios: " + ex.getMessage(), ex);
        }
    }

    public DTOSalidaUsuario buscarPorId(String idUsuario) throws NegocioException {
        try {
            Usuario u = usuarioDAO.buscarPorId(idUsuario);
            if (u == null) {
                return null;
            }
            return UsuarioMapper.toDTOSalida(u);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al buscar usuario: " + ex.getMessage(), ex);
        }
    }

    public void actualizarUsuario(DTOSalidaUsuario dto) throws NegocioException {
        try {
            Usuario usuario = UsuarioMapper.toEntityFromSalida(dto);
            usuarioDAO.actualizar(usuario);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al actualizar usuario: " + ex.getMessage(), ex);
        }
    }

    public void eliminarUsuario(String idUsuario) throws NegocioException {
        try {
            usuarioDAO.eliminar(idUsuario);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al eliminar usuario: " + ex.getMessage(), ex);
        }
    }

    /**
     * Valida las credenciales de un usuario y retorna su DTO si son correctas.
     *
     * @param nombreUsuario Nombre de usuario
     * @param contrasena Contraseña en texto plano
     * @return DTOSalidaUsuario si las credenciales son válidas
     * @throws NegocioException Si las credenciales son incorrectas o hay error
     * de persistencia
     */
    public DTOSalidaUsuario validarCredenciales(String nombreUsuario, String contrasena) throws NegocioException {
        try {
            Usuario usuario = usuarioDAO.validarCredenciales(nombreUsuario, contrasena);
            if (usuario == null) {
                throw new NegocioException("Usuario o contraseña incorrectos.");
            }
            return UsuarioMapper.toDTOSalida(usuario);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al validar credenciales: " + ex.getMessage(), ex);
        }
    }

}
