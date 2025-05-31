/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOEntrada.DTOEntradaCompra;
import DTOSalida.DTOSalidaCompra;
import Excepcion.NegocioException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author SDavidLedesma
 */
public interface ICompraBO {

    DTOSalidaCompra registrarCompra(DTOEntradaCompra dto) throws NegocioException;

    List<DTOSalidaCompra> buscarTodas() throws NegocioException;

    DTOSalidaCompra buscarPorId(String idCompra) throws NegocioException;

    List<DTOSalidaCompra> reporteComprasPorRangoYProveedor(Date inicio, Date fin, String idProveedor) throws NegocioException;

}
