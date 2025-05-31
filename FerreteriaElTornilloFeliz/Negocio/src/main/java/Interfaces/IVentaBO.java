/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOEntrada.DTOEntradaVenta;
import DTOSalida.DTOSalidaVenta;
import Excepcion.NegocioException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author SDavidLedesma
 */
public interface IVentaBO {

    DTOSalidaVenta registrarVenta(DTOEntradaVenta dto) throws NegocioException;

    List<DTOSalidaVenta> buscarTodas() throws NegocioException;

    DTOSalidaVenta buscarPorId(String idVenta) throws NegocioException;

    List<DTOSalidaVenta> buscarPorRangoFechasYUsuario(Date inicio, Date fin, String idUsuario) throws NegocioException;

}
