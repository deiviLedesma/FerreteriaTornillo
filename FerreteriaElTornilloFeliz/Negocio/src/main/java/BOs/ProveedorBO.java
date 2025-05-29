/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import DAO.ProveedorDAO;
import DTOEntrada.DTOEntradaProveedor;
import DTOSalida.DTOSalidaProveedor;
import Excepcion.NegocioException;
import Mappers.ProveedorMapper;
import POJOs.Proveedor;
import Excepcion.PersistenciaException;
import java.util.ArrayList;
import java.util.List;

/**
 * Business Object para la gestión de proveedores. Propaga errores como
 * NegocioException.
 *
 * @author SDavidLedesma
 */
public class ProveedorBO {

    private final ProveedorDAO proveedorDAO = new ProveedorDAO();

    public void registrarProveedor(DTOEntradaProveedor dto) throws NegocioException {
        try {
            Proveedor proveedor = ProveedorMapper.toEntityFromEntrada(dto);
            proveedorDAO.insertar(proveedor);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al registrar proveedor: " + ex.getMessage(), ex);
        }
    }

    public List<DTOSalidaProveedor> consultarTodos() throws NegocioException {
        try {
            List<DTOSalidaProveedor> lista = new ArrayList<>();
            for (Proveedor p : proveedorDAO.buscarTodos()) {
                lista.add(ProveedorMapper.toDTOSalida(p));
            }
            return lista;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al consultar proveedores: " + ex.getMessage(), ex);
        }
    }

    public DTOSalidaProveedor buscarPorId(String idProveedor) throws NegocioException {
        try {
            Proveedor p = proveedorDAO.buscarPorId(idProveedor);
            if (p == null) {
                return null;
            }
            return ProveedorMapper.toDTOSalida(p);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al buscar proveedor: " + ex.getMessage(), ex);
        }
    }

    public void actualizarProveedor(DTOSalidaProveedor dto) throws NegocioException {
        try {
            Proveedor proveedor = ProveedorMapper.toEntityFromSalida(dto);
            proveedorDAO.actualizar(proveedor);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al actualizar proveedor: " + ex.getMessage(), ex);
        }
    }

    public void eliminarProveedor(String idProveedor) throws NegocioException {
        try {
            proveedorDAO.eliminar(idProveedor);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al eliminar proveedor: " + ex.getMessage(), ex);
        }
    }
}
