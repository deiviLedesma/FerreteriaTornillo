/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

/**
 * Interfaz DAO para la gestión de usuarios. Proporciona operaciones CRUD y
 * búsquedas especializadas para usuarios del sistema.
 *
 * @author SDavidLedesma
 *
 */
import Excepcion.PersistenciaException;
import POJOs.Usuario;
import java.util.List;

public interface IUsuarioDAO {

    /**
     * Inserta un nuevo usuario en la base de datos.
     *
     * @param usuario Objeto Usuario a insertar.
     * @return El usuario insertado con su ID generado.
     * @throws PersistenciaException Si ocurre un error durante la inserción.
     */
    Usuario insertar(Usuario usuario) throws PersistenciaException;

    /**
     * Actualiza un usuario existente.
     *
     * @param usuario Objeto Usuario con información actualizada.
     * @return El usuario actualizado.
     * @throws PersistenciaException Si ocurre un error durante la
     * actualización.
     */
    Usuario actualizar(Usuario usuario) throws PersistenciaException;

    /**
     * Elimina un usuario por su identificador único.
     *
     * @param idUsuario ID del usuario a eliminar.
     * @throws PersistenciaException Si ocurre un error durante la eliminación.
     */
    void eliminar(Object idUsuario) throws PersistenciaException;

    /**
     * Busca un usuario por su identificador único.
     *
     * @param idUsuario ID del usuario a buscar.
     * @return El usuario encontrado, o null si no existe.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    Usuario buscarPorId(Object idUsuario) throws PersistenciaException;

    /**
     * Busca un usuario por su nombre de usuario exacto.
     *
     * @param nombreUsuario Nombre de usuario (username) a buscar.
     * @return El usuario encontrado, o null si no existe.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    Usuario buscarPorNombreUsuario(String nombreUsuario) throws PersistenciaException;

    /**
     * Obtiene todos los usuarios registrados en la base de datos.
     *
     * @return Lista de usuarios.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    List<Usuario> buscarTodos() throws PersistenciaException;
}
