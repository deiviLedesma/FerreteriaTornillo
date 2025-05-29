/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Excepcion.PersistenciaException;
import POJOs.UnidadMedida;
import java.util.List;

/**
 * Interfaz DAO para la gestión de unidades de medida. Proporciona operaciones
 * CRUD y búsquedas para unidades de medida.
 *
 * @author SDavidLedesma
 */
public interface IUnidadMedidaDAO {

    /**
     * Inserta una nueva unidad de medida en la base de datos.
     *
     * @param unidad Objeto UnidadMedida a insertar.
     * @return La unidad de medida insertada con su ID generado.
     * @throws PersistenciaException Si ocurre un error durante la inserción.
     */
    UnidadMedida insertar(UnidadMedida unidad) throws PersistenciaException;

    /**
     * Actualiza una unidad de medida existente.
     *
     * @param unidad Objeto UnidadMedida con información actualizada.
     * @return La unidad de medida actualizada.
     * @throws PersistenciaException Si ocurre un error durante la
     * actualización.
     */
    UnidadMedida actualizar(UnidadMedida unidad) throws PersistenciaException;

    /**
     * Elimina una unidad de medida por su identificador único.
     *
     * @param idUnidadMedida ID de la unidad de medida a eliminar.
     * @throws PersistenciaException Si ocurre un error durante la eliminación.
     */
    void eliminar(Object idUnidadMedida) throws PersistenciaException;

    /**
     * Busca una unidad de medida por su identificador único.
     *
     * @param idUnidadMedida ID de la unidad de medida a buscar.
     * @return La unidad de medida encontrada, o null si no existe.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    UnidadMedida buscarPorId(Object idUnidadMedida) throws PersistenciaException;

    /**
     * Obtiene todas las unidades de medida registradas en la base de datos.
     *
     * @return Lista de unidades de medida.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    List<UnidadMedida> buscarTodos() throws PersistenciaException;

    /**
     * Busca unidades de medida por nombre.
     *
     * @param nombre Nombre o parte del nombre a buscar.
     * @return Lista de unidades de medida que cumplen el criterio.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    List<UnidadMedida> buscarPorNombre(String nombre) throws PersistenciaException;
}
