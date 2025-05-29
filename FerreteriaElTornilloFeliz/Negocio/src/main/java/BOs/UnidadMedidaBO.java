/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import DAO.UnidadMedidaDAO;
import DTOEntrada.DTOEntradaUnidadMedida;
import DTOSalida.DTOSalidaUnidadMedida;
import Excepcion.NegocioException;
import Mappers.UnidadMedidaMapper;
import POJOs.UnidadMedida;
import Excepcion.PersistenciaException;
import java.util.ArrayList;
import java.util.List;

/**
 * Business Object para la gestión de unidades de medida. Propaga errores como
 * NegocioException.
 *
 * @author SDavidLedesma
 */
public class UnidadMedidaBO {

    private final UnidadMedidaDAO unidadMedidaDAO = new UnidadMedidaDAO();

    public void registrarUnidadMedida(DTOEntradaUnidadMedida dto) throws NegocioException {
        try {
            UnidadMedida unidad = UnidadMedidaMapper.toEntityFromEntrada(dto);
            unidadMedidaDAO.insertar(unidad);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al registrar unidad de medida: " + ex.getMessage(), ex);
        }
    }

    public List<DTOSalidaUnidadMedida> consultarTodas() throws NegocioException {
        try {
            List<DTOSalidaUnidadMedida> lista = new ArrayList<>();
            for (UnidadMedida u : unidadMedidaDAO.buscarTodos()) {
                lista.add(UnidadMedidaMapper.toDTOSalida(u));
            }
            return lista;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al consultar unidades de medida: " + ex.getMessage(), ex);
        }
    }

    public DTOSalidaUnidadMedida buscarPorId(String idUnidadMedida) throws NegocioException {
        try {
            UnidadMedida u = unidadMedidaDAO.buscarPorId(idUnidadMedida);
            if (u == null) {
                return null;
            }
            return UnidadMedidaMapper.toDTOSalida(u);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al buscar unidad de medida: " + ex.getMessage(), ex);
        }
    }

    public void actualizarUnidadMedida(DTOSalidaUnidadMedida dto) throws NegocioException {
        try {
            UnidadMedida unidad = UnidadMedidaMapper.toEntityFromSalida(dto);
            unidadMedidaDAO.actualizar(unidad);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al actualizar unidad de medida: " + ex.getMessage(), ex);
        }
    }

    public void eliminarUnidadMedida(String idUnidadMedida) throws NegocioException {
        try {
            unidadMedidaDAO.eliminar(idUnidadMedida);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al eliminar unidad de medida: " + ex.getMessage(), ex);
        }
    }
}
