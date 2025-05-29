/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Excepcion.PersistenciaException;
import POJOs.Compra;
import java.util.Date;
import java.util.List;

/**
 * Interfaz DAO para la gestión de compras. Proporciona operaciones CRUD y
 * consultas de reporte para compras de productos.
 *
 * @author SDavidLedesma
 */
public interface ICompraDAO {

    /**
     * Inserta una nueva compra en la base de datos.
     *
     * @param compra Objeto Compra a insertar.
     * @return La compra insertada con su ID generado.
     * @throws PersistenciaException Si ocurre un error durante la inserción.
     */
    Compra insertar(Compra compra) throws PersistenciaException;

    /**
     * Actualiza una compra existente.
     *
     * @param compra Objeto Compra con información actualizada.
     * @return La compra actualizada.
     * @throws PersistenciaException Si ocurre un error durante la
     * actualización.
     */
    Compra actualizar(Compra compra) throws PersistenciaException;

    /**
     * Elimina una compra por su identificador único.
     *
     * @param idCompra ID de la compra a eliminar.
     * @throws PersistenciaException Si ocurre un error durante la eliminación.
     */
    void eliminar(Object idCompra) throws PersistenciaException;

    /**
     * Busca una compra por su identificador único.
     *
     * @param idCompra ID de la compra a buscar.
     * @return La compra encontrada, o null si no existe.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    Compra buscarPorId(Object idCompra) throws PersistenciaException;

    /**
     * Obtiene todas las compras registradas en la base de datos.
     *
     * @return Lista de compras.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    List<Compra> buscarTodos() throws PersistenciaException;

    /**
     * Busca compras realizadas en un rango de fechas.
     *
     * @param inicio Fecha de inicio (inclusive).
     * @param fin Fecha de fin (inclusive).
     * @return Lista de compras realizadas en el rango.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    List<Compra> buscarPorRangoFechas(Date inicio, Date fin) throws PersistenciaException;

    /**
     * Busca compras realizadas a un proveedor específico.
     *
     * @param idProveedor ID del proveedor.
     * @return Lista de compras realizadas a dicho proveedor.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    List<Compra> buscarPorProveedor(Object idProveedor) throws PersistenciaException;

    /**
     * Obtiene compras para reporte, filtrando por fechas y proveedor
     * (opcional). Si idProveedor es null, trae todas.
     *
     * @param inicio Fecha de inicio.
     * @param fin Fecha de fin.
     * @param idProveedor ID del proveedor (opcional).
     * @return Lista de compras del reporte.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    List<Compra> reporteComprasPorFechasYProveedor(Date inicio, Date fin, Object idProveedor) throws PersistenciaException;
}
