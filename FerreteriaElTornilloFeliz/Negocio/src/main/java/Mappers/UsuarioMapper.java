/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import DTOEntrada.DTOEntradaUsuario;
import DTOSalida.DTOSalidaUsuario;
import POJOs.Usuario;
import org.bson.types.ObjectId;

/**
 * Mapper para convertir entre DTOEntradaUsuario, DTOSalidaUsuario y Usuario
 * (POJO).
 *
 * @author SDavidLedesma
 */
public class UsuarioMapper {

    /**
     * Convierte de DTOEntradaUsuario a Usuario (POJO).
     */
    public static Usuario toEntityFromEntrada(DTOEntradaUsuario dto) {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(dto.getNombreUsuario());
        usuario.setNombreCompleto(dto.getNombreCompleto());
        usuario.setContrasena(dto.getContrasena());
        return usuario;
    }

    /**
     * Convierte de Usuario (POJO) a DTOSalidaUsuario.
     */
    public static DTOSalidaUsuario toDTOSalida(Usuario usuario) {
        DTOSalidaUsuario dto = new DTOSalidaUsuario();
        dto.setIdUsaurio(usuario.getId() != null ? usuario.getId().toHexString() : null);
        dto.setNombreUsuario(usuario.getNombreUsuario());
        dto.setNombreCompleto(usuario.getNombreCompleto());
        // No incluye contraseña en DTOSalida
        return dto;
    }

    /**
     * Convierte de DTOSalidaUsuario a Usuario (POJO).
     */
    public static Usuario toEntityFromSalida(DTOSalidaUsuario dto) {
        Usuario usuario = new Usuario();
        if (dto.getIdUsaurio()!= null && !dto.getIdUsaurio().isEmpty()) {
            usuario.setId(new ObjectId(dto.getIdUsaurio()));
        }
        usuario.setNombreUsuario(dto.getNombreUsuario());
        usuario.setNombreCompleto(dto.getNombreCompleto());
        // No incluye contraseña
        return usuario;
    }
}
