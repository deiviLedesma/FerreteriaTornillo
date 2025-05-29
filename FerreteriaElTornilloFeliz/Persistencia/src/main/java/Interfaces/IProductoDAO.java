/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Excepcion.PersistenciaException;
import POJOs.Producto;
import java.util.List;

/**
 * Interfaz DAO para la gestión de productos. Proporciona operaciones CRUD y
 * consultas especializadas para productos.
 *
 * @author SDavidLedesma
 */
public interface IProductoDAO {

    /**
     * Inserta un nuevo producto en la base de datos.
     *
     * @param producto Objeto Producto a insertar.
     * @return El producto insertado con su ID generado.
     * @throws PersistenciaException Si ocurre un error durante la inserción.
     */
    Producto insertar(Producto producto) throws PersistenciaException;

    /**
     * Actualiza un producto existente en la base de datos.
     *
     * @param producto Objeto Producto con información actualizada.
     * @return El producto actualizado.
     * @throws PersistenciaException Si ocurre un error durante la
     * actualización.
     */
    Producto actualizar(Producto producto) throws PersistenciaException;

    /**
     * Elimina un producto por su identificador único.
     *
     * @param idProducto ID del producto a eliminar.
     * @throws PersistenciaException Si ocurre un error durante la eliminación.
     */
    void eliminar(Object idProducto) throws PersistenciaException;

    /**
     * Busca un producto por su identificador único.
     *
     * @param idProducto ID del producto a buscar.
     * @return El producto encontrado, o null si no existe.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda.
     */
    Producto buscarPorId(Object idProducto) throws PersistenciaException;

    /**
     * Obtiene todos los productos registrados en la base de datos.
     *
     * @return Lista de productos.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    List<Producto> buscarTodos() throws PersistenciaException;

    /**
     * Busca productos cuyo nombre coincida parcial o totalmente con el valor
     * especificado. La búsqueda es insensible a mayúsculas/minúsculas.
     *
     * @param nombre Nombre o parte del nombre a buscar.
     * @return Lista de productos que cumplen el criterio de búsqueda.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    List<Producto> buscarPorNombre(String nombre) throws PersistenciaException;

    /**
     * Busca productos que pertenecen a una categoría específica.
     *
     * @param idCategoria ID de la categoría.
     * @return Lista de productos de la categoría indicada.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    List<Producto> buscarPorCategoria(Object idCategoria) throws PersistenciaException;

    /**
     * Busca productos que utilizan una unidad de medida específica.
     *
     * @param idUnidadMedida ID de la unidad de medida.
     * @return Lista de productos de la unidad de medida indicada.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    List<Producto> buscarPorUnidadMedida(Object idUnidadMedida) throws PersistenciaException;

    /**
     * Obtiene productos con existencias iguales o menores al límite
     * especificado (bajo stock).
     *
     * @param limite Valor límite de existencias.
     * @return Lista de productos con bajo stock.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    List<Producto> productosBajoStock(int limite) throws PersistenciaException;
}
