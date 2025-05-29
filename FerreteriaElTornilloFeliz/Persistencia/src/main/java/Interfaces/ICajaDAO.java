/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Excepcion.PersistenciaException;
import POJOs.Caja;
import java.util.Date;
import java.util.List;

/**
 * Interfaz DAO para la gestión de cajas. Proporciona operaciones CRUD y
 * búsquedas especializadas para cajas diarias.
 *
 * @author SDavidLedesma
 */
public interface ICajaDAO {

    /**
     * Inserta (apertura) una nueva caja.
     *
     * @param caja Objeto Caja con los datos de apertura.
     * @return La caja insertada con su ID generado.
     * @throws PersistenciaException Si ocurre un error durante la apertura.
     */
    Caja abrirCaja(Caja caja) throws PersistenciaException;

    /**
     * Cierra una caja existente.
     *
     * @param caja Objeto Caja con datos de cierre (debe tener el ID).
     * @return La caja cerrada.
     * @throws PersistenciaException Si ocurre un error durante el cierre.
     */
    Caja cerrarCaja(Caja caja) throws PersistenciaException;

    /**
     * Busca una caja por su identificador único.
     *
     * @param idCaja ID de la caja a buscar.
     * @return La caja encontrada, o null si no existe.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    Caja buscarPorId(Object idCaja) throws PersistenciaException;

    /**
     * Obtiene todas las cajas registradas en la base de datos.
     *
     * @return Lista de cajas.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    List<Caja> buscarTodos() throws PersistenciaException;

    /**
     * Busca cajas abiertas o cerradas en un rango de fechas.
     *
     * @param inicio Fecha de inicio (inclusive).
     * @param fin Fecha de fin (inclusive).
     * @return Lista de cajas en el rango.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    List<Caja> buscarPorRangoFechas(Date inicio, Date fin) throws PersistenciaException;

    /**
     * Busca la caja activa (abierta) actualmente.
     *
     * @return La caja activa, o null si no hay ninguna abierta.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    Caja buscarCajaActiva() throws PersistenciaException;
}
