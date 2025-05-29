/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAO;

import Excepcion.PersistenciaException;
import POJOs.Usuario;
import Utilidades.EncriptadorUtil;
import java.util.List;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * Pruebas unitarias para UsuarioDAO. Estas pruebas interactúan con la base de
 * datos MongoDB real
 *
 * @author SDavidLedesma
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UsuarioDAOTest {

    private static UsuarioDAO usuarioDAO;
    private static ObjectId idUsuarioCreado;

    @BeforeAll
    static void setUpClass() {
        usuarioDAO = new UsuarioDAO();
    }

    @Test
    @Order(1)
    void testInsertarUsuario() throws PersistenciaException {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("usuarioPrueba");
        usuario.setNombreCompleto("Usuario Prueba Completo");
        usuario.setContrasena(EncriptadorUtil.encriptar("1234"));
        Usuario resultado = usuarioDAO.insertar(usuario);
        assertNotNull(resultado.getId());
        idUsuarioCreado = resultado.getId();
    }

    @Test
    @Order(2)
    void testBuscarPorId() throws PersistenciaException {
        Usuario usuario = usuarioDAO.buscarPorId(idUsuarioCreado);
        assertNotNull(usuario);
        assertEquals("usuarioPrueba", usuario.getNombreUsuario());
    }

    @Test
    @Order(3)
    void testActualizarUsuario() throws PersistenciaException {
        Usuario usuario = usuarioDAO.buscarPorId(idUsuarioCreado);
        usuario.setNombreCompleto("Usuario Prueba Actualizado");
        Usuario actualizado = usuarioDAO.actualizar(usuario);
        assertEquals("Usuario Prueba Actualizado", actualizado.getNombreCompleto());
    }

    @Test
    @Order(4)
    void testBuscarPorNombreUsuario() throws PersistenciaException {
        Usuario usuario = usuarioDAO.buscarPorNombreUsuario("usuarioPrueba");
        assertNotNull(usuario);
    }

    @Test
    @Order(5)
    void testBuscarTodos() throws PersistenciaException {
        List<Usuario> usuarios = usuarioDAO.buscarTodos();
        assertTrue(usuarios.size() > 0);
    }

    @Test
    @Order(6)
    void testEliminarUsuario() throws PersistenciaException {
        usuarioDAO.eliminar(idUsuarioCreado);
        Usuario eliminado = usuarioDAO.buscarPorId(idUsuarioCreado);
        assertNull(eliminado);
    }
}
