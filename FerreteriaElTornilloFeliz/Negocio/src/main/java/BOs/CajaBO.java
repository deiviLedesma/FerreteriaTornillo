/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import DAO.CajaDAO;
import DAO.VentaDAO;
import DTOEntrada.DTOEntradaCaja;
import DTOSalida.DTOSalidaCaja;
import Excepcion.NegocioException;
import Mappers.CajaMapper;
import POJOs.Caja;
import Excepcion.PersistenciaException;
import Interfaces.ICajaBO;
import Interfaces.ICajaDAO;
import Interfaces.IVentaDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Business Object para la gestión de cajas. Valida que no haya doble
 * apertura/cierre y calcula el total de ventas al cerrar.
 *
 * @author SDavidLedesma
 */
public class CajaBO implements ICajaBO {

    private final ICajaDAO cajaDAO;
    private final IVentaDAO ventaDAO = new VentaDAO();

    public CajaBO(ICajaDAO cajaDAO) {
        this.cajaDAO = cajaDAO;
    }

    /**
     * Abre una nueva caja. Lanza NegocioException si ya hay una activa.
     */
    @Override
    public DTOSalidaCaja abrirCaja(DTOEntradaCaja dto) throws NegocioException {
        try {
            Caja cajaActiva = cajaDAO.buscarCajaActiva();
            if (cajaActiva != null) {
                throw new NegocioException("Ya existe una caja activa. Debe cerrarla antes de abrir una nueva.");
            }
            Caja caja = CajaMapper.toEntityFromEntrada(dto);
            Caja cajaGuardada = cajaDAO.abrirCaja(caja);
            return CajaMapper.toDTOSalida(cajaGuardada);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al abrir caja: " + ex.getMessage(), ex);
        }
    }

    /**
     * Cierra la caja y devuelve su DTO de salida actualizado.
     */
    @Override
    public DTOSalidaCaja cerrarCaja(String idCaja, double montoFinal) throws NegocioException {
        try {
            // Busca la caja
            DTOSalidaCaja dtoCaja = buscarPorId(idCaja);
            if (dtoCaja == null) {
                throw new NegocioException("No se encontró la caja a cerrar.");
            }
            // Valida que no esté cerrada
            if (dtoCaja.getFechaHoraCierre() != null) {
                throw new NegocioException("La caja ya está cerrada.");
            }
            // Actualiza campos
            dtoCaja.setFechaHoraCierre(new Date());
            dtoCaja.setMontoFinal(montoFinal);
            // Realiza el cierre en la base de datos
            cajaDAO.cerrarCaja(CajaMapper.toEntityFromSalida(dtoCaja));
            return buscarPorId(idCaja); // Regresa la caja cerrada y actualizada
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al cerrar caja: " + ex.getMessage(), ex);
        }
    }

    /**
     * Busca una caja por su id.
     */
    @Override
    public DTOSalidaCaja buscarPorId(String idCaja) throws NegocioException {
        try {
            Caja caja = cajaDAO.buscarPorId(idCaja);
            if (caja == null) {
                return null;
            }
            return CajaMapper.toDTOSalida(caja);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al buscar caja por id: " + ex.getMessage(), ex);
        }
    }

    /**
     * Consulta todas las cajas registradas.
     */
    @Override
    public List<DTOSalidaCaja> buscarTodos() throws NegocioException {
        try {
            List<DTOSalidaCaja> lista = new ArrayList<>();
            for (Caja c : cajaDAO.buscarTodos()) {
                lista.add(CajaMapper.toDTOSalida(c));
            }
            return lista;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al consultar todas las cajas: " + ex.getMessage(), ex);
        }
    }

    /**
     * Consulta cajas por rango de fechas de apertura.
     */
    @Override
    public List<DTOSalidaCaja> buscarPorRangoFechas(Date inicio, Date fin) throws NegocioException {
        try {
            List<DTOSalidaCaja> lista = new ArrayList<>();
            for (Caja c : cajaDAO.buscarPorRangoFechas(inicio, fin)) {
                lista.add(CajaMapper.toDTOSalida(c));
            }
            return lista;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al consultar cajas por rango de fechas: " + ex.getMessage(), ex);
        }
    }

    /**
     * Busca la caja activa (no cerrada).
     */
    @Override
    public DTOSalidaCaja buscarCajaActiva() throws NegocioException {
        try {
            Caja caja = cajaDAO.buscarCajaActiva();
            if (caja == null) {
                return null;
            }
            return CajaMapper.toDTOSalida(caja);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al buscar caja activa: " + ex.getMessage(), ex);
        }
    }

    /**
     * Devuelve una lista de cajas abiertas entre dos fechas.
     */
    @Override
    public List<DTOSalidaCaja> reporteCajasPorRangoFechas(Date inicio, Date fin) throws NegocioException {
        try {
            var cajas = cajaDAO.buscarPorRangoFechas(inicio, fin);
            List<DTOSalidaCaja> reporte = new ArrayList<>();
            for (var c : cajas) {
                reporte.add(CajaMapper.toDTOSalida(c));
            }
            return reporte;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al generar reporte de cajas: " + ex.getMessage(), ex);
        }
    }

}
