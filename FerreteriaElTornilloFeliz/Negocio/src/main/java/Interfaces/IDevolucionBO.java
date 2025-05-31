/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOEntrada.DTOEntradaDevolucion;
import DTOSalida.DTOSalidaDevolucion;
import Excepcion.NegocioException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author SDavidLedesma
 */
public interface IDevolucionBO {

    DTOSalidaDevolucion registrarDevolucion(DTOEntradaDevolucion dto) throws NegocioException;

    List<DTOSalidaDevolucion> buscarTodas() throws NegocioException;

    DTOSalidaDevolucion buscarPorId(String idDevolucion) throws NegocioException;

    List<DTOSalidaDevolucion> reporteDevolucionesPorRangoFechas(Date inicio, Date fin) throws NegocioException;

    List<DTOSalidaDevolucion> reporteDevolucionesPorUsuario(String usuario) throws NegocioException;

}
