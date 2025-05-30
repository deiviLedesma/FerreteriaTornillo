/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import DAO.ProductoDAO;
import DTOEntrada.DTOEntradaProducto;
import DTOSalida.DTOSalidaProducto;
import Excepcion.NegocioException;
import Mappers.ProductoMapper;
import POJOs.Producto;
import Excepcion.PersistenciaException;
import java.util.ArrayList;
import java.util.List;

/**
 * Business Object para la gestión de productos. Realiza validaciones básicas y
 * opera solo con DTOs. Propaga errores como NegocioException.
 *
 * @author SDavidLedesma
 */
public class ProductoBO {

    private final ProductoDAO productoDAO = new ProductoDAO();

    /**
     * Registra un nuevo producto.
     *
     * @param dto DTOEntradaProducto con datos a registrar
     * @throws NegocioException Si ocurre un error de negocio/persistencia
     */
    public void registrarProducto(DTOEntradaProducto dto) throws NegocioException {
        try {
            Producto producto = ProductoMapper.toEntityFromEntrada(dto);
            productoDAO.insertar(producto);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al registrar producto: " + ex.getMessage(), ex);
        }
    }

    /**
     * Consulta todos los productos existentes.
     *
     * @return Lista de DTOSalidaProducto
     * @throws NegocioException Si ocurre un error en la consulta
     */
    public List<DTOSalidaProducto> consultarTodos() throws NegocioException {
        try {
            List<DTOSalidaProducto> lista = new ArrayList<>();
            for (Producto p : productoDAO.buscarTodos()) {
                lista.add(ProductoMapper.toDTOSalida(p));
            }
            return lista;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al consultar productos: " + ex.getMessage(), ex);
        }
    }

    /**
     * Busca un producto por su ID.
     *
     * @param idProducto ID a buscar
     * @return DTOSalidaProducto si lo encuentra, null si no existe
     * @throws NegocioException Si ocurre un error en la búsqueda
     */
    public DTOSalidaProducto buscarPorId(String idProducto) throws NegocioException {
        try {
            Producto p = productoDAO.buscarPorId(idProducto);
            if (p == null) {
                return null;
            }
            return ProductoMapper.toDTOSalida(p);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al buscar producto: " + ex.getMessage(), ex);
        }
    }

    /**
     * Actualiza un producto existente.
     *
     * @param idProducto El id del producto a actualizar (String, en formato
     * hexadecimal de ObjectId)
     * @param dto Datos de entrada del producto a actualizar
     * (DTOEntradaProducto)
     * @throws NegocioException Si ocurre un error al actualizar
     */
    public void actualizarProducto(String idProducto, DTOEntradaProducto dto) throws NegocioException {
        try {
            Producto producto = productoDAO.buscarPorId(idProducto);
            if (producto == null) {
                throw new NegocioException("No se encontró el producto a actualizar.");
            }
            // Solo se actualizan los campos editables
            producto.setNombre(dto.getNombre());
            producto.setDescripcion(dto.getDescripcion());
            producto.setPrecioCompra(dto.getPrecioCompra());
            producto.setPrecioVenta(dto.getPrecioVenta());
            producto.setExistencias(dto.getExistencias());
            producto.setIdCategoria(new org.bson.types.ObjectId(dto.getIdCategoria()));
            producto.setIdUnidadMedida(new org.bson.types.ObjectId(dto.getIdUnidadMedida()));
            producto.setImagen(dto.getImagen());
            productoDAO.actualizar(producto);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al actualizar producto: " + ex.getMessage(), ex);
        }
    }

    /**
     * Elimina un producto por ID.
     *
     * @param idProducto ID a eliminar
     * @throws NegocioException Si ocurre un error al eliminar
     */
    public void eliminarProducto(String idProducto) throws NegocioException {
        try {
            productoDAO.eliminar(idProducto);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al eliminar producto: " + ex.getMessage(), ex);
        }
    }
}
