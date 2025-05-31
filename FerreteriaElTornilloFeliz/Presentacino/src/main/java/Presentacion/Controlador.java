/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import DTOEntrada.DTOEntradaCaja;
import DTOEntrada.DTOEntradaCategoria;
import DTOEntrada.DTOEntradaCompra;
import DTOEntrada.DTOEntradaDevolucion;
import DTOEntrada.DTOEntradaProducto;
import DTOEntrada.DTOEntradaProveedor;
import DTOEntrada.DTOEntradaUnidadMedida;
import DTOEntrada.DTOEntradaUsuario;
import DTOEntrada.DTOEntradaVenta;
import DTOSalida.DTOSalidaCaja;
import DTOSalida.DTOSalidaCategoria;
import DTOSalida.DTOSalidaCompra;
import DTOSalida.DTOSalidaDetalleCompra;
import DTOSalida.DTOSalidaDetalleVenta;
import DTOSalida.DTOSalidaDevolucion;
import DTOSalida.DTOSalidaProducto;
import DTOSalida.DTOSalidaProveedor;
import DTOSalida.DTOSalidaUnidadMedida;
import DTOSalida.DTOSalidaUsuario;
import DTOSalida.DTOSalidaVenta;
import Excepcion.NegocioException;
import Interfaces.ICajaBO;
import Interfaces.ICategoriaBO;
import Interfaces.ICompraBO;
import Interfaces.IDevolucionBO;
import Interfaces.IProductoBO;
import Interfaces.IProveedorBO;
import Interfaces.IUnidadMedidaBO;
import Interfaces.IUsuarioBO;
import Interfaces.IVentaBO;
import ManejadorDeObjetos.ManejadorBOs;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author SDavidLedesma
 */
public class Controlador {

    //Atributos de seison
    private DTOSalidaCaja dTOSalidaCaja;
    private DTOSalidaUsuario dTOSalidaUsuario;
    private DTOEntradaVenta dTOEntradaVenta;
    private DTOEntradaCompra dTOEntradaCompra;
    private DTOSalidaVenta dTOSalidaVenta;
    private DTOSalidaCompra dTOSalidaCompra;
    private DTOEntradaUsuario dTOEntradaUsuario;
    private DTOEntradaDevolucion dTOEntradaDevolucion;
    private DTOSalidaDevolucion dTOSalidaDevolucion;
    private DTOSalidaDetalleVenta dTOSalidaDetalleVenta;
    private DTOSalidaDetalleCompra compra;
    private List<DTOSalidaProducto> productos = new ArrayList<>();

    //ventana principal
    private JFrame framePrincipal;

    //pantallas del sistema
    private MenuPrincipal menuPrincipal;
    private PantallaDevoluciones pantallaDevoluciones;
    private PantallaProveedores pantallaProveedores;
    private PantallaRegistrarCompra pantallaRegistrarCompra;
    private PantallaRegistrarVenta pantallaRegistrarVenta;
    private PantallaReportes pantallaReportes;
    private PantallarRegistarProducto pantallarRegistarProducto;
    private PantallaCaja pantallaCaja;
    private PantallaIniciarUsuario pantallaIniciarUsuario;

    //manejadores BO
    private ICajaBO cajaBO;
    private ICategoriaBO categoriaBO;
    private ICompraBO compraBO;
    private IDevolucionBO devolucionBO;
    private IProductoBO productoBO;
    private IProveedorBO proveedorBO;
    private IUnidadMedidaBO unidadMedidaBO;
    private IUsuarioBO usuarioBO;
    private IVentaBO ventaBO;

    /**
     * ccinstructor de la clase que crea las BO e inicializ las pantallas
     */
    public Controlador() {
        framePrincipal = new JFrame("Ferreteria El Tornillo Feliz");
        framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePrincipal.setSize(1150, 700);
        framePrincipal.setLocationRelativeTo(null);
        framePrincipal.setResizable(false);

        //manejadores de BO
        cajaBO = ManejadorBOs.crearCajaBO();
        categoriaBO = ManejadorBOs.crearCategoriaBO();
        compraBO = ManejadorBOs.crearCompraBO();
        devolucionBO = ManejadorBOs.crearDevolucionBO();
        productoBO = ManejadorBOs.crearProductoBO();
        proveedorBO = ManejadorBOs.crearProveedorBO();
        unidadMedidaBO = ManejadorBOs.crearUnidadMedidaBO();
        usuarioBO = ManejadorBOs.crearUsuarioBO();
        ventaBO = ManejadorBOs.crearVentaBO();

        //inicializar pantallas
        menuPrincipal = new MenuPrincipal(this);
        pantallaCaja = new PantallaCaja(this);
        pantallaDevoluciones = new PantallaDevoluciones(this);
        pantallaIniciarUsuario = new PantallaIniciarUsuario(this);
        pantallaProveedores = new PantallaProveedores(this);
        pantallaRegistrarCompra = new PantallaRegistrarCompra(this);
        pantallaRegistrarVenta = new PantallaRegistrarVenta(this);
        pantallaReportes = new PantallaReportes(this);
        pantallarRegistarProducto = new PantallarRegistarProducto(this);
        
    }
    
    public DTOSalidaCaja abrirCaja(DTOEntradaCaja dto) throws NegocioException {
        try {
            return cajaBO.abrirCaja(dto);
        } catch (NegocioException e) {
            throw new NegocioException(e.getLocalizedMessage());
        }
    }
    
    public DTOSalidaCaja cerrarCaja(String idCaja, double montoFinal) throws NegocioException {
        try {
            return cajaBO.cerrarCaja(idCaja, montoFinal);
        } catch (NegocioException e) {
            throw new NegocioException(e.getLocalizedMessage());
        }
    }
    
    public DTOSalidaCaja buscarCajaActiva() throws NegocioException {
        try {
            return cajaBO.buscarCajaActiva();
        } catch (NegocioException e) {
            throw new NegocioException(e.getLocalizedMessage());
        }
    }
    
    public List<DTOSalidaCaja> buscarTodasLasCajas() throws NegocioException {
        try {
            return cajaBO.buscarTodos();
        } catch (NegocioException e) {
            throw new NegocioException(e.getLocalizedMessage());
        }
    }
    
    public List<DTOSalidaCaja> reporteCajaPorFechas(Date inicio, Date fin) throws NegocioException {
        try {
            return cajaBO.reporteCajasPorRangoFechas(inicio, fin);
        } catch (NegocioException e) {
            throw new NegocioException(e.getLocalizedMessage());
        }
    }
    
    public DTOSalidaCategoria registrarCategoria(DTOEntradaCategoria dto) throws NegocioException {
        try {
            return categoriaBO.registrarCategoria(dto);
        } catch (NegocioException e) {
            throw new NegocioException(e.getLocalizedMessage());
        }
    }
    
    public DTOSalidaCategoria actualizarCategoria(DTOSalidaCategoria dto) throws NegocioException {
        try {
            return categoriaBO.actualizarCategoria(dto);
        } catch (NegocioException e) {
            throw new NegocioException(e.getLocalizedMessage());
        }
    }
    
    public List<DTOSalidaCategoria> consultarTodasCategorias() throws NegocioException {
        try {
            return categoriaBO.consultarTodas();
        } catch (NegocioException e) {
            throw new NegocioException(e.getLocalizedMessage());
        }
    }
    
    public DTOSalidaCompra registrarCompra(DTOEntradaCompra dto) throws NegocioException {
        try {
            return compraBO.registrarCompra(dto);
        } catch (NegocioException e) {
            throw new NegocioException(e.getLocalizedMessage());
        }
    }
    
    public List<DTOSalidaCompra> buscarTodasCompras() throws NegocioException {
        try {
            return compraBO.buscarTodas();
        } catch (NegocioException e) {
            throw new NegocioException(e.getLocalizedMessage());
        }
    }
    
    public DTOSalidaCompra buscarCompraPorId(String idCompra) throws NegocioException {
        try {
            return compraBO.buscarPorId(idCompra);
        } catch (NegocioException e) {
            throw new NegocioException(e.getLocalizedMessage());
        }
    }
    
    public List<DTOSalidaCompra> reporteComprasPorFechasYProveedor(Date inicio, Date fin, String idProveedor) throws NegocioException {
        try {
            return compraBO.reporteComprasPorRangoYProveedor(inicio, fin, idProveedor);
        } catch (NegocioException e) {
            throw new NegocioException(e.getLocalizedMessage());
        }
    }
    
    public DTOSalidaDevolucion registrarDevolucion(DTOEntradaDevolucion dto) throws NegocioException {
        try {
            return devolucionBO.registrarDevolucion(dto);
        } catch (NegocioException e) {
            throw new NegocioException(e.getLocalizedMessage());
        }
    }
    
    public List<DTOSalidaDevolucion> buscarTodasDevoluciones() throws NegocioException {
        try {
            return devolucionBO.buscarTodas();
        } catch (NegocioException e) {
            throw new NegocioException(e.getLocalizedMessage());
        }
    }
    
    public DTOSalidaDevolucion buscarDevolucionPorId(String id) throws NegocioException {
        try {
            return devolucionBO.buscarPorId(id);
        } catch (NegocioException e) {
            throw new NegocioException(e.getLocalizedMessage());
        }
    }
    
    public List<DTOSalidaDevolucion> reporteDevolucionesPorFechas(Date inicio, Date fin) throws NegocioException {
        try {
            return devolucionBO.reporteDevolucionesPorRangoFechas(inicio, fin);
        } catch (NegocioException e) {
            throw new NegocioException(e.getLocalizedMessage());
        }
    }
    
    public List<DTOSalidaDevolucion> reporteDevolucionesPorUsuario(String idUsuario) throws NegocioException {
        try {
            return devolucionBO.reporteDevolucionesPorUsuario(idUsuario);
        } catch (NegocioException e) {
            throw new NegocioException(e.getLocalizedMessage());
        }
    }
    
    public DTOSalidaProducto registrarProducto(DTOEntradaProducto dto) throws NegocioException {
        try {
            return productoBO.registrarProducto(dto);
        } catch (NegocioException e) {
            throw new NegocioException(e.getLocalizedMessage());
        }
    }
    
    public DTOSalidaProducto actualizarProducto(String id, DTOEntradaProducto dto) throws NegocioException {
        try {
            return productoBO.actualizarProducto(id, dto);
        } catch (NegocioException e) {
            throw new NegocioException(e.getLocalizedMessage());
        }
    }
    
    public List<DTOSalidaProducto> consultarTodosProductos() throws NegocioException {
        try {
            return productoBO.consultarTodos();
        } catch (NegocioException e) {
            throw new NegocioException(e.getLocalizedMessage());
        }
    }
    
    public DTOSalidaProducto buscarProductoPorId(String id) throws NegocioException {
        try {
            return productoBO.buscarPorId(id);
        } catch (NegocioException e) {
            throw new NegocioException(e.getLocalizedMessage());
        }
    }
    
    public DTOSalidaProveedor registrarProveedor(DTOEntradaProveedor dto) throws NegocioException {
        try {
            return proveedorBO.registrarProveedor(dto);
        } catch (NegocioException e) {
            throw new NegocioException(e.getLocalizedMessage());
        }
    }
    
    public DTOSalidaProveedor actualizarProveedor(DTOSalidaProveedor dto) throws NegocioException {
        try {
            return proveedorBO.actualizarProveedor(dto);
        } catch (NegocioException e) {
            throw new NegocioException(e.getLocalizedMessage());
        }
    }
    
    public List<DTOSalidaProveedor> consultarTodosProveedores() throws NegocioException {
        try {
            return proveedorBO.consultarTodos();
        } catch (NegocioException e) {
            throw new NegocioException(e.getLocalizedMessage());
        }
    }
    
    public DTOSalidaUnidadMedida registrarUnidadMedida(DTOEntradaUnidadMedida dto) throws NegocioException {
        try {
            return unidadMedidaBO.registrarUnidadMedida(dto);
        } catch (NegocioException e) {
            throw new NegocioException(e.getLocalizedMessage());
        }
    }
    
    public DTOSalidaUnidadMedida actualizarUnidadMedida(DTOSalidaUnidadMedida dto) throws NegocioException {
        try {
            return unidadMedidaBO.actualizarUnidadMedida(dto);
        } catch (NegocioException e) {
            throw new NegocioException(e.getLocalizedMessage());
        }
    }
    
    public List<DTOSalidaUnidadMedida> consultarTodasUnidades() throws NegocioException {
        try {
            return unidadMedidaBO.consultarTodas();
        } catch (NegocioException e) {
            throw new NegocioException(e.getLocalizedMessage());
        }
    }
    
    public DTOSalidaUsuario registrarUsuario(DTOEntradaUsuario dto) throws NegocioException {
        try {
            return usuarioBO.registrarUsuario(dto);
        } catch (NegocioException e) {
            throw new NegocioException(e.getLocalizedMessage());
        }
    }
    
    public List<DTOSalidaUsuario> consultarTodosUsuarios() throws NegocioException {
        try {
            return usuarioBO.consultarTodos();
        } catch (NegocioException e) {
            throw new NegocioException(e.getLocalizedMessage());
        }
    }
    
    public DTOSalidaUsuario validarCredenciales(String usuario, String contrasena) throws NegocioException {
        try {
            return usuarioBO.validarCredenciales(usuario, contrasena);
        } catch (NegocioException e) {
            throw new NegocioException(e.getLocalizedMessage());
        }
    }
    
    public DTOSalidaVenta registrarVenta(DTOEntradaVenta dto) throws NegocioException {
        try {
            return ventaBO.registrarVenta(dto);
        } catch (NegocioException e) {
            throw new NegocioException(e.getLocalizedMessage());
        }
    }
    
    public List<DTOSalidaVenta> buscarTodasVentas() throws NegocioException {
        try {
            return ventaBO.buscarTodas();
        } catch (NegocioException e) {
            throw new NegocioException(e.getLocalizedMessage());
        }
    }
    
    public DTOSalidaVenta buscarVentaPorId(String idVenta) throws NegocioException {
        try {
            return ventaBO.buscarPorId(idVenta);
        } catch (NegocioException e) {
            throw new NegocioException(e.getLocalizedMessage());
        }
    }
    
    public List<DTOSalidaVenta> reporteVentasPorRangoFechasYUsuario(Date inicio, Date fin, String idUsuario) throws NegocioException {
        try {
            return ventaBO.buscarPorRangoFechasYUsuario(inicio, fin, idUsuario);
        } catch (NegocioException e) {
            throw new NegocioException(e.getLocalizedMessage());
        }
    }

    // Cambiar de pantalla dentro del frame principal
    private void cambiarPantalla(JPanel nuevaPantalla) {
        framePrincipal.getContentPane().removeAll(); // Eliminar contenido anterior
        framePrincipal.getContentPane().add(nuevaPantalla);
        framePrincipal.revalidate();
        framePrincipal.repaint();
        framePrincipal.setVisible(true);
    }
    
    public void mostrarMenu() {
        cambiarPantalla(menuPrincipal);
    }
    
    public void mostrarPantallaCaja() {
        cambiarPantalla(pantallaCaja);
    }
    
    public void mostrarPantallaDevoluciones() {
        cambiarPantalla(pantallaDevoluciones);
    }
    
    public void mostrarPantallaIniciarUsuario() {
        cambiarPantalla(pantallaIniciarUsuario);
    }
    
    public void mostrarPantallaProveedores() {
        cambiarPantalla(pantallaProveedores);
    }
    
    public void mostrarPantallaRegistrarCompra() {
        cambiarPantalla(pantallaRegistrarCompra);
    }
    
    public void mostrarPantallaRegistrarVenta() {
        cambiarPantalla(pantallaRegistrarVenta);
    }
    
    public void mostrarPantallaReportes() {
        cambiarPantalla(pantallaReportes);
    }
    
    public void mostrarPantallaRegistrarProducto() {
        cambiarPantalla(pantallarRegistarProducto);
    }
    
    public void reconstruirPantallaCompra() {
        pantallaRegistrarCompra = new PantallaRegistrarCompra(this);
    }
    
    public void reconstruirPantallaVenta() {
        pantallaRegistrarVenta = new PantallaRegistrarVenta(this);
    }
    
    public void reconstruirPantallaProducto() {
        pantallarRegistarProducto = new PantallarRegistarProducto(this);
    }
    
    public void reconstruirPantallaUsuario() {
        pantallaIniciarUsuario = new PantallaIniciarUsuario(this);
    }
    
}
