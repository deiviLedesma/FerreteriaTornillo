/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAO;

import Excepcion.PersistenciaException;
import POJOs.Proveedor;
import java.util.List;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * Pruebas unitarias para ProveedorDAO. Estas pruebas interactúan con la base de
 * datos MongoDB real
 *
 * @author SDavidLedesma
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProveedorDAOTest {

    private static ProveedorDAO proveedorDAO;
    private static ObjectId idProveedorCreado;

    @BeforeAll
    static void setUpClass() {
        proveedorDAO = new ProveedorDAO();
    }

    @Test
    @Order(1)
    void testInsertarProveedor() throws PersistenciaException {
        Proveedor proveedor = new Proveedor();
        proveedor.setNombre("ProveedorTest");
        proveedor.setCorreo("proveedor@test.com");
        proveedor.setTelefono("5551234567");
        proveedor.setDireccion("Calle Falsa 123");
        Proveedor resultado = proveedorDAO.insertar(proveedor);
        assertNotNull(resultado.getId());
        idProveedorCreado = resultado.getId();
    }

    @Test
    @Order(2)
    void testBuscarPorId() throws PersistenciaException {
        Proveedor proveedor = proveedorDAO.buscarPorId(idProveedorCreado);
        assertNotNull(proveedor);
        assertEquals("ProveedorTest", proveedor.getNombre());
    }

    @Test
    @Order(3)
    void testActualizarProveedor() throws PersistenciaException {
        Proveedor proveedor = proveedorDAO.buscarPorId(idProveedorCreado);
        proveedor.setTelefono("5557654321");
        Proveedor actualizado = proveedorDAO.actualizar(proveedor);
        assertEquals("5557654321", actualizado.getTelefono());
    }

    @Test
    @Order(4)
    void testBuscarPorNombre() throws PersistenciaException {
        List<Proveedor> proveedores = proveedorDAO.buscarPorNombre("Proveedor");
        assertFalse(proveedores.isEmpty());
    }

    @Test
    @Order(5)
    void testBuscarTodos() throws PersistenciaException {
        List<Proveedor> proveedores = proveedorDAO.buscarTodos();
        assertTrue(proveedores.size() > 0);
    }

    @Test
    @Order(6)
    void testEliminarProveedor() throws PersistenciaException {
        proveedorDAO.eliminar(idProveedorCreado);
        Proveedor eliminado = proveedorDAO.buscarPorId(idProveedorCreado);
        assertNull(eliminado);
    }
}
