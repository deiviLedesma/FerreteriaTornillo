/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import DAO.CategoriaDAO;
import DTOEntrada.DTOEntradaCategoria;
import DTOSalida.DTOSalidaCategoria;
import Excepcion.NegocioException;
import Mappers.CategoriaMapper;
import POJOs.Categoria;
import Excepcion.PersistenciaException;
import java.util.ArrayList;
import java.util.List;

/**
 * Business Object para la gestión de categorías. Propaga errores como
 * NegocioException.
 *
 * @author SDavidLedesma
 */
public class CategoriaBO {

    private final CategoriaDAO categoriaDAO = new CategoriaDAO();

    public void registrarCategoria(DTOEntradaCategoria dto) throws NegocioException {
        try {
            Categoria categoria = CategoriaMapper.toEntityFromEntrada(dto);
            categoriaDAO.insertar(categoria);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al registrar categoría: " + ex.getMessage(), ex);
        }
    }

    public List<DTOSalidaCategoria> consultarTodas() throws NegocioException {
        try {
            List<DTOSalidaCategoria> lista = new ArrayList<>();
            for (Categoria c : categoriaDAO.buscarTodos()) {
                lista.add(CategoriaMapper.toDTOSalida(c));
            }
            return lista;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al consultar categorías: " + ex.getMessage(), ex);
        }
    }

    public DTOSalidaCategoria buscarPorId(String idCategoria) throws NegocioException {
        try {
            Categoria c = categoriaDAO.buscarPorId(idCategoria);
            if (c == null) {
                return null;
            }
            return CategoriaMapper.toDTOSalida(c);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al buscar categoría: " + ex.getMessage(), ex);
        }
    }

    public void actualizarCategoria(DTOSalidaCategoria dto) throws NegocioException {
        try {
            Categoria categoria = CategoriaMapper.toEntityFromSalida(dto);
            categoriaDAO.actualizar(categoria);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al actualizar categoría: " + ex.getMessage(), ex);
        }
    }

    public void eliminarCategoria(String idCategoria) throws NegocioException {
        try {
            categoriaDAO.eliminar(idCategoria);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al eliminar categoría: " + ex.getMessage(), ex);
        }
    }
}
