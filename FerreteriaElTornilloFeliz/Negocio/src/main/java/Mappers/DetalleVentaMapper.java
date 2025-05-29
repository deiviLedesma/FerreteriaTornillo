/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import DTOEntrada.DTOEntradaDetalleVenta;
import DTOSalida.DTOSalidaDetalleVenta;
import POJOs.DetalleVenta;
import org.bson.types.ObjectId;

/**
 * Mapper para los detalles de venta.
 * @author SDavidLedesma
 */
public class DetalleVentaMapper {

    public static DetalleVenta toEntityFromEntrada(DTOEntradaDetalleVenta dto) {
        DetalleVenta detalle = new DetalleVenta();
        if (dto.getIdProducto() != null && !dto.getIdProducto().isEmpty()) {
            detalle.setIdProducto(new ObjectId(dto.getIdProducto()));
        }
        detalle.setCantidad(dto.getCantidad());
        detalle.setPrecioUnitario(dto.getPrecioUnitario());
        return detalle;
    }

    public static DTOSalidaDetalleVenta toDTOSalida(DetalleVenta detalle) {
        DTOSalidaDetalleVenta dto = new DTOSalidaDetalleVenta();
        dto.setIdProducto(detalle.getIdProducto() != null ? detalle.getIdProducto().toHexString() : null);
        dto.setCantidad(detalle.getCantidad());
        dto.setPrecioUnitario(detalle.getPrecioUnitario());
        dto.setSubtotal(detalle.getSubtotal());
        dto.setNombreProducto(detalle.getNombreProducto());
        return dto;
    }

    public static DetalleVenta toEntityFromSalida(DTOSalidaDetalleVenta dto) {
        DetalleVenta detalle = new DetalleVenta();
        if (dto.getIdProducto() != null && !dto.getIdProducto().isEmpty()) {
            detalle.setIdProducto(new ObjectId(dto.getIdProducto()));
        }
        detalle.setCantidad(dto.getCantidad());
        detalle.setPrecioUnitario(dto.getPrecioUnitario());
        dto.setPrecioUnitario(detalle.getPrecioUnitario());
        dto.setSubtotal(detalle.getSubtotal());
        dto.setNombreProducto(detalle.getNombreProducto());
        return detalle;
    }
}
