/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Excepcion.PersistenciaException;
import POJOs.Venta;
import java.util.Date;
import java.util.List;

/**
 * Interfaz DAO para la gestión de ventas. Proporciona operaciones CRUD y
 * consultas de reporte para ventas de productos.
 *
 * @author SDavidLedesma
 */
public interface IVentaDAO {

    /**
     * Inserta una nueva venta en la base de datos.
     *
     * @param venta Objeto Venta a insertar.
     * @return La venta insertada con su ID generado.
     * @throws PersistenciaException Si ocurre un error durante la inserción.
     */
    Venta insertar(Venta venta) throws PersistenciaException;

    /**
     * Actualiza una venta existente.
     *
     * @param venta Objeto Venta con información actualizada.
     * @return La venta actualizada.
     * @throws PersistenciaException Si ocurre un error durante la
     * actualización.
     */
    Venta actualizar(Venta venta) throws PersistenciaException;

    /**
     * Elimina una venta por su identificador único.
     *
     * @param idVenta ID de la venta a eliminar.
     * @throws PersistenciaException Si ocurre un error durante la eliminación.
     */
    void eliminar(Object idVenta) throws PersistenciaException;

    /**
     * Busca una venta por su identificador único.
     *
     * @param idVenta ID de la venta a buscar.
     * @return La venta encontrada, o null si no existe.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    Venta buscarPorId(Object idVenta) throws PersistenciaException;

    /**
     * Obtiene todas las ventas registradas en la base de datos.
     *
     * @return Lista de ventas.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    List<Venta> buscarTodos() throws PersistenciaException;

    /**
     * Busca ventas realizadas en un rango de fechas.
     *
     * @param inicio Fecha de inicio (inclusive).
     * @param fin Fecha de fin (inclusive).
     * @return Lista de ventas en el rango.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    List<Venta> buscarPorRangoFechas(Date inicio, Date fin) throws PersistenciaException;

    /**
     * Busca ventas realizadas por un usuario específico.
     *
     * @param idUsuario ID del usuario.
     * @return Lista de ventas realizadas por el usuario.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    List<Venta> buscarPorUsuario(Object idUsuario) throws PersistenciaException;

    /**
     * Obtiene ventas para reporte, filtrando por fechas y usuario (opcional).
     * Si idUsuario es null, trae todas.
     *
     * @param inicio Fecha de inicio.
     * @param fin Fecha de fin.
     * @param idUsuario ID del usuario (opcional).
     * @return Lista de ventas del reporte.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    List<Venta> reporteVentasPorFechasYUsuario(Date inicio, Date fin, Object idUsuario) throws PersistenciaException;
}
