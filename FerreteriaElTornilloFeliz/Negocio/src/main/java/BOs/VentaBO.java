/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import DTOEntrada.DTOEntradaVenta;
import DTOSalida.DTOSalidaVenta;
import Excepcion.NegocioException;
import Mappers.VentaMapper;
import POJOs.Venta;
import POJOs.Producto;
import Excepcion.PersistenciaException;
import Interfaces.ICajaDAO;
import Interfaces.IProductoDAO;
import Interfaces.IVentaBO;
import Interfaces.IVentaDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Business Object para la gestión de ventas. Valida caja activa y stock
 * suficiente antes de registrar una venta. Descuenta stock de productos al
 * registrar la venta.
 *
 * @author SDavidLedesma
 */
public class VentaBO implements IVentaBO {

    private final IVentaDAO ventaDAO;
    private final ICajaDAO cajaDAO;
    private final IProductoDAO productoDAO;

    public VentaBO(IVentaDAO ventaDAO, ICajaDAO cajaDAO, IProductoDAO productoDAO) {
        this.ventaDAO = ventaDAO;
        this.cajaDAO = cajaDAO;
        this.productoDAO = productoDAO;
    }

    /**
     * Registra una nueva venta. Valida caja activa y stock suficiente para cada
     * producto. Descuenta el stock al final.
     */
    @Override
    public DTOSalidaVenta registrarVenta(DTOEntradaVenta dto) throws NegocioException {
        try {
            // Validar caja activa (por usuario)
            if (dto.getIdCaja() == null || dto.getIdCaja().isEmpty()) {
                throw new NegocioException("Debe especificar la caja activa para registrar la venta.");
            }
            if (cajaDAO.buscarPorId(dto.getIdCaja()) == null) {
                throw new NegocioException("No se encontró la caja activa especificada.");
            }
            // Validar stock suficiente por producto
            for (var detalle : dto.getDetalles()) {
                Producto producto = productoDAO.buscarPorId(detalle.getIdProducto());
                if (producto == null) {
                    throw new NegocioException("No existe el producto con id: " + detalle.getIdProducto());
                }
                if (producto.getExistencias() < detalle.getCantidad()) {
                    throw new NegocioException("Stock insuficiente para el producto: " + producto.getNombre());
                }
            }
            // Registrar venta
            Venta venta = VentaMapper.toEntityFromEntrada(dto);
            ventaDAO.insertar(venta);

            // Descontar stock por cada producto
            for (var detalle : dto.getDetalles()) {
                productoDAO.descontarStock(detalle.getIdProducto(), detalle.getCantidad());
            }
            return VentaMapper.toDTOSalida(venta);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al registrar venta: " + ex.getMessage(), ex);
        }
    }

    /**
     * Consulta todas las ventas.
     */
    @Override
    public List<DTOSalidaVenta> buscarTodas() throws NegocioException {
        try {
            List<DTOSalidaVenta> lista = new ArrayList<>();
            for (Venta v : ventaDAO.buscarTodos()) {
                lista.add(VentaMapper.toDTOSalida(v));
            }
            return lista;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al consultar ventas: " + ex.getMessage(), ex);
        }
    }

    /**
     * Consulta una venta por id.
     */
    @Override
    public DTOSalidaVenta buscarPorId(String idVenta) throws NegocioException {
        try {
            Venta v = ventaDAO.buscarPorId(idVenta);
            if (v == null) {
                return null;
            }
            return VentaMapper.toDTOSalida(v);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al buscar venta: " + ex.getMessage(), ex);
        }
    }

    /**
     * Consulta ventas por rango de fechas y usuario (para reportes).
     */
    @Override
    public List<DTOSalidaVenta> buscarPorRangoFechasYUsuario(Date inicio, Date fin, String idUsuario) throws NegocioException {
        try {
            List<DTOSalidaVenta> lista = new ArrayList<>();
            for (Venta v : ventaDAO.reporteVentasPorFechasYUsuario(inicio, fin, idUsuario)) {
                lista.add(VentaMapper.toDTOSalida(v));
            }
            return lista;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al consultar ventas por rango y usuario: " + ex.getMessage(), ex);
        }
    }
}
