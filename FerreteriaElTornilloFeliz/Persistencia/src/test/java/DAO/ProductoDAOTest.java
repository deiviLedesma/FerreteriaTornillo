/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAO;

import Excepcion.PersistenciaException;
import POJOs.Producto;
import java.util.List;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * Pruebas unitarias para ProductoDAO. Estas pruebas interactúan con la base de
 * datos MongoDB real
 *
 * @author SDavidLedesma
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductoDAOTest {

    private static ProductoDAO productoDAO;
    private static ObjectId idProductoCreado;

    @BeforeAll
    static void setUpClass() {
        productoDAO = new ProductoDAO();
    }

    @Test
    @Order(1)
    void testInsertarProducto() throws PersistenciaException {
        Producto producto = new Producto();
        producto.setNombre("Martillo Test");
        producto.setDescripcion("Martillo de prueba");
        producto.setPrecioCompra(40.0);
        producto.setPrecioVenta(65.0);
        producto.setExistencias(100);
        // Completa los demás campos según tu POJO

        Producto resultado = productoDAO.insertar(producto);

        assertNotNull(resultado.getId(), "El producto debe tener ID generado");
        idProductoCreado = resultado.getId();
    }

    @Test
    @Order(2)
    void testBuscarPorId() throws PersistenciaException {
        assertNotNull(idProductoCreado, "Debe haber un producto creado");
        Producto producto = productoDAO.buscarPorId(idProductoCreado);
        assertNotNull(producto, "El producto debe existir en BD");
        assertEquals("Martillo Test", producto.getNombre());
    }

    @Test
    @Order(3)
    void testActualizarProducto() throws PersistenciaException {
        Producto producto = productoDAO.buscarPorId(idProductoCreado);
        producto.setDescripcion("Martillo de prueba actualizado");
        Producto actualizado = productoDAO.actualizar(producto);
        assertEquals("Martillo de prueba actualizado", actualizado.getDescripcion());
    }

    @Test
    @Order(4)
    void testBuscarTodos() throws PersistenciaException {
        List<Producto> productos = productoDAO.buscarTodos();
        assertTrue(productos.size() > 0, "Debe haber productos en la base de datos");
    }

    @Test
    @Order(5)
    void testBuscarPorNombre() throws PersistenciaException {
        List<Producto> encontrados = productoDAO.buscarPorNombre("Martillo");
        assertFalse(encontrados.isEmpty(), "Debe haber al menos un martillo");
    }

    @Test
    @Order(6)
    void testEliminarProducto() throws PersistenciaException {
        productoDAO.eliminar(idProductoCreado);
        Producto eliminado = productoDAO.buscarPorId(idProductoCreado);
        assertNull(eliminado, "El producto debe estar eliminado");
    }
}
