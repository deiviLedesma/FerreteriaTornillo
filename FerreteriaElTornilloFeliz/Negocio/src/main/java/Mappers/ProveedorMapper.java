/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import DTOEntrada.DTOEntradaProveedor;
import DTOSalida.DTOSalidaProveedor;
import POJOs.Proveedor;
import org.bson.types.ObjectId;

/**
 * Mapper para convertir entre DTOEntradaProveedor, DTOSalidaProveedor y
 * Proveedor (POJO).
 *
 * @author SDavidLedesma
 */
public class ProveedorMapper {

    /**
     * Convierte de DTOEntradaProveedor a Proveedor (POJO).
     *
     * @param dto
     * @return
     */
    public static Proveedor toEntityFromEntrada(DTOEntradaProveedor dto) {
        Proveedor proveedor = new Proveedor();
        proveedor.setNombre(dto.getNombre());
        proveedor.setCorreo(dto.getCorreo());
        proveedor.setTelefono(dto.getTelefono());
        proveedor.setDireccion(dto.getDireccion());
        return proveedor;
    }

    /**
     * Convierte de Proveedor (POJO) a DTOSalidaProveedor.
     *
     * @param proveedor
     * @return
     */
    public static DTOSalidaProveedor toDTOSalida(Proveedor proveedor) {
        DTOSalidaProveedor dto = new DTOSalidaProveedor();
        dto.setIdProveedor(proveedor.getId() != null ? proveedor.getId().toHexString() : null);
        dto.setNombre(proveedor.getNombre());
        dto.setCorreo(proveedor.getCorreo());
        dto.setTelefono(proveedor.getTelefono());
        dto.setDireccion(proveedor.getDireccion());
        return dto;
    }

    /**
     * Convierte de DTOSalidaProveedor a Proveedor (POJO).
     *
     * @param dto
     * @return
     */
    public static Proveedor toEntityFromSalida(DTOSalidaProveedor dto) {
        Proveedor proveedor = new Proveedor();
        if (dto.getIdProveedor() != null && !dto.getIdProveedor().isEmpty()) {
            proveedor.setId(new ObjectId(dto.getIdProveedor()));
        }
        proveedor.setNombre(dto.getNombre());
        proveedor.setCorreo(dto.getCorreo());
        proveedor.setTelefono(dto.getTelefono());
        proveedor.setDireccion(dto.getDireccion());
        return proveedor;
    }
}
