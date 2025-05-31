/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package BOs;

import DAO.CategoriaDAO;
import DAO.DevolucionDAO;
import DAO.ProductoDAO;
import DAO.UnidadMedidaDAO;
import DAO.UsuarioDAO;
import DTOEntrada.DTOEntradaCategoria;
import DTOEntrada.DTOEntradaDevolucion;
import DTOEntrada.DTOEntradaProducto;
import DTOEntrada.DTOEntradaUnidadMedida;
import DTOEntrada.DTOEntradaUsuario;
import DTOSalida.DTOSalidaDevolucion;
import Excepcion.NegocioException;
import Interfaces.ICategoriaDAO;
import Interfaces.IDevolucionDAO;
import Interfaces.IProductoDAO;
import Interfaces.IUnidadMedidaDAO;
import Interfaces.IUsuarioDAO;
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
public class DevolucionBOTest {

    private static DevolucionBO devolucionBO;
    private static ProductoBO productoBO;
    private static UsuarioBO usuarioBO;
    private static CategoriaBO categoriaBO;
    private static UnidadMedidaBO unidadMedidaBO;
    private static String idProducto;
    private static String idUsuario;
    private static String idDevolucion;

    @BeforeAll
    static void setUp() throws NegocioException {
        IProductoDAO productoDAO = new ProductoDAO();
        IDevolucionDAO devolucionDAO = new DevolucionDAO();
        devolucionBO = new DevolucionBO(devolucionDAO, productoDAO);
        productoBO = new ProductoBO(productoDAO);
        IUsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioBO = new UsuarioBO(usuarioDAO);
        ICategoriaDAO categoriaDAO = new CategoriaDAO();
        categoriaBO = new CategoriaBO(categoriaDAO);
        IUnidadMedidaDAO unidadMedidaDAO = new UnidadMedidaDAO();
        unidadMedidaBO = new UnidadMedidaBO(unidadMedidaDAO);

        // Crear usuario de prueba
        DTOEntradaUsuario dtoUsuario = new DTOEntradaUsuario();
        dtoUsuario.setNombreUsuario("usuarioDevolucionTest");
        dtoUsuario.setNombreCompleto("Usuario Devolución Test");
        dtoUsuario.setContrasena(EncriptadorUtil.encriptar("dev123"));
        usuarioBO.registrarUsuario(dtoUsuario);
        idUsuario = usuarioBO.consultarTodos().stream()
                .filter(u -> "usuarioDevolucionTest".equals(u.getNombreUsuario()))
                .findFirst().orElseThrow().getIdUsaurio();

        // Crear producto de prueba (requiere categoría y unidad)
        DTOEntradaCategoria catDto = new DTOEntradaCategoria();
        catDto.setNombre("CatDevolucionTest");
        categoriaBO.registrarCategoria(catDto);
        String idCategoria = categoriaBO.consultarTodas().stream()
                .filter(c -> "CatDevolucionTest".equals(c.getNombre()))
                .findFirst().orElseThrow().getIdCategoria();

        DTOEntradaUnidadMedida unidadDto = new DTOEntradaUnidadMedida();
        unidadDto.setNombre("UnidadDevolucionTest");
        unidadMedidaBO.registrarUnidadMedida(unidadDto);
        String idUnidad = unidadMedidaBO.consultarTodas().stream()
                .filter(u -> "UnidadDevolucionTest".equals(u.getNombre()))
                .findFirst().orElseThrow().getIdUnidadMedida();

        DTOEntradaProducto prodDto = new DTOEntradaProducto();
        prodDto.setNombre("ProductoDevolucionTest");
        prodDto.setDescripcion("Desc Devolucion");
        prodDto.setIdCategoria(idCategoria);
        prodDto.setIdUnidadMedida(idUnidad);
        prodDto.setPrecioCompra(15.0);
        prodDto.setPrecioVenta(20.0);
        prodDto.setExistencias(5);
        productoBO.registrarProducto(prodDto);
        idProducto = productoBO.consultarTodos().stream()
                .filter(p -> "ProductoDevolucionTest".equals(p.getNombre()))
                .findFirst().orElseThrow().getIdProducto();
    }

    @Test
    @Order(1)
    void testRegistrarDevolucionReintegrar() throws NegocioException {
        DTOEntradaDevolucion dto = new DTOEntradaDevolucion();
        dto.setFecha(new Date());
        dto.setMotivo("Motivo de prueba");
        dto.setIdUsuario(idUsuario);
        dto.setTipo("PRODUCTO");
        dto.setIdProducto(idProducto);
        dto.setCantidad(2);
        dto.setDecision("REINTEGRAR");

        devolucionBO.registrarDevolucion(dto);

        // Buscar devolución para obtener id
        List<DTOSalidaDevolucion> devoluciones = devolucionBO.buscarTodas();
        DTOSalidaDevolucion dev = devoluciones.stream()
                .filter(d -> idUsuario.equals(d.getIdUsuario()) && "Motivo de prueba".equals(d.getMotivo()))
                .findFirst().orElseThrow();

        idDevolucion = dev.getIdDevolucion();
        assertNotNull(idDevolucion);
        assertEquals("REINTEGRAR", dev.getDecision());
    }

    @Test
    @Order(2)
    void testBuscarPorId() throws NegocioException {
        DTOSalidaDevolucion dev = devolucionBO.buscarPorId(idDevolucion);
        assertNotNull(dev);
        assertEquals(idDevolucion, dev.getIdDevolucion());
    }

    @Test
    @Order(3)
    void testBuscarTodas() throws NegocioException {
        List<DTOSalidaDevolucion> devs = devolucionBO.buscarTodas();
        assertNotNull(devs);
        assertFalse(devs.isEmpty());
    }

    @Test
    @Order(4)
    void testReporteDevolucionesPorRangoFechas() throws NegocioException {
        Date inicio = new Date(System.currentTimeMillis() - 1000L * 60 * 60 * 24);
        Date fin = new Date(System.currentTimeMillis() + 1000L * 60 * 60 * 24);
        List<DTOSalidaDevolucion> reporte = devolucionBO.reporteDevolucionesPorRangoFechas(inicio, fin);
        assertNotNull(reporte);
        assertFalse(reporte.isEmpty());
    }

    @Test
    @Order(5)
    void testReporteDevolucionesPorUsuario() throws NegocioException {
        List<DTOSalidaDevolucion> reporte = devolucionBO.reporteDevolucionesPorUsuario(idUsuario);
        assertNotNull(reporte);
        assertFalse(!reporte.isEmpty());
    }
}
