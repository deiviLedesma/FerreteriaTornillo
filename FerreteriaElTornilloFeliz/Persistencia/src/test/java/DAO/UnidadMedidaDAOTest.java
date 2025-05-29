/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAO;

import Excepcion.PersistenciaException;
import POJOs.UnidadMedida;
import java.util.List;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * Pruebas unitarias para UnidadMedidaDAO. Estas pruebas interactúan con la base de
 * datos MongoDB real
 *
 * @author SDavidLedesma
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UnidadMedidaDAOTest {

    private static UnidadMedidaDAO unidadMedidaDAO;
    private static ObjectId idUnidadCreada;

    @BeforeAll
    static void setUpClass() {
        unidadMedidaDAO = new UnidadMedidaDAO();
    }

    @Test
    @Order(1)
    void testInsertarUnidadMedida() throws PersistenciaException {
        UnidadMedida unidad = new UnidadMedida();
        unidad.setNombre("Pieza");
        UnidadMedida resultado = unidadMedidaDAO.insertar(unidad);
        assertNotNull(resultado.getId());
        idUnidadCreada = resultado.getId();
    }

    @Test
    @Order(2)
    void testBuscarPorId() throws PersistenciaException {
        UnidadMedida unidad = unidadMedidaDAO.buscarPorId(idUnidadCreada);
        assertNotNull(unidad);
        assertEquals("Pieza", unidad.getNombre());
    }

    @Test
    @Order(3)
    void testActualizarUnidadMedida() throws PersistenciaException {
        UnidadMedida unidad = unidadMedidaDAO.buscarPorId(idUnidadCreada);
        unidad.setNombre("Caja");
        UnidadMedida actualizada = unidadMedidaDAO.actualizar(unidad);
        assertEquals("Caja", actualizada.getNombre());
    }

    @Test
    @Order(4)
    void testBuscarPorNombre() throws PersistenciaException {
        List<UnidadMedida> unidades = unidadMedidaDAO.buscarPorNombre("Caja");
        assertFalse(unidades.isEmpty());
    }

    @Test
    @Order(5)
    void testBuscarTodos() throws PersistenciaException {
        List<UnidadMedida> unidades = unidadMedidaDAO.buscarTodos();
        assertTrue(unidades.size() > 0);
    }

    @Test
    @Order(6)
    void testEliminarUnidadMedida() throws PersistenciaException {
        unidadMedidaDAO.eliminar(idUnidadCreada);
        UnidadMedida eliminada = unidadMedidaDAO.buscarPorId(idUnidadCreada);
        assertNull(eliminada);
    }
}
