/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Excepcion.PersistenciaException;
import POJOs.Devolucion;
import java.util.Date;
import java.util.List;

/**
 * Interfaz DAO para la gestión de devoluciones. Proporciona operaciones CRUD y
 * búsquedas especializadas para devoluciones de productos o ventas.
 *
 * @author SDavidLedesma
 */
public interface IDevolucionDAO {

    /**
     * Inserta una nueva devolución en la base de datos.
     *
     * @param devolucion Objeto Devolucion a insertar.
     * @return La devolución insertada con su ID generado.
     * @throws PersistenciaException Si ocurre un error durante la inserción.
     */
    Devolucion insertar(Devolucion devolucion) throws PersistenciaException;

    /**
     * Actualiza una devolución existente.
     *
     * @param devolucion Objeto Devolucion con información actualizada.
     * @return La devolución actualizada.
     * @throws PersistenciaException Si ocurre un error durante la
     * actualización.
     */
    Devolucion actualizar(Devolucion devolucion) throws PersistenciaException;

    /**
     * Elimina una devolución por su identificador único.
     *
     * @param idDevolucion ID de la devolución a eliminar.
     * @throws PersistenciaException Si ocurre un error durante la eliminación.
     */
    void eliminar(Object idDevolucion) throws PersistenciaException;

    /**
     * Busca una devolución por su identificador único.
     *
     * @param idDevolucion ID de la devolución a buscar.
     * @return La devolución encontrada, o null si no existe.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    Devolucion buscarPorId(Object idDevolucion) throws PersistenciaException;

    /**
     * Obtiene todas las devoluciones registradas en la base de datos.
     *
     * @return Lista de devoluciones.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    List<Devolucion> buscarTodos() throws PersistenciaException;

    /**
     * Busca devoluciones realizadas en un rango de fechas.
     *
     * @param inicio Fecha de inicio (inclusive).
     * @param fin Fecha de fin (inclusive).
     * @return Lista de devoluciones en el rango.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    List<Devolucion> buscarPorRangoFechas(Date inicio, Date fin) throws PersistenciaException;

    /**
     * Busca devoluciones realizadas por un usuario específico.
     *
     * @param idUsuario ID del usuario.
     * @return Lista de devoluciones realizadas por el usuario.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    List<Devolucion> buscarPorUsuario(Object idUsuario) throws PersistenciaException;
}
