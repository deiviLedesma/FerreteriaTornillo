/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package BOs;

import DAO.CategoriaDAO;
import DAO.CompraDAO;
import DAO.ProductoDAO;
import DAO.ProveedorDAO;
import DAO.UnidadMedidaDAO;
import DAO.UsuarioDAO;
import DTOEntrada.DTOEntradaCategoria;
import DTOEntrada.DTOEntradaCompra;
import DTOEntrada.DTOEntradaDetalleCompra;
import DTOEntrada.DTOEntradaProducto;
import DTOEntrada.DTOEntradaProveedor;
import DTOEntrada.DTOEntradaUnidadMedida;
import DTOEntrada.DTOEntradaUsuario;
import DTOSalida.DTOSalidaCompra;
import Excepcion.NegocioException;
import Interfaces.ICategoriaDAO;
import Interfaces.ICompraDAO;
import Interfaces.IProductoDAO;
import Interfaces.IProveedorDAO;
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
public class CompraBOTest {

    private static CompraBO compraBO;
    private static ProveedorBO proveedorBO;
    private static ProductoBO productoBO;
    private static UsuarioBO usuarioBO;
    private static String idCompra;
    private static String idProveedor;
    private static String idProducto;
    private static String idUsuario;

    @BeforeAll
    static void setUp() throws NegocioException {
        ICompraDAO compraDAO = new CompraDAO();
        IProductoDAO productoDAO = new ProductoDAO();
        compraBO = new CompraBO(compraDAO, productoDAO);
        IProveedorDAO proveedorDAO = new ProveedorDAO();
        proveedorBO = new ProveedorBO(proveedorDAO);
        productoBO = new ProductoBO(productoDAO);
        IUsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioBO = new UsuarioBO(usuarioDAO);

        // Crear proveedor de prueba
        DTOEntradaProveedor dtoProveedor = new DTOEntradaProveedor();
        dtoProveedor.setNombre("Proveedor14CompraTest");
        dtoProveedor.setCorreo("proveedor@compra.com");
        dtoProveedor.setTelefono("5512345678");
        dtoProveedor.setDireccion("Dirección Compra");
        proveedorBO.registrarProveedor(dtoProveedor);
        idProveedor = proveedorBO.consultarTodos().stream()
                .filter(p -> "Proveedor14CompraTest".equals(p.getNombre()))
                .findFirst().orElseThrow().getIdProveedor();

        // Crear usuario de prueba
        DTOEntradaUsuario dtoUsuario = new DTOEntradaUsuario();
        dtoUsuario.setNombreUsuario("usuarioCompraTest");
        dtoUsuario.setNombreCompleto("Usuario Compra Test");
        dtoUsuario.setContrasena(EncriptadorUtil.encriptar("compra123"));
        usuarioBO.registrarUsuario(dtoUsuario);
        idUsuario = usuarioBO.consultarTodos().stream()
                .filter(u -> "usuarioCompraTest".equals(u.getNombreUsuario()))
                .findFirst().orElseThrow().getIdUsaurio();

        // Crear producto de prueba (requiere categoría y unidad)
        ICategoriaDAO categoriaDAO = new CategoriaDAO();
        CategoriaBO categoriaBO = new CategoriaBO(categoriaDAO);
        IUnidadMedidaDAO unidadMedidaDAO = new UnidadMedidaDAO();
        UnidadMedidaBO unidadBO = new UnidadMedidaBO(unidadMedidaDAO);
        DTOEntradaCategoria catDto = new DTOEntradaCategoria();
        catDto.setNombre("CatCompraTest");
        categoriaBO.registrarCategoria(catDto);
        String idCategoria = categoriaBO.consultarTodas().stream()
                .filter(c -> "CatCompraTest".equals(c.getNombre()))
                .findFirst().orElseThrow().getIdCategoria();

        DTOEntradaUnidadMedida unidadDto = new DTOEntradaUnidadMedida();
        unidadDto.setNombre("UnidadCompraTest");
        unidadBO.registrarUnidadMedida(unidadDto);
        String idUnidad = unidadBO.consultarTodas().stream()
                .filter(u -> "UnidadCompraTest".equals(u.getNombre()))
                .findFirst().orElseThrow().getIdUnidadMedida();

        DTOEntradaProducto prodDto = new DTOEntradaProducto();
        prodDto.setNombre("ProductoCompraTest");
        prodDto.setDescripcion("Desc Compra");
        prodDto.setIdCategoria(idCategoria);
        prodDto.setIdUnidadMedida(idUnidad);
        prodDto.setPrecioCompra(8.0);
        prodDto.setPrecioVenta(12.0);
        prodDto.setExistencias(10);
        productoBO.registrarProducto(prodDto);
        idProducto = productoBO.consultarTodos().stream()
                .filter(p -> "ProductoCompraTest".equals(p.getNombre()))
                .findFirst().orElseThrow().getIdProducto();
    }

    @Test
    @Order(1)
    void testRegistrarCompra() throws NegocioException {
        DTOEntradaDetalleCompra detalle = new DTOEntradaDetalleCompra();
        detalle.setIdProducto(idProducto);
        detalle.setCantidad(4);
        detalle.setPrecioUnitario(8.0);

        DTOEntradaCompra dto = new DTOEntradaCompra();
        dto.setFechaHora(new Date());
        dto.setIdProveedor(idProveedor);
        dto.setDetalles(List.of(detalle));
        dto.setTotal(32.0);
        dto.setIdUsuario(idUsuario);

        compraBO.registrarCompra(dto);

        
        List<DTOSalidaCompra> compras = compraBO.buscarTodas();
        for (DTOSalidaCompra c : compras) {
            System.out.println("Compra salida: id=" + c.getIdCompra() + ", idProveedor=" + c.getIdProveedor());
        }
        DTOSalidaCompra compra = compras.stream()
                .filter(c -> idProveedor.equals(c.getIdProveedor()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No se encontró la compra con el proveedor esperado. Id: " + idProveedor));

        idCompra = compra.getIdCompra();
        assertNotNull(idCompra, "El idCompra no debe ser null después de registrar la compra");
    }

    @Test
    @Order(2)
    void testBuscarPorId() throws NegocioException {
        DTOSalidaCompra compra = compraBO.buscarPorId(idCompra);
        assertNotNull(compra);
        assertEquals(idCompra, compra.getIdCompra());
    }

    @Test
    @Order(3)
    void testBuscarTodas() throws NegocioException {
        List<DTOSalidaCompra> compras = compraBO.buscarTodas();
        assertNotNull(compras);
        assertFalse(compras.isEmpty());
    }

    @Test
    @Order(4)
    void testReporteComprasPorRangoFechasYProveedor() throws NegocioException {
        Date inicio = new Date(System.currentTimeMillis() - 1000L * 60 * 60 * 24);
        Date fin = new Date(System.currentTimeMillis() + 1000L * 60 * 60 * 24);
        List<DTOSalidaCompra> reporte = compraBO.reporteComprasPorRangoYProveedor(inicio, fin, idProveedor);
        assertNotNull(reporte);
        assertFalse(reporte.isEmpty());
    }
}
