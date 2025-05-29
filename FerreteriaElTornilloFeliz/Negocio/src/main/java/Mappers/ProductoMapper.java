/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import DTOEntrada.DTOEntradaProducto;
import DTOSalida.DTOSalidaProducto;
import POJOs.Producto;
import org.bson.types.ObjectId;

/**
 * Mapper para convertir entre DTOEntradaProducto, DTOSalidaProducto y Producto
 * (POJO). Convierte correctamente los IDs entre String (DTO) y ObjectId (POJO).
 *
 * @author SDavidLedesma
 */
public class ProductoMapper {

    /**
     * Convierte de DTOEntradaProducto a Producto (POJO).
     * @param dto
     * @return 
     */
    public static Producto toEntityFromEntrada(DTOEntradaProducto dto) {
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecioCompra(dto.getPrecioCompra());
        producto.setPrecioVenta(dto.getPrecioVenta());
        producto.setExistencias(dto.getExistencias());
        producto.setImagen(dto.getImagen());
        // Conversión de String a ObjectId:
        if (dto.getIdCategoria() != null && !dto.getIdCategoria().isEmpty()) {
            producto.setIdCategoria(new ObjectId(dto.getIdCategoria()));
        }
        if (dto.getIdUnidadMedida() != null && !dto.getIdUnidadMedida().isEmpty()) {
            producto.setIdUnidadMedida(new ObjectId(dto.getIdUnidadMedida()));
        }
        return producto;
    }

    /**
     * Convierte de Producto (POJO) a DTOSalidaProducto.
     * @param producto
     * @return 
     */
    public static DTOSalidaProducto toDTOSalida(Producto producto) {
        DTOSalidaProducto dto = new DTOSalidaProducto();
        dto.setIdProducto(producto.getId() != null ? producto.getId().toHexString() : null);
        dto.setNombre(producto.getNombre());
        dto.setDescripcion(producto.getDescripcion());
        dto.setPrecioCompra(producto.getPrecioCompra());
        dto.setPrecioVenta(producto.getPrecioVenta());
        dto.setExistencias(producto.getExistencias());
        dto.setImagen(producto.getImagen());
        // Conversión de ObjectId a String:
        dto.setIdCategoria(producto.getIdCategoria() != null ? producto.getIdCategoria().toHexString() : null);
        dto.setIdUnidadMedida(producto.getIdUnidadMedida() != null ? producto.getIdUnidadMedida().toHexString() : null);
        return dto;
    }

    /**
     * Convierte de DTOSalidaProducto a Producto (POJO).
     * @param dto
     * @return 
     */
    public static Producto toEntityFromSalida(DTOSalidaProducto dto) {
        Producto producto = new Producto();
        if (dto.getIdProducto() != null && !dto.getIdProducto().isEmpty()) {
            producto.setId(new ObjectId(dto.getIdProducto()));
        }
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecioCompra(dto.getPrecioCompra());
        producto.setPrecioVenta(dto.getPrecioVenta());
        producto.setExistencias(dto.getExistencias());
        producto.setImagen(dto.getImagen());
        if (dto.getIdCategoria() != null && !dto.getIdCategoria().isEmpty()) {
            producto.setIdCategoria(new ObjectId(dto.getIdCategoria()));
        }
        if (dto.getIdUnidadMedida() != null && !dto.getIdUnidadMedida().isEmpty()) {
            producto.setIdUnidadMedida(new ObjectId(dto.getIdUnidadMedida()));
        }
        return producto;
    }
}
