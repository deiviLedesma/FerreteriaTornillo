/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAO;

import Excepcion.PersistenciaException;
import POJOs.Categoria;
import java.util.List;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * Pruebas unitarias para CategoriaDAO. Estas pruebas interactúan con la base de
 * datos MongoDB real
 *
 * @author SDavidLedesma
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CategoriaDAOTest {

    private static CategoriaDAO categoriaDAO;
    private static ObjectId idCategoriaCreada;

    @BeforeAll
    static void setUpClass() {
        categoriaDAO = new CategoriaDAO();
    }

    @Test
    @Order(1)
    void testInsertarCategoria() throws PersistenciaException {
        Categoria categoria = new Categoria();
        categoria.setNombre("Herramientas Manuales");
        Categoria resultado = categoriaDAO.insertar(categoria);
        assertNotNull(resultado.getId());
        idCategoriaCreada = resultado.getId();
    }

    @Test
    @Order(2)
    void testBuscarPorId() throws PersistenciaException {
        assertNotNull(idCategoriaCreada);
        Categoria categoria = categoriaDAO.buscarPorId(idCategoriaCreada);
        assertNotNull(categoria);
        assertEquals("Herramientas Manuales", categoria.getNombre());
    }

    @Test
    @Order(3)
    void testActualizarCategoria() throws PersistenciaException {
        Categoria categoria = categoriaDAO.buscarPorId(idCategoriaCreada);
        categoria.setNombre("Herramientas Actualizadas");
        Categoria actualizada = categoriaDAO.actualizar(categoria);
        assertEquals("Herramientas Actualizadas", actualizada.getNombre());
    }

    @Test
    @Order(4)
    void testBuscarPorNombre() throws PersistenciaException {
        List<Categoria> categorias = categoriaDAO.buscarPorNombre("Herramientas");
        assertFalse(categorias.isEmpty());
    }

    @Test
    @Order(5)
    void testBuscarTodos() throws PersistenciaException {
        List<Categoria> categorias = categoriaDAO.buscarTodos();
        assertTrue(categorias.size() > 0);
    }

    @Test
    @Order(6)
    void testEliminarCategoria() throws PersistenciaException {
        categoriaDAO.eliminar(idCategoriaCreada);
        Categoria eliminada = categoriaDAO.buscarPorId(idCategoriaCreada);
        assertNull(eliminada);
    }
}
