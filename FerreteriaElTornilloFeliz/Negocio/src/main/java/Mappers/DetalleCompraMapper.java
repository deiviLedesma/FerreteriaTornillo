/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import DTOEntrada.DTOEntradaDetalleCompra;
import DTOSalida.DTOSalidaDetalleCompra;
import POJOs.DetalleCompra;
import org.bson.types.ObjectId;

/**
 * Mapper para convertir entre DTOEntradaDetalleCompra, DTOSalidaDetalleCompra y
 * DetalleCompra (POJO). Convierte correctamente los ObjectId y los campos
 * necesarios.
 *
 * @author SDavidLedesma
 */
public class DetalleCompraMapper {

    /**
     * Convierte de DTOEntradaDetalleCompra a DetalleCompra (POJO).
     * @param dto
     * @return 
     */
    public static DetalleCompra toEntityFromEntrada(DTOEntradaDetalleCompra dto) {
        DetalleCompra detalle = new DetalleCompra();
        if (dto.getIdProducto() != null && !dto.getIdProducto().isEmpty()) {
            detalle.setIdProducto(new ObjectId(dto.getIdProducto()));
        }
        detalle.setCantidad(dto.getCantidad());
        detalle.setPrecioUnitario(dto.getPrecioUnitario());
        // El subtotal puede calcularse después
        return detalle;
    }

    /**
     * Convierte de DetalleCompra (POJO) a DTOSalidaDetalleCompra.
     * @param detalle
     * @return 
     */
    public static DTOSalidaDetalleCompra toDTOSalida(DetalleCompra detalle) {
        DTOSalidaDetalleCompra dto = new DTOSalidaDetalleCompra();
        dto.setIdProducto(detalle.getIdProducto() != null ? detalle.getIdProducto().toHexString() : null);
        dto.setNombreProducto(detalle.getNombreProducto());
        dto.setCantidad(detalle.getCantidad());
        dto.setPrecioUnitario(detalle.getPrecioUnitario());
        dto.setSubtotal(detalle.getSubtotal());
        return dto;
    }

    /**
     * Convierte de DTOSalidaDetalleCompra a DetalleCompra (POJO).
     * @param dto
     * @return 
     */
    public static DetalleCompra toEntityFromSalida(DTOSalidaDetalleCompra dto) {
        DetalleCompra detalle = new DetalleCompra();
        if (dto.getIdProducto() != null && !dto.getIdProducto().isEmpty()) {
            detalle.setIdProducto(new ObjectId(dto.getIdProducto()));
        }
        detalle.setNombreProducto(dto.getNombreProducto());
        detalle.setCantidad(dto.getCantidad());
        detalle.setPrecioUnitario(dto.getPrecioUnitario());
        detalle.setSubtotal(dto.getSubtotal());
        return detalle;
    }
}
