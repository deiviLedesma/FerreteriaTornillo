/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOEntrada.DTOEntradaCaja;
import DTOSalida.DTOSalidaCaja;
import Excepcion.NegocioException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author SDavidLedesma
 */
public interface ICajaBO {
    
    DTOSalidaCaja abrirCaja (DTOEntradaCaja dto) throws NegocioException;
    
    DTOSalidaCaja cerrarCaja (String idCaja, double montoFinal) throws NegocioException;
    
    DTOSalidaCaja buscarPorId (String idCaja) throws NegocioException;
    
    List<DTOSalidaCaja> buscarTodos() throws NegocioException;
    
    List<DTOSalidaCaja> buscarPorRangoFechas(Date inicio, Date fin) throws NegocioException;
    
    DTOSalidaCaja buscarCajaActiva() throws NegocioException;
    
    List<DTOSalidaCaja> reporteCajasPorRangoFechas(Date inicio, Date fin) throws NegocioException;
    
}
