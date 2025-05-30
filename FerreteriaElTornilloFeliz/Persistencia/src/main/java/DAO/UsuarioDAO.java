/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Excepcion.PersistenciaException;
import Interfaces.IUsuarioDAO;
import POJOs.Usuario;
import Utilidades.EncriptadorUtil;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * Implementación de IUsuarioDAO para la gestión de usuarios en MongoDB.
 * Proporciona operaciones CRUD y búsquedas especializadas para usuarios del
 * sistema.
 *
 * @author SDavidLedesma
 */
public class UsuarioDAO implements IUsuarioDAO {

    private final MongoCollection<Usuario> coleccion;

    /**
     * Constructor. Obtiene la colección de usuarios desde la conexión MongoDB.
     */
    public UsuarioDAO() {
        this.coleccion = Conexion.getDatabase().getCollection("Usuario", Usuario.class);
    }

    @Override
    public Usuario insertar(Usuario usuario) throws PersistenciaException {
        try {
            InsertOneResult resultado = coleccion.insertOne(usuario);
            if (resultado.getInsertedId() != null) {
                usuario.setId(resultado.getInsertedId().asObjectId().getValue());
                return usuario;
            } else {
                throw new PersistenciaException("No se pudo insertar el usuario.");
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al insertar usuario: " + e.getMessage(), e);
        }
    }

    @Override
    public Usuario actualizar(Usuario usuario) throws PersistenciaException {
        try {
            Bson filtro = Filters.eq("_id", usuario.getId());
            UpdateResult resultado = coleccion.replaceOne(filtro, usuario);
            if (resultado.getModifiedCount() == 0) {
                throw new PersistenciaException("No se encontró el usuario a actualizar.");
            }
            return usuario;
        } catch (Exception e) {
            throw new PersistenciaException("Error al actualizar usuario: " + e.getMessage(), e);
        }
    }

    @Override
    public void eliminar(Object idUsuario) throws PersistenciaException {
        try {
            DeleteResult resultado = coleccion.deleteOne(Filters.eq("_id", new ObjectId(idUsuario.toString())));
            if (resultado.getDeletedCount() == 0) {
                throw new PersistenciaException("No se encontró el usuario a eliminar.");
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al eliminar usuario: " + e.getMessage(), e);
        }
    }

    @Override
    public Usuario buscarPorId(Object idUsuario) throws PersistenciaException {
        try {
            return coleccion.find(Filters.eq("_id", new ObjectId(idUsuario.toString()))).first();
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar usuario por id: " + e.getMessage(), e);
        }
    }

    @Override
    public Usuario buscarPorNombreUsuario(String nombreUsuario) throws PersistenciaException {
        try {
            return coleccion.find(Filters.eq("nombreUsuario", nombreUsuario)).first();
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar usuario por nombreUsuario: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Usuario> buscarTodos() throws PersistenciaException {
        try {
            return coleccion.find().into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar todos los usuarios: " + e.getMessage(), e);
        }
    }

    /**
     * Valida las credenciales de un usuario consultando por nombreUsuario y
     * comparando la contraseña encriptada.
     *
     * @param nombreUsuario Nombre de usuario
     * @param contrasena Contraseña en texto plano
     * @return Usuario si las credenciales son válidas, null si no
     * @throws PersistenciaException Si ocurre un error en la consulta
     */
    public Usuario validarCredenciales(String nombreUsuario, String contrasena) throws PersistenciaException {
        try {
            Usuario usuario = coleccion.find(Filters.eq("nombreUsuario", nombreUsuario)).first();
            if (usuario == null) {
                return null;
            }
            // Aquí usas tu encriptador para comparar
            if (EncriptadorUtil.verificar(contrasena, usuario.getContrasena())) {
                return usuario;
            }
            return null;
        } catch (Exception e) {
            throw new PersistenciaException("Error al validar credenciales: " + e.getMessage(), e);
        }
    }

}
