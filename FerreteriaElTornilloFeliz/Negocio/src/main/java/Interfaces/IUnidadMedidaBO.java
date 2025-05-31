/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOEntrada.DTOEntradaUnidadMedida;
import DTOSalida.DTOSalidaUnidadMedida;
import Excepcion.NegocioException;
import java.util.List;

/**
 *
 * @author SDavidLedesma
 */
public interface IUnidadMedidaBO {

    DTOSalidaUnidadMedida registrarUnidadMedida(DTOEntradaUnidadMedida dto) throws NegocioException;

    List<DTOSalidaUnidadMedida> consultarTodas() throws NegocioException;

    DTOSalidaUnidadMedida buscarPorId(String idUnidadMedida) throws NegocioException;

    DTOSalidaUnidadMedida actualizarUnidadMedida(DTOSalidaUnidadMedida dto) throws NegocioException;

    void eliminarUnidadMedida(String idUnidadMedida) throws NegocioException;

}
