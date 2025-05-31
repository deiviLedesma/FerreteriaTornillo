/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOEntrada.DTOEntradaProveedor;
import DTOSalida.DTOSalidaProveedor;
import Excepcion.NegocioException;
import java.util.List;

/**
 *
 * @author SDavidLedesma
 */
public interface IProveedorBO {

    DTOSalidaProveedor registrarProveedor(DTOEntradaProveedor dto) throws NegocioException;

    List<DTOSalidaProveedor> consultarTodos() throws NegocioException;

    DTOSalidaProveedor buscarPorId(String idProveedor) throws NegocioException;

    DTOSalidaProveedor actualizarProveedor(DTOSalidaProveedor dto) throws NegocioException;

    void eliminarProveedor(String idProveedor) throws NegocioException;

}
