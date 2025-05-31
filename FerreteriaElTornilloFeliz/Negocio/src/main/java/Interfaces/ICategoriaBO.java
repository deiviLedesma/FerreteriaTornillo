/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOEntrada.DTOEntradaCategoria;
import DTOSalida.DTOSalidaCategoria;
import Excepcion.NegocioException;
import java.util.List;

/**
 *
 * @author SDavidLedesma
 */
public interface ICategoriaBO {

    DTOSalidaCategoria registrarCategoria(DTOEntradaCategoria dto) throws NegocioException;

    List<DTOSalidaCategoria> consultarTodas() throws NegocioException;

    DTOSalidaCategoria buscarPorId(String idCategoria) throws NegocioException;

    DTOSalidaCategoria actualizarCategoria(DTOSalidaCategoria dto) throws NegocioException;

    void eliminarCategoria (String idCategoria) throws NegocioException;

}
