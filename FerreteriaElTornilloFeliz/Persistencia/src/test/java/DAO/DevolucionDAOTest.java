/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAO;

import Excepcion.PersistenciaException;
import POJOs.Devolucion;
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
 * Pruebas unitarias para DevolucionDAO. Estas pruebas interactúan con la base
 * de datos MongoDB real
 *
 * @author SDavidLedesma
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DevolucionDAOTest {

    private static DevolucionDAO devolucionDAO;
    private static ObjectId idDevolucionCreada;

    @BeforeAll
    static void setUpClass() {
        devolucionDAO = new DevolucionDAO();
    }

    @Test
    @Order(1)
    void testInsertarDevolucion() throws PersistenciaException {
        Devolucion devolucion = new Devolucion();
        devolucion.setFecha(new Date());
        devolucion.setMotivo("Producto dañado");
        devolucion.setUsuario("usuarioPrueba");
        Devolucion resultado = devolucionDAO.insertar(devolucion);
        assertNotNull(resultado.getId());
        idDevolucionCreada = resultado.getId();
    }

    @Test
    @Order(2)
    void testBuscarPorId() throws PersistenciaException {
        Devolucion devolucion = devolucionDAO.buscarPorId(idDevolucionCreada);
        assertNotNull(devolucion);
    }

    @Test
    @Order(3)
    void testActualizarDevolucion() throws PersistenciaException {
        Devolucion devolucion = devolucionDAO.buscarPorId(idDevolucionCreada);
        devolucion.setMotivo("Motivo actualizado");
        Devolucion actualizado = devolucionDAO.actualizar(devolucion);
        assertEquals("Motivo actualizado", actualizado.getMotivo());
    }

    @Test
    @Order(4)
    void testBuscarPorRangoFechas() throws PersistenciaException {
        List<Devolucion> devoluciones = devolucionDAO.buscarPorRangoFechas(
                new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24), new Date());
        assertFalse(devoluciones.isEmpty());
    }

    @Test
    @Order(5)
    void testBuscarTodos() throws PersistenciaException {
        List<Devolucion> devoluciones = devolucionDAO.buscarTodos();
        assertTrue(devoluciones.size() > 0);
    }

    @Test
    @Order(6)
    void testEliminarDevolucion() throws PersistenciaException {
        devolucionDAO.eliminar(idDevolucionCreada);
        Devolucion eliminado = devolucionDAO.buscarPorId(idDevolucionCreada);
        assertNull(eliminado);
    }

    @Test
    @Order(7)
    void testReporteDevolucionesPorFechasYUsuario() throws PersistenciaException {
        // Inserta una devolución de prueba
        Devolucion devolucion = new Devolucion();
        devolucion.setFecha(new Date());
        devolucion.setUsuario("usuarioPrueba");
        devolucion.setMotivo("Motivo de reporte");
        Devolucion resultado = devolucionDAO.insertar(devolucion);

        // Reporte para rango de fechas y usuario
        Date inicio = new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24);
        Date fin = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24);
        List<Devolucion> reporte = devolucionDAO.buscarPorRangoFechas(inicio, fin);
        assertFalse(reporte.isEmpty());

        List<Devolucion> porUsuario = devolucionDAO.buscarPorUsuario("usuarioPrueba");
        assertFalse(porUsuario.isEmpty());

        devolucionDAO.eliminar(resultado.getId());
    }

}
