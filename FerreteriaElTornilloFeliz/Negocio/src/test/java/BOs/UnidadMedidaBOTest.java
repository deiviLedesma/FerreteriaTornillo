/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package BOs;

import DAO.UnidadMedidaDAO;
import DTOEntrada.DTOEntradaUnidadMedida;
import DTOSalida.DTOSalidaUnidadMedida;
import Excepcion.NegocioException;
import Interfaces.IUnidadMedidaDAO;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

/**
 *
 * @author SDavidLedesma
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UnidadMedidaBOTest {

    private static UnidadMedidaBO unidadMedidaBO;
    private static String idUnidad;

    @BeforeAll
    static void setUp() {
        IUnidadMedidaDAO unidadMedidaDAO = new UnidadMedidaDAO();
        unidadMedidaBO = new UnidadMedidaBO(unidadMedidaDAO);
    }

    @Test
    @Order(1)
    void testRegistrarUnidadMedida() throws NegocioException {
        DTOEntradaUnidadMedida dto = new DTOEntradaUnidadMedida();
        dto.setNombre("PiezaTest");
        unidadMedidaBO.registrarUnidadMedida(dto);

        // Buscar el id real
        List<DTOSalidaUnidadMedida> lista = unidadMedidaBO.consultarTodas();
        DTOSalidaUnidadMedida unidad = lista.stream()
                .filter(u -> "PiezaTest".equals(u.getNombre()))
                .findFirst()
                .orElseThrow();
        idUnidad = unidad.getIdUnidadMedida();
        assertNotNull(idUnidad);
    }

    @Test
    @Order(2)
    void testBuscarPorId() throws NegocioException {
        DTOSalidaUnidadMedida unidad = unidadMedidaBO.buscarPorId(idUnidad);
        assertNotNull(unidad);
        assertEquals("PiezaTest", unidad.getNombre());
    }

    @Test
    @Order(3)
    void testBuscarTodos() throws NegocioException {
        List<DTOSalidaUnidadMedida> unidades = unidadMedidaBO.consultarTodas();
        assertNotNull(unidades);
        assertFalse(unidades.isEmpty());
    }
}
