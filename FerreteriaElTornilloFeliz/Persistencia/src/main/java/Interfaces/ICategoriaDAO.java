/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Excepcion.PersistenciaException;
import POJOs.Categoria;
import java.util.List;

/**
 * Interfaz para las operaciones de acceso a datos (DAO) relacionadas con la
 * entidad Proporciona métodos CRUD y búsquedas especializadas para la gestión
 * de categorías de productos en la base de datos.
 *
 * @author SDavidLedesma
 */
public interface ICategoriaDAO {

    /**
     * Inserta una nueva categoría en la base de datos.
     *
     * @param categoria Objeto Categoria a insertar.
     * @return La categoría insertada con su ID generado.
     * @throws PersistenciaException Si ocurre un error durante la inserción.
     */
    Categoria insertar(Categoria categoria) throws PersistenciaException;

    /**
     * Actualiza los datos de una categoría existente.
     *
     * @param categoria Objeto Categoria con la información actualizada (debe
     * contener un ID válido).
     * @return La categoría actualizada.
     * @throws PersistenciaException Si ocurre un error durante la
     * actualización.
     */
    Categoria actualizar(Categoria categoria) throws PersistenciaException;

    /**
     * Elimina una categoría por su identificador único.
     *
     * @param idCategoria ID de la categoría a eliminar.
     * @throws PersistenciaException Si ocurre un error durante la eliminación.
     */
    void eliminar(Object idCategoria) throws PersistenciaException;

    /**
     * Busca una categoría por su identificador único.
     *
     * @param idCategoria ID de la categoría a buscar.
     * @return La categoría encontrada, o null si no existe.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    Categoria buscarPorId(Object idCategoria) throws PersistenciaException;

    /**
     * Obtiene todas las categorías registradas en la base de datos.
     *
     * @return Lista de categorías.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    List<Categoria> buscarTodos() throws PersistenciaException;

    /**
     * Busca categorías cuyo nombre coincida parcial o totalmente con el valor
     * especificado. La búsqueda es insensible a mayúsculas/minúsculas.
     *
     * @param nombre Nombre o parte del nombre a buscar.
     * @return Lista de categorías que cumplen el criterio de búsqueda.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    List<Categoria> buscarPorNombre(String nombre) throws PersistenciaException;
}
