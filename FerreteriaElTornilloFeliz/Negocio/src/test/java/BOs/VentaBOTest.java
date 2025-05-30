/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package BOs;

import DTOEntrada.DTOEntradaCaja;
import DTOEntrada.DTOEntradaCategoria;
import DTOEntrada.DTOEntradaDetalleVenta;
import DTOEntrada.DTOEntradaProducto;
import DTOEntrada.DTOEntradaUnidadMedida;
import DTOEntrada.DTOEntradaUsuario;
import DTOEntrada.DTOEntradaVenta;
import DTOSalida.DTOSalidaCaja;
import DTOSalida.DTOSalidaVenta;
import Excepcion.NegocioException;
import Utilidades.EncriptadorUtil;
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
public class VentaBOTest {

    private static VentaBO ventaBO;
    private static ProductoBO productoBO;
    private static CajaBO cajaBO;
    private static UsuarioBO usuarioBO;
    private static String idVenta;
    private static String idUsuario;
    private static String idProducto;
    private static String idCaja;

    @BeforeAll
    static void setUp() throws NegocioException {
        ventaBO = new VentaBO();
        productoBO = new ProductoBO();
        cajaBO = new CajaBO();
        usuarioBO = new UsuarioBO();

        // Crear usuario de prueba
        DTOEntradaUsuario dtoUsuario = new DTOEntradaUsuario();
        dtoUsuario.setNombreUsuario("usuarioVentaTest");
        dtoUsuario.setNombreCompleto("Usuario Venta Test");
        dtoUsuario.setContrasena(EncriptadorUtil.encriptar("venta123"));
        usuarioBO.registrarUsuario(dtoUsuario);
        idUsuario = usuarioBO.consultarTodos().stream()
                .filter(u -> "usuarioVentaTest".equals(u.getNombreUsuario()))
                .findFirst().orElseThrow().getIdUsaurio();

        // Crear producto de prueba (requiere categoría y unidad)
        CategoriaBO categoriaBO = new CategoriaBO();
        UnidadMedidaBO unidadBO = new UnidadMedidaBO();
        DTOEntradaCategoria catDto = new DTOEntradaCategoria();
        catDto.setNombre("CatVentaTest");
        categoriaBO.registrarCategoria(catDto);
        String idCategoria = categoriaBO.consultarTodas().stream()
                .filter(c -> "CatVentaTest".equals(c.getNombre()))
                .findFirst().orElseThrow().getIdCategoria();

        DTOEntradaUnidadMedida unidadDto = new DTOEntradaUnidadMedida();
        unidadDto.setNombre("UnidadVentaTest");
        unidadBO.registrarUnidadMedida(unidadDto);
        String idUnidad = unidadBO.consultarTodas().stream()
                .filter(u -> "UnidadVentaTest".equals(u.getNombre()))
                .findFirst().orElseThrow().getIdUnidadMedida();

        DTOEntradaProducto prodDto = new DTOEntradaProducto();
        prodDto.setNombre("ProductoVentaTest");
        prodDto.setDescripcion("Desc Venta");
        prodDto.setIdCategoria(idCategoria);
        prodDto.setIdUnidadMedida(idUnidad);
        prodDto.setPrecioCompra(5.0);
        prodDto.setPrecioVenta(10.0);
        prodDto.setExistencias(10);
        productoBO.registrarProducto(prodDto);
        idProducto = productoBO.consultarTodos().stream()
                .filter(p -> "ProductoVentaTest".equals(p.getNombre()))
                .findFirst().orElseThrow().getIdProducto();

        // Crear caja activa para la venta
        DTOSalidaCaja cajaActiva = cajaBO.buscarCajaActiva();
        if (cajaActiva == null || cajaActiva.getFechaHoraCierre() != null) {
            DTOEntradaCaja dtoCaja = new DTOEntradaCaja();
            dtoCaja.setFechaHoraApertura(new Date());
            dtoCaja.setMontoInicial(100.0);
            dtoCaja.setIdUsuario(idUsuario);
            cajaBO.abrirCaja(dtoCaja);
        }
        idCaja = cajaBO.buscarCajaActiva().getIdCaja();
    }

    @Test
    @Order(1)
    void testRegistrarVenta() throws NegocioException {
        DTOEntradaDetalleVenta detalle = new DTOEntradaDetalleVenta();
        detalle.setIdProducto(idProducto);
        detalle.setCantidad(2);
        detalle.setPrecioUnitario(10.0);

        DTOEntradaVenta dto = new DTOEntradaVenta();
        dto.setFechaHora(new Date());
        dto.setDetalles(List.of(detalle));
        dto.setTotal(20.0);
        dto.setIdUsuario(idUsuario);
        dto.setIdCaja(idCaja);

        ventaBO.registrarVenta(dto);

        // DEBUG: muestra las ventas
        List<DTOSalidaVenta> ventas = ventaBO.buscarTodas();
        for (DTOSalidaVenta v : ventas) {
            System.out.println("VENTA: id=" + v.getIdVenta() + ", usuario=" + v.getUsuario() + ", idUsuario=" + v.getIdUsuario());
        }

        // Intenta buscar por nombre de usuario si el id está null
        DTOSalidaVenta venta = ventas.stream()
                .filter(v -> idUsuario != null && idUsuario.equals(v.getIdUsuario()))
                .findFirst()
                .orElse(null);

        if (venta == null) {
            venta = ventas.stream()
                    .filter(v -> "usuarioVentaTest".equals(v.getUsuario()))
                    .findFirst()
                    .orElse(null);
        }

        assertNotNull(venta, "No se encontró la venta de prueba");
        idVenta = venta.getIdVenta();
        assertNotNull(idVenta);
    }

    @Test
    @Order(2)
    void testBuscarPorId() throws NegocioException {
        DTOSalidaVenta venta = ventaBO.buscarPorId(idVenta);
        assertNotNull(venta);
        assertEquals(idVenta, venta.getIdVenta());
    }

    @Test
    @Order(3)
    void testBuscarTodos() throws NegocioException {
        List<DTOSalidaVenta> ventas = ventaBO.buscarTodas();
        assertNotNull(ventas);
        assertFalse(ventas.isEmpty());
    }

    /**
    @Test
    @Order(4)
    void testReporteVentasPorRangoFechasYUsuario() throws NegocioException {
        Date inicio = new Date(System.currentTimeMillis() - 1000L * 60 * 60 * 24);
        Date fin = new Date(System.currentTimeMillis() + 1000L * 60 * 60 * 24);
        List<DTOSalidaVenta> reporte = ventaBO.buscarPorRangoFechasYUsuario(inicio, fin, idUsuario);
        assertNotNull(reporte);
        assertFalse(reporte.isEmpty(), "El reporte no debe estar vacío");
    }
    **/
}
