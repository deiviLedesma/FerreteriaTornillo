/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Excepcion.PersistenciaException;
import POJOs.Proveedor;
import java.util.List;

/**
 * Interfaz DAO para la gestión de proveedores. Proporciona operaciones CRUD y
 * búsquedas para proveedores.
 *
 * @author SDavidLedesma
 */
public interface IProveedorDAO {

    /**
     * Inserta un nuevo proveedor en la base de datos.
     *
     * @param proveedor Objeto Proveedor a insertar.
     * @return El proveedor insertado con su ID generado.
     * @throws PersistenciaException Si ocurre un error durante la inserción.
     */
    Proveedor insertar(Proveedor proveedor) throws PersistenciaException;

    /**
     * Actualiza un proveedor existente.
     *
     * @param proveedor Objeto Proveedor con información actualizada.
     * @return El proveedor actualizado.
     * @throws PersistenciaException Si ocurre un error durante la
     * actualización.
     */
    Proveedor actualizar(Proveedor proveedor) throws PersistenciaException;

    /**
     * Elimina un proveedor por su identificador único.
     *
     * @param idProveedor ID del proveedor a eliminar.
     * @throws PersistenciaException Si ocurre un error durante la eliminación.
     */
    void eliminar(Object idProveedor) throws PersistenciaException;

    /**
     * Busca un proveedor por su identificador único.
     *
     * @param idProveedor ID del proveedor a buscar.
     * @return El proveedor encontrado, o null si no existe.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    Proveedor buscarPorId(Object idProveedor) throws PersistenciaException;

    /**
     * Obtiene todos los proveedores registrados en la base de datos.
     *
     * @return Lista de proveedores.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    List<Proveedor> buscarTodos() throws PersistenciaException;

    /**
     * Busca proveedores cuyo nombre coincida parcial o totalmente con el valor
     * especificado.
     *
     * @param nombre Nombre o parte del nombre a buscar.
     * @return Lista de proveedores que cumplen el criterio.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    List<Proveedor> buscarPorNombre(String nombre) throws PersistenciaException;
}
