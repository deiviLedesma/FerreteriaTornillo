/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOEntrada.DTOEntradaProducto;
import DTOSalida.DTOSalidaProducto;
import Excepcion.NegocioException;
import java.util.List;

/**
 *
 * @author SDavidLedesma
 */
public interface IProductoBO {

    DTOSalidaProducto registrarProducto(DTOEntradaProducto dto) throws NegocioException;

    List<DTOSalidaProducto> consultarTodos() throws NegocioException;

    DTOSalidaProducto buscarPorId(String idProducto) throws NegocioException;

    DTOSalidaProducto actualizarProducto(String idProducto, DTOEntradaProducto dto) throws NegocioException;

    void eliminarProducto(String idProducto) throws NegocioException;

}
