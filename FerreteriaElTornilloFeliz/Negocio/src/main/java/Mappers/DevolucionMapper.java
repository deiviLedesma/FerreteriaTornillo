/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import DTOEntrada.DTOEntradaDevolucion;
import DTOSalida.DTOSalidaDevolucion;
import POJOs.Devolucion;
import org.bson.types.ObjectId;

/**
 * Mapper para convertir entre DTOEntradaDevolucion, DTOSalidaDevolucion y
 * Devolucion (POJO). Convierte correctamente los ObjectId y los campos
 * necesarios.
 *
 * @author SDavidLedesma
 */
public class DevolucionMapper {

    /**
     * Convierte de DTOEntradaDevolucion a Devolucion (POJO).
     * @param dto
     * @return 
     */
    public static Devolucion toEntityFromEntrada(DTOEntradaDevolucion dto) {
        Devolucion devolucion = new Devolucion();
        devolucion.setFecha(dto.getFecha());
        devolucion.setMotivo(dto.getMotivo());
        devolucion.setTipo(dto.getTipo());
        devolucion.setCantidad(dto.getCantidad());
        devolucion.setDecision(dto.getDecision());

        // Conversión de IDs a ObjectId si aplica
        if (dto.getIdUsuario() != null && !dto.getIdUsuario().isEmpty()) {
            devolucion.setIdUsuario(new ObjectId(dto.getIdUsuario()));
        }
        if (dto.getIdVenta() != null && !dto.getIdVenta().isEmpty()) {
            devolucion.setIdVenta(new ObjectId(dto.getIdVenta()));
        }
        if (dto.getIdProducto() != null && !dto.getIdProducto().isEmpty()) {
            devolucion.setIdProducto(new ObjectId(dto.getIdProducto()));
        }
        return devolucion;
    }

    /**
     * Convierte de Devolucion (POJO) a DTOSalidaDevolucion.
     * @param devolucion
     * @return 
     */
    public static DTOSalidaDevolucion toDTOSalida(Devolucion devolucion) {
        DTOSalidaDevolucion dto = new DTOSalidaDevolucion();
        dto.setIdDevolucion(devolucion.getId() != null ? devolucion.getId().toHexString() : null);
        dto.setFecha(devolucion.getFecha());
        dto.setMotivo(devolucion.getMotivo());
        dto.setTipo(devolucion.getTipo());
        dto.setCantidad(devolucion.getCantidad());
        dto.setDecision(devolucion.getDecision());

        dto.setIdUsuario(devolucion.getIdUsuario() != null ? devolucion.getIdUsuario().toHexString() : null);
        dto.setUsuario(devolucion.getUsuario());

        dto.setIdVenta(devolucion.getIdVenta() != null ? devolucion.getIdVenta().toHexString() : null);
        dto.setVenta(devolucion.getVenta());

        dto.setIdProducto(devolucion.getIdProducto() != null ? devolucion.getIdProducto().toHexString() : null);
        dto.setProducto(devolucion.getProducto());

        return dto;
    }

    /**
     * Convierte de DTOSalidaDevolucion a Devolucion (POJO).
     * @param dto
     * @return 
     */
    public static Devolucion toEntityFromSalida(DTOSalidaDevolucion dto) {
        Devolucion devolucion = new Devolucion();
        if (dto.getIdDevolucion() != null && !dto.getIdDevolucion().isEmpty()) {
            devolucion.setId(new ObjectId(dto.getIdDevolucion()));
        }
        devolucion.setFecha(dto.getFecha());
        devolucion.setMotivo(dto.getMotivo());
        devolucion.setTipo(dto.getTipo());
        devolucion.setCantidad(dto.getCantidad());
        devolucion.setDecision(dto.getDecision());

        if (dto.getIdUsuario() != null && !dto.getIdUsuario().isEmpty()) {
            devolucion.setIdUsuario(new ObjectId(dto.getIdUsuario()));
        }
        devolucion.setUsuario(dto.getUsuario());

        if (dto.getIdVenta() != null && !dto.getIdVenta().isEmpty()) {
            devolucion.setIdVenta(new ObjectId(dto.getIdVenta()));
        }
        devolucion.setVenta(dto.getVenta());

        if (dto.getIdProducto() != null && !dto.getIdProducto().isEmpty()) {
            devolucion.setIdProducto(new ObjectId(dto.getIdProducto()));
        }
        devolucion.setProducto(dto.getProducto());

        return devolucion;
    }
}
