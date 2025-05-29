/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import DTOEntrada.DTOEntradaDetalleVenta;
import DTOEntrada.DTOEntradaVenta;
import DTOSalida.DTOSalidaDetalleVenta;
import DTOSalida.DTOSalidaVenta;
import POJOs.Venta;
import POJOs.DetalleVenta;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.List;

/**
 * Mapper para convertir entre DTOEntradaVenta, DTOSalidaVenta y Venta (POJO).
 * Convierte correctamente los ObjectId y mapea las listas de detalles.
 *
 * @author SDavidLedesma
 */
public class VentaMapper {

    /**
     * Convierte de DTOEntradaVenta a Venta (POJO).
     * @param dto
     * @return 
     */
    public static Venta toEntityFromEntrada(DTOEntradaVenta dto) {
        Venta venta = new Venta();
        venta.setFechaHora(dto.getFechaHora());
        venta.setTotal(dto.getTotal());

        // Conversión de String a ObjectId:
        if (dto.getIdUsuario() != null && !dto.getIdUsuario().isEmpty()) {
            venta.setIdUsuario(new ObjectId(dto.getIdUsuario()));
        }
        if (dto.getIdCaja() != null && !dto.getIdCaja().isEmpty()) {
            venta.setIdCaja(new ObjectId(dto.getIdCaja()));
        }

        // Mapear detalles
        if (dto.getDetalles() != null) {
            List<DetalleVenta> detalles = new ArrayList<>();
            for (DTOEntradaDetalleVenta det : dto.getDetalles()) {
                detalles.add(DetalleVentaMapper.toEntityFromEntrada(det));
            }
            venta.setDetalles(detalles);
        }

        return venta;
    }

    /**
     * Convierte de Venta (POJO) a DTOSalidaVenta.
     * @param venta
     * @return 
     */
    public static DTOSalidaVenta toDTOSalida(Venta venta) {
        DTOSalidaVenta dto = new DTOSalidaVenta();
        dto.setIdVenta(venta.getId() != null ? venta.getId().toHexString() : null);
        dto.setFechaHora(venta.getFechaHora());
        dto.setTotal(venta.getTotal());

        dto.setIdUsuario(venta.getIdUsuario() != null ? venta.getIdUsuario().toHexString() : null);
        dto.setUsuario(venta.getUsuario()); // nombre usuario

        dto.setIdCaja(venta.getIdCaja() != null ? venta.getIdCaja().toHexString() : null);
        dto.setCaja(venta.getCaja()); // nombre caja

        // Mapear detalles
        if (venta.getDetalles() != null) {
            List<DTOSalidaDetalleVenta> detalles = new ArrayList<>();
            for (DetalleVenta det : venta.getDetalles()) {
                detalles.add(DetalleVentaMapper.toDTOSalida(det));
            }
            dto.setDetalles(detalles);
        }

        return dto;
    }

    /**
     * Convierte de DTOSalidaVenta a Venta (POJO).
     * @param dto
     * @return 
     */
    public static Venta toEntityFromSalida(DTOSalidaVenta dto) {
        Venta venta = new Venta();
        if (dto.getIdVenta() != null && !dto.getIdVenta().isEmpty()) {
            venta.setId(new ObjectId(dto.getIdVenta()));
        }
        venta.setFechaHora(dto.getFechaHora());
        venta.setTotal(dto.getTotal());

        if (dto.getIdUsuario() != null && !dto.getIdUsuario().isEmpty()) {
            venta.setIdUsuario(new ObjectId(dto.getIdUsuario()));
        }
        venta.setUsuario(dto.getUsuario());

        if (dto.getIdCaja() != null && !dto.getIdCaja().isEmpty()) {
            venta.setIdCaja(new ObjectId(dto.getIdCaja()));
        }
        venta.setCaja(dto.getCaja());

        // Mapear detalles
        if (dto.getDetalles() != null) {
            List<DetalleVenta> detalles = new ArrayList<>();
            for (DTOSalidaDetalleVenta det : dto.getDetalles()) {
                detalles.add(DetalleVentaMapper.toEntityFromSalida(det));
            }
            venta.setDetalles(detalles);
        }

        return venta;
    }
}
