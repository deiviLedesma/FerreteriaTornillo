/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManejadorDeObjetos;

import BOs.CajaBO;
import BOs.CategoriaBO;
import BOs.CompraBO;
import BOs.DevolucionBO;
import BOs.ProductoBO;
import BOs.ProveedorBO;
import BOs.UnidadMedidaBO;
import BOs.UsuarioBO;
import BOs.VentaBO;
import DAO.CajaDAO;
import DAO.CategoriaDAO;
import DAO.CompraDAO;
import DAO.DevolucionDAO;
import DAO.ProductoDAO;
import DAO.ProveedorDAO;
import DAO.UnidadMedidaDAO;
import DAO.UsuarioDAO;
import DAO.VentaDAO;
import Interfaces.ICajaBO;
import Interfaces.ICajaDAO;
import Interfaces.ICategoriaBO;
import Interfaces.ICategoriaDAO;
import Interfaces.ICompraBO;
import Interfaces.ICompraDAO;
import Interfaces.IDevolucionBO;
import Interfaces.IDevolucionDAO;
import Interfaces.IProductoBO;
import Interfaces.IProductoDAO;
import Interfaces.IProveedorBO;
import Interfaces.IProveedorDAO;
import Interfaces.IUnidadMedidaBO;
import Interfaces.IUnidadMedidaDAO;
import Interfaces.IUsuarioBO;
import Interfaces.IUsuarioDAO;
import Interfaces.IVentaBO;
import Interfaces.IVentaDAO;

/**
 *
 * @author SDavidLedesma
 */
public class ManejadorBOs {

    public static ICajaBO crearCajaBO() {
        ICajaDAO dao = new CajaDAO();
        return new CajaBO(dao);
    }

    public static ICategoriaBO crearCategoriaBO() {
        ICategoriaDAO dao = new CategoriaDAO();
        return new CategoriaBO(dao);
    }

    public static ICompraBO crearCompraBO() {
        ICompraDAO dao = new CompraDAO();
        IProductoDAO productoDAO = new ProductoDAO();
        return new CompraBO(dao, productoDAO);
    }

    public static IDevolucionBO crearDevolucionBO() {
        IDevolucionDAO dao = new DevolucionDAO();
        IProductoDAO productoDAO = new ProductoDAO();
        return new DevolucionBO(dao, productoDAO);
    }

    public static IProductoBO crearProductoBO() {
        IProductoDAO dao = new ProductoDAO();
        return new ProductoBO(dao);
    }

    public static IProveedorBO crearProveedorBO() {
        IProveedorDAO dao = new ProveedorDAO();
        return (IProveedorBO) new ProveedorBO(dao); // no entiendo porque se tiene que castear sino, no funciona
    }

    public static IUnidadMedidaBO crearUnidadMedidaBO() {
        IUnidadMedidaDAO dao = new UnidadMedidaDAO();
        return new UnidadMedidaBO(dao);
    }

    public static IUsuarioBO crearUsuarioBO() {
        IUsuarioDAO dao = new UsuarioDAO();
        return new UsuarioBO(dao);
    }

    public static IVentaBO crearVentaBO() {
        IVentaDAO dao = new VentaDAO();
        ICajaDAO daoC = new CajaDAO();
        IProductoDAO daoP = new ProductoDAO();
        return new VentaBO(dao, daoC, daoP);
    }
}
