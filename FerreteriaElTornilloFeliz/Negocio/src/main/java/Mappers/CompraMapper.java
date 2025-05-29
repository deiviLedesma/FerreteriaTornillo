/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import DTOEntrada.DTOEntradaCompra;
import DTOEntrada.DTOEntradaDetalleCompra;
import DTOSalida.DTOSalidaCompra;
import DTOSalida.DTOSalidaDetalleCompra;
import POJOs.Compra;
import POJOs.DetalleCompra;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.List;

/**
 * Mapper para convertir entre DTOEntradaCompra, DTOSalidaCompra y Compra
 * (POJO). Convierte correctamente los ObjectId y los campos necesarios.
 *
 * @author SDavidLedesma
 */
public class CompraMapper {

    /**
     * Convierte de DTOEntradaCompra a Compra (POJO).
     */
    public static Compra toEntityFromEntrada(DTOEntradaCompra dto) {
        Compra compra = new Compra();
        compra.setFechaHora(dto.getFechaHora());
        compra.setTotal(dto.getTotal());

        if (dto.getIdProveedor() != null && !dto.getIdProveedor().isEmpty()) {
            compra.setIdProveedor(new ObjectId(dto.getIdProveedor()));
        }
        if (dto.getIdUsuario() != null && !dto.getIdUsuario().isEmpty()) {
            compra.setIdUsuario(new ObjectId(dto.getIdUsuario()));
        }

        // Mapear detalles
        if (dto.getDetalles() != null) {
            List<DetalleCompra> detalles = new ArrayList<>();
            for (DTOEntradaDetalleCompra det : dto.getDetalles()) {
                detalles.add(DetalleCompraMapper.toEntityFromEntrada(det));
            }
            compra.setDetalles(detalles);
        }

        return compra;
    }

    /**
     * Convierte de Compra (POJO) a DTOSalidaCompra.
     */
    public static DTOSalidaCompra toDTOSalida(Compra compra) {
        DTOSalidaCompra dto = new DTOSalidaCompra();
        dto.setIdCompra(compra.getId() != null ? compra.getId().toHexString() : null);
        dto.setFechaHora(compra.getFechaHora());
        dto.setTotal(compra.getTotal());

        dto.setIdProveedor(compra.getIdProveedor() != null ? compra.getIdProveedor().toHexString() : null);
        dto.setProveedor(compra.getProveedor());

        dto.setIdUsuario(compra.getIdUsuario() != null ? compra.getIdUsuario().toHexString() : null);
        dto.setUsuario(compra.getUsuario());

        // Mapear detalles
        if (compra.getDetalles() != null) {
            List<DTOSalidaDetalleCompra> detalles = new ArrayList<>();
            for (DetalleCompra det : compra.getDetalles()) {
                detalles.add(DetalleCompraMapper.toDTOSalida(det));
            }
            dto.setDetalles(detalles);
        }

        return dto;
    }

    /**
     * Convierte de DTOSalidaCompra a Compra (POJO).
     */
    public static Compra toEntityFromSalida(DTOSalidaCompra dto) {
        Compra compra = new Compra();
        if (dto.getIdCompra() != null && !dto.getIdCompra().isEmpty()) {
            compra.setId(new ObjectId(dto.getIdCompra()));
        }
        compra.setFechaHora(dto.getFechaHora());
        compra.setTotal(dto.getTotal());

        if (dto.getIdProveedor() != null && !dto.getIdProveedor().isEmpty()) {
            compra.setIdProveedor(new ObjectId(dto.getIdProveedor()));
        }
        compra.setProveedor(dto.getProveedor());

        if (dto.getIdUsuario() != null && !dto.getIdUsuario().isEmpty()) {
            compra.setIdUsuario(new ObjectId(dto.getIdUsuario()));
        }
        compra.setUsuario(dto.getUsuario());

        // Mapear detalles
        if (dto.getDetalles() != null) {
            List<DetalleCompra> detalles = new ArrayList<>();
            for (DTOSalidaDetalleCompra det : dto.getDetalles()) {
                detalles.add(DetalleCompraMapper.toEntityFromSalida(det));
            }
            compra.setDetalles(detalles);
        }

        return compra;
    }
}
