/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import DTOEntrada.DTOEntradaUnidadMedida;
import DTOSalida.DTOSalidaUnidadMedida;
import POJOs.UnidadMedida;
import org.bson.types.ObjectId;

/**
 * Mapper para convertir entre DTOEntradaUnidadMedida, DTOSalidaUnidadMedida y
 * UnidadMedida (POJO).
 *
 * @author SDavidLedesma
 */
public class UnidadMedidaMapper {

    /**
     * Convierte de DTOEntradaUnidadMedida a UnidadMedida (POJO).
     * @param dto
     * @return 
     */
    public static UnidadMedida toEntityFromEntrada(DTOEntradaUnidadMedida dto) {
        UnidadMedida unidad = new UnidadMedida();
        unidad.setNombre(dto.getNombre());
        return unidad;
    }

    /**
     * Convierte de UnidadMedida (POJO) a DTOSalidaUnidadMedida.
     * @param unidad
     * @return 
     */
    public static DTOSalidaUnidadMedida toDTOSalida(UnidadMedida unidad) {
        DTOSalidaUnidadMedida dto = new DTOSalidaUnidadMedida();
        dto.setIdUnidadMedida(unidad.getId() != null ? unidad.getId().toHexString() : null);
        dto.setNombre(unidad.getNombre());
        return dto;
    }

    /**
     * Convierte de DTOSalidaUnidadMedida a UnidadMedida (POJO).
     * @param dto
     * @return 
     */
    public static UnidadMedida toEntityFromSalida(DTOSalidaUnidadMedida dto) {
        UnidadMedida unidad = new UnidadMedida();
        if (dto.getIdUnidadMedida() != null && !dto.getIdUnidadMedida().isEmpty()) {
            unidad.setId(new ObjectId(dto.getIdUnidadMedida()));
        }
        unidad.setNombre(dto.getNombre());
        return unidad;
    }
}
