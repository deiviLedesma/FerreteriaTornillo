/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package BOs;

import DAO.UsuarioDAO;
import DTOEntrada.DTOEntradaUsuario;
import DTOSalida.DTOSalidaUsuario;
import Excepcion.NegocioException;
import Interfaces.IUsuarioDAO;
import Utilidades.EncriptadorUtil;
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
public class UsuarioBOTest {

    private static UsuarioBO usuarioBO;
    private static String idUsuario;

    @BeforeAll
    static void setUp() {
        IUsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioBO = new UsuarioBO(usuarioDAO);
    }

    @Test
    @Order(1)
    void testRegistrarUsuario() throws NegocioException {
        DTOEntradaUsuario dto = new DTOEntradaUsuario();
        dto.setNombreUsuario("UsuarioTest");
        dto.setNombreCompleto("Nombre Completo Test");
        dto.setContrasena(EncriptadorUtil.encriptar("test123"));
        usuarioBO.registrarUsuario(dto);

        // Buscar el id real
        List<DTOSalidaUsuario> lista = usuarioBO.consultarTodos();
        DTOSalidaUsuario usuario = lista.stream()
                .filter(u -> "UsuarioTest".equals(u.getNombreUsuario()))
                .findFirst()
                .orElseThrow();
        idUsuario = usuario.getIdUsaurio();
        assertNotNull(idUsuario);
    }

    @Test
    @Order(2)
    void testBuscarPorId() throws NegocioException {
        DTOSalidaUsuario usuario = usuarioBO.buscarPorId(idUsuario);
        assertNotNull(usuario);
        assertEquals("UsuarioTest", usuario.getNombreUsuario());
    }

    @Test
    @Order(3)
    void testBuscarTodos() throws NegocioException {
        List<DTOSalidaUsuario> usuarios = usuarioBO.consultarTodos();
        assertNotNull(usuarios);
        assertFalse(usuarios.isEmpty());
    }

    @Test
    @Order(4)
    void testValidarCredenciales() throws NegocioException {
        DTOSalidaUsuario usuario = usuarioBO.validarCredenciales("UsuarioTest", "test123");
        assertNotNull(usuario);
        assertEquals("UsuarioTest", usuario.getNombreUsuario());
    }
}
