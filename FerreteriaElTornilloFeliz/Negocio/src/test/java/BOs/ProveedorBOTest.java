/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package BOs;

import DAO.ProveedorDAO;
import DTOEntrada.DTOEntradaProveedor;
import DTOSalida.DTOSalidaProveedor;
import Excepcion.NegocioException;
import Interfaces.IProveedorDAO;
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
public class ProveedorBOTest {

    private static ProveedorBO proveedorBO;
    private static String idProveedor;

    @BeforeAll
    static void setUp() {
        IProveedorDAO proveedorDAO = new ProveedorDAO();
        proveedorBO = new ProveedorBO(proveedorDAO);
    }

    @Test
    @Order(1)
    void testRegistrarProveedor() throws NegocioException {
        DTOEntradaProveedor dto = new DTOEntradaProveedor();
        dto.setNombre("ProveedorTest");
        dto.setCorreo("proveedor@test.com");
        dto.setTelefono("5555555555");
        dto.setDireccion("Dirección test");
        proveedorBO.registrarProveedor(dto);

        // Buscar el id real
        List<DTOSalidaProveedor> lista = proveedorBO.consultarTodos();
        DTOSalidaProveedor prov = lista.stream()
                .filter(p -> "ProveedorTest".equals(p.getNombre()))
                .findFirst()
                .orElseThrow();
        idProveedor = prov.getIdProveedor();
        assertNotNull(idProveedor);
    }

    @Test
    @Order(2)
    void testBuscarPorId() throws NegocioException {
        DTOSalidaProveedor prov = proveedorBO.buscarPorId(idProveedor);
        assertNotNull(prov);
        assertEquals("ProveedorTest", prov.getNombre());
    }

    @Test
    @Order(3)
    void testBuscarTodos() throws NegocioException {
        List<DTOSalidaProveedor> proveedores = proveedorBO.consultarTodos();
        assertNotNull(proveedores);
        assertFalse(proveedores.isEmpty());
    }
}
