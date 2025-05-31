/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package BOs;

import DAO.CategoriaDAO;
import DAO.ProductoDAO;
import DAO.UnidadMedidaDAO;
import DTOEntrada.DTOEntradaCategoria;
import DTOEntrada.DTOEntradaProducto;
import DTOEntrada.DTOEntradaUnidadMedida;
import DTOSalida.DTOSalidaProducto;
import Excepcion.NegocioException;
import Interfaces.ICategoriaDAO;
import Interfaces.IProductoDAO;
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
public class ProductoBOTest {

    private static ProductoBO productoBO;
    private static String idProducto;
    private static String idCategoria;
    private static String idUnidad;

    @BeforeAll
    static void setUp() throws NegocioException {
        IProductoDAO productoDAO = new ProductoDAO();
        productoBO = new ProductoBO(productoDAO);

        // Aseguramos tener al menos una categoría y unidad
        ICategoriaDAO categoriaDAO = new CategoriaDAO();
        CategoriaBO categoriaBO = new CategoriaBO(categoriaDAO);
        IUnidadMedidaDAO unidadMedidaDAO = new UnidadMedidaDAO();
        UnidadMedidaBO unidadBO = new UnidadMedidaBO(unidadMedidaDAO);

        DTOEntradaCategoria catDto = new DTOEntradaCategoria();
        catDto.setNombre("CategoriaProductoTest");
        categoriaBO.registrarCategoria(catDto);
        idCategoria = categoriaBO.consultarTodas().stream()
                .filter(c -> "CategoriaProductoTest".equals(c.getNombre()))
                .findFirst().orElseThrow().getIdCategoria();

        DTOEntradaUnidadMedida unidadDto = new DTOEntradaUnidadMedida();
        unidadDto.setNombre("UnidadProductoTest");
        unidadBO.registrarUnidadMedida(unidadDto);
        idUnidad = unidadBO.consultarTodas().stream()
                .filter(u -> "UnidadProductoTest".equals(u.getNombre()))
                .findFirst().orElseThrow().getIdUnidadMedida();
    }

    @Test
    @Order(1)
    void testRegistrarProducto() throws NegocioException {
        DTOEntradaProducto dto = new DTOEntradaProducto();
        dto.setNombre("ProductoTest");
        dto.setDescripcion("Descripción Test");
        dto.setIdCategoria(idCategoria);
        dto.setIdUnidadMedida(idUnidad);
        dto.setPrecioCompra(10.0);
        dto.setPrecioVenta(20.0);
        dto.setExistencias(5);
        productoBO.registrarProducto(dto);

        List<DTOSalidaProducto> lista = productoBO.consultarTodos();
        DTOSalidaProducto prod = lista.stream()
                .filter(p -> "ProductoTest".equals(p.getNombre()))
                .findFirst()
                .orElseThrow();
        idProducto = prod.getIdProducto();
        assertNotNull(idProducto);
    }

    @Test
    @Order(2)
    void testBuscarPorId() throws NegocioException {
        DTOSalidaProducto producto = productoBO.buscarPorId(idProducto);
        assertNotNull(producto);
        assertEquals("ProductoTest", producto.getNombre());
    }

    @Test
    @Order(3)
    void testBuscarTodos() throws NegocioException {
        List<DTOSalidaProducto> productos = productoBO.consultarTodos();
        assertNotNull(productos);
        assertFalse(productos.isEmpty());
    }
}
