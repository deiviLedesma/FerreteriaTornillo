/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAO;

import Excepcion.PersistenciaException;
import POJOs.Compra;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * Pruebas unitarias para CompraDAO. Estas pruebas interactúan con la base de
 * datos MongoDB real
 *
 * @author SDavidLedesma
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CompraDAOTest {

    private static CompraDAO compraDAO;
    private static ObjectId idCompraCreada;

    @BeforeAll
    static void setUpClass() {
        compraDAO = new CompraDAO();
    }

    @Test
    @Order(1)
    void testInsertarCompra() throws PersistenciaException {
        Compra compra = new Compra();
        compra.setIdProveedor(new ObjectId()); 
        compra.setFechaHora(new Date());
        compra.setTotal(450.0);
        Compra resultado = compraDAO.insertar(compra);
        assertNotNull(resultado.getId());
        idCompraCreada = resultado.getId();
    }

    @Test
    @Order(2)
    void testBuscarPorId() throws PersistenciaException {
        Compra compra = compraDAO.buscarPorId(idCompraCreada);
        assertNotNull(compra);
    }

    @Test
    @Order(3)
    void testActualizarCompra() throws PersistenciaException {
        Compra compra = compraDAO.buscarPorId(idCompraCreada);
        compra.setTotal(555.0);
        Compra actualizado = compraDAO.actualizar(compra);
        assertEquals(555.0, actualizado.getTotal());
    }

    @Test
    @Order(4)
    void testBuscarPorRangoFechas() throws PersistenciaException {
        List<Compra> compras = compraDAO.buscarPorRangoFechas(new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24), new Date());
        assertFalse(compras.isEmpty());
    }

    @Test
    @Order(5)
    void testBuscarTodos() throws PersistenciaException {
        List<Compra> compras = compraDAO.buscarTodos();
        assertTrue(compras.size() > 0);
    }

    @Test
    @Order(6)
    void testEliminarCompra() throws PersistenciaException {
        compraDAO.eliminar(idCompraCreada);
        Compra eliminado = compraDAO.buscarPorId(idCompraCreada);
        assertNull(eliminado);
    }

    @Test
    @Order(7)
    void testReporteComprasPorFechasYProveedor() throws PersistenciaException {
        // Inserta una compra de prueba
        Compra compra = new Compra();
        compra.setIdProveedor(new ObjectId()); 
        compra.setFechaHora(new Date());
        compra.setTotal(123.45);
        Compra resultado = compraDAO.insertar(compra);

        // Reporte para rango de fechas y proveedor
        Date inicio = new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24);
        Date fin = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24);
        List<Compra> reporte = compraDAO.reporteComprasPorFechasYProveedor(inicio, fin, resultado.getIdProveedor());
        assertFalse(reporte.isEmpty());

        compraDAO.eliminar(resultado.getId());
    }

}
