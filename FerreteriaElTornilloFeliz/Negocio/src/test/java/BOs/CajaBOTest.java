/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package BOs;

import DTOEntrada.DTOEntradaCaja;
import DTOEntrada.DTOEntradaUsuario;
import DTOSalida.DTOSalidaCaja;
import DTOSalida.DTOSalidaUsuario;
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
class CajaBOTest {

    private static CajaBO cajaBO;
    private static UsuarioBO usuarioBO;
    private static String idUsuario;
    private static String idCaja;

    @BeforeAll
    static void setUp() throws NegocioException {
        cajaBO = new CajaBO();
        usuarioBO = new UsuarioBO();

        // 1. Crear usuario (no retorna nada)
        DTOEntradaUsuario dtoUsuario = new DTOEntradaUsuario();
        dtoUsuario.setNombreUsuario("usuarioTestCaja");
        dtoUsuario.setNombreCompleto("Usuario Prueba Caja");
        dtoUsuario.setContrasena("test123");
        usuarioBO.registrarUsuario(dtoUsuario);

        // 2. Buscar id del usuario creado
        List<DTOSalidaUsuario> listaUsuarios = usuarioBO.consultarTodos();
        DTOSalidaUsuario usuario = listaUsuarios.stream()
                .filter(u -> "usuarioTestCaja".equals(u.getNombreUsuario()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No se encontró usuario de prueba"));
        idUsuario = usuario.getIdUsaurio();

    }

    @Test
    @Order(1)
    void testAbrirCaja() throws NegocioException {
        DTOEntradaCaja dto = new DTOEntradaCaja();
        dto.setFechaHoraApertura(new Date());
        dto.setMontoInicial(200.0);
        dto.setIdUsuario(idUsuario);
        DTOSalidaCaja salida = cajaBO.abrirCaja(dto);
        assertNotNull(salida.getIdCaja());
        idCaja = salida.getIdCaja();
    }

    @Test
    @Order(2)
    void testBuscarCajaActiva() throws NegocioException {
        DTOSalidaCaja caja = cajaBO.buscarCajaActiva();
        assertNotNull(caja);
        assertNull(caja.getFechaHoraCierre());
        idCaja = caja.getIdCaja();
    }

    @Test
    @Order(3)
    void testBuscarPorId() throws NegocioException {
        assertNotNull(idCaja, "El idCaja no debe ser null");
        DTOSalidaCaja caja = cajaBO.buscarPorId(idCaja);
        assertNotNull(caja);
    }

    @Test
    @Order(4)
    void testCerrarCaja() throws NegocioException {
        // Buscar la caja activa antes de cerrar
        DTOSalidaCaja cajaActiva = cajaBO.buscarCajaActiva();
        assertNotNull(cajaActiva, "No hay caja activa para cerrar.");
        assertNull(cajaActiva.getFechaHoraCierre(), "La caja ya está cerrada.");

        // Realizar el cierre usando el método correcto
        double montoFinal = cajaActiva.getMontoInicial(); // o algún monto distinto para probar
        DTOSalidaCaja cerrada = cajaBO.cerrarCaja(cajaActiva.getIdCaja(), montoFinal);

        // Validaciones
        assertNotNull(cerrada, "Debe regresar el DTO de la caja cerrada.");
        assertNotNull(cerrada.getFechaHoraCierre(), "La caja debe tener fecha de cierre.");
        assertEquals(montoFinal, cerrada.getMontoFinal(), "El monto final debe ser el esperado.");
        assertEquals(cajaActiva.getIdCaja(), cerrada.getIdCaja(), "El ID de la caja debe coincidir.");
    }

    @Test
    @Order(5)
    void testBuscarTodos() throws NegocioException {
        List<DTOSalidaCaja> cajas = cajaBO.buscarTodos();
        assertNotNull(cajas);
        assertFalse(cajas.isEmpty());
    }

    @Test
    @Order(6)
    void testReporteCajasPorRangoFechas() throws NegocioException {
        // Creamos una caja de prueba para asegurar al menos 1 en el rango
        DTOEntradaCaja dto = new DTOEntradaCaja();
        dto.setFechaHoraApertura(new Date());
        dto.setMontoInicial(100.0);
        dto.setIdUsuario(idUsuario);
        cajaBO.abrirCaja(dto);

        // Definimos un rango que cubra el día de hoy
        Date inicio = new Date(System.currentTimeMillis() - 1000L * 60 * 60 * 24); // 24h antes
        Date fin = new Date(System.currentTimeMillis() + 1000L * 60 * 60 * 24);   // 24h después

        List<DTOSalidaCaja> reporte = cajaBO.reporteCajasPorRangoFechas(inicio, fin);

        assertNotNull(reporte, "El reporte no debe ser nulo");
        assertFalse(reporte.isEmpty(), "El reporte debe tener al menos una caja en el rango");

        //  imprimir los ids para validar en consola
        reporte.forEach(caja -> System.out.println("Caja reportada: " + caja.getIdCaja()));
    }

}
