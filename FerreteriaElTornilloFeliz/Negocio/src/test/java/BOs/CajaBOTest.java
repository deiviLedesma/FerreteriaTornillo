/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package BOs;

import DTOEntrada.DTOEntradaCaja;
import DTOSalida.DTOSalidaCaja;
import Excepcion.NegocioException;
import java.util.Date;
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
public class CajaBOTest {

    private static CajaBO cajaBO;
    private static String idCajaAbierta;

    @BeforeAll
    static void setUp() {
        cajaBO = new CajaBO();
    }

    @Test
    @Order(1)
    void testAbrirCaja() throws NegocioException {
        DTOEntradaCaja dto = new DTOEntradaCaja();
        dto.setFechaHoraApertura(new Date());
        dto.setMontoInicial(500.0);
        dto.setIdUsuario("id_usuario_valido");
        DTOSalidaCaja caja = cajaBO.abrirCaja(dto);
        assertNotNull(caja.getIdCaja());
        idCajaAbierta = caja.getIdCaja();
    }

    @Test
    @Order(2)
    void testAbrirCajaYaExisteActiva() {
        DTOEntradaCaja dto = new DTOEntradaCaja();
        dto.setFechaHoraApertura(new Date());
        dto.setMontoInicial(200.0);
        dto.setIdUsuario("id_usuario_valido");
        assertThrows(NegocioException.class, () -> cajaBO.abrirCaja(dto));
    }

    @Test
    @Order(3)
    void testBuscarCajaActiva() throws NegocioException {
        DTOSalidaCaja activa = cajaBO.buscarCajaActiva();
        assertNotNull(activa);
        assertNull(activa.getFechaHoraCierre());
    }

    @Test
    @Order(4)
    void testCerrarCaja() throws NegocioException {
        DTOSalidaCaja dto = cajaBO.buscarCajaActiva();
        dto.setFechaHoraCierre(new Date());
        dto.setMontoFinal(700.0);
        dto.setObservaciones("Cierre correcto");
        dto.setIdUsuarioCierre("id_usuario_valido");
        dto.setUsuarioCierre("usuarioPrueba");
        DTOSalidaCaja cerrada = cajaBO.cerrarCaja(dto);
        assertNotNull(cerrada.getFechaHoraCierre());
    }

    @Test
    @Order(5)
    void testCerrarCajaYaCerrada() throws NegocioException {
        DTOSalidaCaja dto = cajaBO.buscarPorId(idCajaAbierta);
        assertNotNull(dto);
        assertThrows(NegocioException.class, () -> cajaBO.cerrarCaja(dto));
    }

    @Test
    @Order(6)
    void testBuscarTodos() throws NegocioException {
        List<DTOSalidaCaja> cajas = cajaBO.buscarTodos();
        assertNotNull(cajas);
        assertFalse(cajas.isEmpty());
    }
}
