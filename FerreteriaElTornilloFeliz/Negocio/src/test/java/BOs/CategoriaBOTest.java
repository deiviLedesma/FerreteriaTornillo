/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package BOs;

import DAO.CategoriaDAO;
import DTOEntrada.DTOEntradaCategoria;
import DTOSalida.DTOSalidaCategoria;
import Excepcion.NegocioException;
import Interfaces.ICategoriaDAO;
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
public class CategoriaBOTest {

    private static CategoriaBO categoriaBO;
    private static String idCategoria;

    @BeforeAll
    static void setUp() {
        ICategoriaDAO categoriaDAO = new CategoriaDAO();
        categoriaBO = new CategoriaBO(categoriaDAO);
    }

    @Test
    @Order(1)
    void testRegistrarCategoria() throws NegocioException {
        DTOEntradaCategoria dto = new DTOEntradaCategoria();
        dto.setNombre("CategoriaTest");
        categoriaBO.registrarCategoria(dto);

        // Buscar el id real
        List<DTOSalidaCategoria> lista = categoriaBO.consultarTodas();
        DTOSalidaCategoria cat = lista.stream()
                .filter(c -> "CategoriaTest".equals(c.getNombre()))
                .findFirst()
                .orElseThrow();
        idCategoria = cat.getIdCategoria();
        assertNotNull(idCategoria);
    }

    @Test
    @Order(2)
    void testBuscarPorId() throws NegocioException {
        DTOSalidaCategoria categoria = categoriaBO.buscarPorId(idCategoria);
        assertNotNull(categoria);
        assertEquals("CategoriaTest", categoria.getNombre());
    }

    @Test
    @Order(3)
    void testBuscarTodos() throws NegocioException {
        List<DTOSalidaCategoria> categorias = categoriaBO.consultarTodas();
        assertNotNull(categorias);
        assertFalse(categorias.isEmpty());
    }
}
