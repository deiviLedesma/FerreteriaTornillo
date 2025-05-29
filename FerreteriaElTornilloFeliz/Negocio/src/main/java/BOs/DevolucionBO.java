/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import DAO.DevolucionDAO;
import DAO.ProductoDAO;
import DTOEntrada.DTOEntradaDevolucion;
import DTOSalida.DTOSalidaDevolucion;
import Excepcion.NegocioException;
import Mappers.DevolucionMapper;
import POJOs.Devolucion;
import POJOs.Producto;
import Excepcion.PersistenciaException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Business Object para la gestión de devoluciones. Si el tipo es PRODUCTO y la
 * decisión es REINTEGRAR, suma existencias al producto.
 *
 * @author SDavidLedesma
 */
public class DevolucionBO {

    private final DevolucionDAO devolucionDAO = new DevolucionDAO();
    private final ProductoDAO productoDAO = new ProductoDAO();

    /**
     * Registra una devolución. Si la devolución es de producto y la decisión es
     * reintegrar, suma existencias.
     */
    public void registrarDevolucion(DTOEntradaDevolucion dto) throws NegocioException {
        try {
            // Solo reintegra stock si aplica
            if ("PRODUCTO".equalsIgnoreCase(dto.getTipo()) && "REINTEGRAR".equalsIgnoreCase(dto.getDecision())) {
                Producto producto = productoDAO.buscarPorId(dto.getIdProducto());
                if (producto == null) {
                    throw new NegocioException("No existe el producto a reintegrar.");
                }
                productoDAO.aumentarStock(dto.getIdProducto(), dto.getCantidad());
            }
            // Aquí puedes agregar lógica para devoluciones de venta completa si requieres
            Devolucion devolucion = DevolucionMapper.toEntityFromEntrada(dto);
            devolucionDAO.insertar(devolucion);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al registrar devolución: " + ex.getMessage(), ex);
        }
    }

    /**
     * Consulta todas las devoluciones.
     */
    public List<DTOSalidaDevolucion> buscarTodas() throws NegocioException {
        try {
            List<DTOSalidaDevolucion> lista = new ArrayList<>();
            for (Devolucion d : devolucionDAO.buscarTodos()) {
                lista.add(DevolucionMapper.toDTOSalida(d));
            }
            return lista;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al consultar devoluciones: " + ex.getMessage(), ex);
        }
    }

    /**
     * Consulta una devolución por id.
     */
    public DTOSalidaDevolucion buscarPorId(String idDevolucion) throws NegocioException {
        try {
            Devolucion d = devolucionDAO.buscarPorId(idDevolucion);
            if (d == null) {
                return null;
            }
            return DevolucionMapper.toDTOSalida(d);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al buscar devolución: " + ex.getMessage(), ex);
        }
    }

    /**
     * Reporte de devoluciones por rango de fechas.
     */
    public List<DTOSalidaDevolucion> reporteDevolucionesPorRangoFechas(Date inicio, Date fin) throws NegocioException {
        try {
            List<Devolucion> lista = devolucionDAO.buscarPorRangoFechas(inicio, fin);
            List<DTOSalidaDevolucion> reporte = new ArrayList<>();
            for (Devolucion d : lista) {
                reporte.add(DevolucionMapper.toDTOSalida(d));
            }
            return reporte;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al generar reporte de devoluciones por fechas: " + ex.getMessage(), ex);
        }
    }

    /**
     * Reporte de devoluciones por usuario.
     */
    public List<DTOSalidaDevolucion> reporteDevolucionesPorUsuario(String usuario) throws NegocioException {
        try {
            List<Devolucion> lista = devolucionDAO.buscarPorUsuario(usuario);
            List<DTOSalidaDevolucion> reporte = new ArrayList<>();
            for (Devolucion d : lista) {
                reporte.add(DevolucionMapper.toDTOSalida(d));
            }
            return reporte;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al generar reporte de devoluciones por usuario: " + ex.getMessage(), ex);
        }
    }

}
