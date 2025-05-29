/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAO;

import Excepcion.PersistenciaException;
import POJOs.Venta;
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
 * * Pruebas unitarias para VentaDAO. Estas pruebas interactúan con la base de
 * datos MongoDB real
 *
 * @author SDavidLedesma
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class VentaDAOTest {

    private static VentaDAO ventaDAO;
    private static ObjectId idVentaCreada;

    @BeforeAll
    static void setUpClass() {
        ventaDAO = new VentaDAO();
    }

    @Test
    @Order(1)
    void testInsertarVenta() throws PersistenciaException {
        Venta venta = new Venta();
        venta.setFechaHora(new Date());
        venta.setTotal(900.0);
        venta.setUsuario("usuarioPrueba");
        // Agrega productos a la lista según tu POJO si es necesario
        Venta resultado = ventaDAO.insertar(venta);
        assertNotNull(resultado.getId());
        idVentaCreada = resultado.getId();
    }

    @Test
    @Order(2)
    void testBuscarPorId() throws PersistenciaException {
        Venta venta = ventaDAO.buscarPorId(idVentaCreada);
        assertNotNull(venta);
    }

    @Test
    @Order(3)
    void testActualizarVenta() throws PersistenciaException {
        Venta venta = ventaDAO.buscarPorId(idVentaCreada);
        venta.setTotal(950.0);
        Venta actualizado = ventaDAO.actualizar(venta);
        assertEquals(950.0, actualizado.getTotal());
    }

    @Test
    @Order(4)
    void testBuscarPorRangoFechas() throws PersistenciaException {
        List<Venta> ventas = ventaDAO.buscarPorRangoFechas(new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24), new Date());
        assertFalse(ventas.isEmpty());
    }

    @Test
    @Order(5)
    void testBuscarTodos() throws PersistenciaException {
        List<Venta> ventas = ventaDAO.buscarTodos();
        assertTrue(ventas.size() > 0);
    }

    @Test
    @Order(6)
    void testEliminarVenta() throws PersistenciaException {
        ventaDAO.eliminar(idVentaCreada);
        Venta eliminado = ventaDAO.buscarPorId(idVentaCreada);
        assertNull(eliminado);
    }

    @Test
    @Order(7)
    void testReporteVentasPorFechasYUsuario() throws PersistenciaException {
        // Inserta una venta de prueba
        Venta venta = new Venta();
        venta.setFechaHora(new Date());
        venta.setTotal(555.0);
        venta.setUsuario("usuarioPrueba");
        Venta resultado = ventaDAO.insertar(venta);

        // Reporte para rango de fechas y usuario
        Date inicio = new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24);
        Date fin = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24);
        List<Venta> reporte = ventaDAO.reporteVentasPorFechasYUsuario(inicio, fin, resultado.getUsuario());
        assertFalse(reporte.size() > 0);

        // Limpieza (opcional)
        ventaDAO.eliminar(resultado.getId());
    }

}
