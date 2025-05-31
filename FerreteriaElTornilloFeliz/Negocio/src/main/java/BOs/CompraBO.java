/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import DTOEntrada.DTOEntradaCompra;
import DTOSalida.DTOSalidaCompra;
import Excepcion.NegocioException;
import Mappers.CompraMapper;
import POJOs.Compra;
import POJOs.Producto;
import Excepcion.PersistenciaException;
import Interfaces.ICompraBO;
import Interfaces.ICompraDAO;
import Interfaces.IProductoDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Business Object para la gestión de compras. Valida existencia de productos y
 * suma existencias en inventario.
 *
 * @author SDavidLedesma
 */
public class CompraBO implements ICompraBO {

    private final ICompraDAO compraDAO;
    private final IProductoDAO productoDAO;

    public CompraBO(ICompraDAO compraDAO, IProductoDAO productoDAO ) {
        this.compraDAO = compraDAO;
        this.productoDAO = productoDAO;
    }

    /**
     * Registra una nueva compra. Valida existencia de productos y suma
     * existencias.
     */
    @Override
    public DTOSalidaCompra registrarCompra(DTOEntradaCompra dto) throws NegocioException {
        try {
            for (var detalle : dto.getDetalles()) {
                Producto producto = productoDAO.buscarPorId(detalle.getIdProducto());
                if (producto == null) {
                    throw new NegocioException("No existe el producto con id: " + detalle.getIdProducto());
                }
            }
            Compra compra = CompraMapper.toEntityFromEntrada(dto);
            compraDAO.insertar(compra);
            // Suma existencias de cada producto comprado
            for (var detalle : dto.getDetalles()) {
                productoDAO.aumentarStock(detalle.getIdProducto(), detalle.getCantidad());
            }
            return CompraMapper.toDTOSalida(compra);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al registrar compra: " + ex.getMessage(), ex);
        }
    }

    /**
     * Consulta todas las compras.
     */
    @Override
    public List<DTOSalidaCompra> buscarTodas() throws NegocioException {
        try {
            List<DTOSalidaCompra> lista = new ArrayList<>();
            for (Compra c : compraDAO.buscarTodos()) {
                lista.add(CompraMapper.toDTOSalida(c));
            }
            return lista;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al consultar compras: " + ex.getMessage(), ex);
        }
    }

    /**
     * Consulta una compra por id.
     */
    @Override
    public DTOSalidaCompra buscarPorId(String idCompra) throws NegocioException {
        try {
            Compra c = compraDAO.buscarPorId(idCompra);
            if (c == null) {
                return null;
            }
            return CompraMapper.toDTOSalida(c);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al buscar compra: " + ex.getMessage(), ex);
        }
    }

    /**
     * Devuelve una lista de compras realizadas a un proveedor entre dos fechas.
     */
    @Override
    public List<DTOSalidaCompra> reporteComprasPorRangoYProveedor(Date inicio, Date fin, String idProveedor) throws NegocioException {
        try {
            var compras = compraDAO.reporteComprasPorFechasYProveedor(inicio, fin, idProveedor);
            List<DTOSalidaCompra> reporte = new ArrayList<>();
            for (var compra : compras) {
                reporte.add(CompraMapper.toDTOSalida(compra));
            }
            return reporte;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al generar reporte de compras: " + ex.getMessage(), ex);
        }
    }

}
