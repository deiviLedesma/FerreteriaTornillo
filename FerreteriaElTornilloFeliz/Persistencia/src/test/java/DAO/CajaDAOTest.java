/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAO;

import Excepcion.PersistenciaException;
import POJOs.Caja;
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
 * Pruebas unitarias para CajaDAO. Estas pruebas interactúan con la base de
 * datos MongoDB real
 *
 * @author SDavidLedesma
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CajaDAOTest {

    private static CajaDAO cajaDAO;
    private static ObjectId idCajaCreada;

    @BeforeAll
    static void setUpClass() {
        cajaDAO = new CajaDAO();
    }

    @Test
    @Order(1)
    void testAbrirCaja() throws PersistenciaException {
        Caja caja = new Caja();
        caja.setFechaHoraApertura(new Date());
        caja.setMontoInicial(1000.0);
        Caja resultado = cajaDAO.abrirCaja(caja);
        assertNotNull(resultado.getId());
        idCajaCreada = resultado.getId();
    }

    @Test
    @Order(2)
    void testBuscarPorId() throws PersistenciaException {
        Caja caja = cajaDAO.buscarPorId(idCajaCreada);
        assertNotNull(caja);
    }

    @Test
    @Order(3)
    void testCerrarCaja() throws PersistenciaException {
        Caja caja = cajaDAO.buscarPorId(idCajaCreada);
        caja.setFechaHoraCierre(new Date());
        caja.setMontoFinal(950.0);
        Caja cerrada = cajaDAO.cerrarCaja(caja);
        assertEquals(950.0, cerrada.getMontoFinal());
    }

    @Test
    @Order(4)
    void testBuscarCajaActiva() throws PersistenciaException {
        Caja activa = cajaDAO.buscarCajaActiva();
        // Puede ser null si todas las cajas están cerradas
        // Aquí solo verifica que no falle la llamada
    }

    @Test
    @Order(5)
    void testBuscarTodos() throws PersistenciaException {
        List<Caja> cajas = cajaDAO.buscarTodos();
        assertTrue(cajas.size() > 0);
    }

    @Test
    @Order(6)
    void testReporteCajasPorRangoFechas() throws PersistenciaException {
        Caja caja = new Caja();
        caja.setFechaHoraApertura(new Date());
        caja.setMontoFinal(500.0);

        // Guarda el resultado del insert
        Caja resultado = cajaDAO.abrirCaja(caja);
        assertNotNull(resultado.getId()); // Confirmar que se insertó

        Date inicio = new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24);
        Date fin = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24);
        List<Caja> cajas = cajaDAO.buscarPorRangoFechas(inicio, fin);
        assertTrue(cajas.size() > 0);

        // Usa el objeto exacto que se inserto
        resultado.setFechaHoraCierre(new Date());
        resultado.setMontoFinal(550.0);
        Caja cerrada = cajaDAO.cerrarCaja(resultado);
        assertEquals(550.0, cerrada.getMontoFinal());
    }

}
