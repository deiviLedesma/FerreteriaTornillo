/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import DTOEntrada.DTOEntradaCategoria;
import DTOSalida.DTOSalidaCategoria;
import POJOs.Categoria;
import org.bson.types.ObjectId;

/**
 * Mapper para convertir entre DTOEntradaCategoria, DTOSalidaCategoria y
 * Categoria (POJO).
 *
 * @author SDavidLedesma
 */
public class CategoriaMapper {

    /**
     * Convierte de DTOEntradaCategoria a Categoria (POJO).
     * @param dto
     * @return 
     */
    public static Categoria toEntityFromEntrada(DTOEntradaCategoria dto) {
        Categoria categoria = new Categoria();
        categoria.setNombre(dto.getNombre());
        return categoria;
    }

    /**
     * Convierte de Categoria (POJO) a DTOSalidaCategoria.
     * @param categoria
     * @return 
     */
    public static DTOSalidaCategoria toDTOSalida(Categoria categoria) {
        DTOSalidaCategoria dto = new DTOSalidaCategoria();
        dto.setIdCategoria(categoria.getId() != null ? categoria.getId().toHexString() : null);
        dto.setNombre(categoria.getNombre());
        return dto;
    }

    /**
     * Convierte de DTOSalidaCategoria a Categoria (POJO).
     * @param dto
     * @return 
     */
    public static Categoria toEntityFromSalida(DTOSalidaCategoria dto) {
        Categoria categoria = new Categoria();
        if (dto.getIdCategoria() != null && !dto.getIdCategoria().isEmpty()) {
            categoria.setId(new ObjectId(dto.getIdCategoria()));
        }
        categoria.setNombre(dto.getNombre());
        return categoria;
    }
}


