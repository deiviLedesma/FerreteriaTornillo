/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Excepcion.PersistenciaException;
import Interfaces.IProveedorDAO;
import POJOs.Proveedor;
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
 * Implementación de IProveedorDAO para la gestión de proveedores en MongoDB.
 * Proporciona operaciones CRUD y búsquedas por nombre.
 *
 * @author SDavidLedesma
 */
public class ProveedorDAO implements IProveedorDAO {

    private final MongoCollection<Proveedor> coleccion;

    /**
     * Constructor. Obtiene la colección de proveedores desde la conexión
     * MongoDB.
     */
    public ProveedorDAO() {
        this.coleccion = Conexion.getDatabase().getCollection("Proveedor", Proveedor.class);
    }

    @Override
    public Proveedor insertar(Proveedor proveedor) throws PersistenciaException {
        try {
            InsertOneResult resultado = coleccion.insertOne(proveedor);
            if (resultado.getInsertedId() != null) {
                proveedor.setId(resultado.getInsertedId().asObjectId().getValue());
                return proveedor;
            } else {
                throw new PersistenciaException("No se pudo insertar el proveedor.");
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al insertar proveedor: " + e.getMessage(), e);
        }
    }

    @Override
    public Proveedor actualizar(Proveedor proveedor) throws PersistenciaException {
        try {
            Bson filtro = Filters.eq("_id", proveedor.getId());
            UpdateResult resultado = coleccion.replaceOne(filtro, proveedor);
            if (resultado.getModifiedCount() == 0) {
                throw new PersistenciaException("No se encontró el proveedor a actualizar.");
            }
            return proveedor;
        } catch (Exception e) {
            throw new PersistenciaException("Error al actualizar proveedor: " + e.getMessage(), e);
        }
    }

    @Override
    public void eliminar(Object idProveedor) throws PersistenciaException {
        try {
            DeleteResult resultado = coleccion.deleteOne(Filters.eq("_id", new ObjectId(idProveedor.toString())));
            if (resultado.getDeletedCount() == 0) {
                throw new PersistenciaException("No se encontró el proveedor a eliminar.");
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al eliminar proveedor: " + e.getMessage(), e);
        }
    }

    @Override
    public Proveedor buscarPorId(Object idProveedor) throws PersistenciaException {
        try {
            return coleccion.find(Filters.eq("_id", new ObjectId(idProveedor.toString()))).first();
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar proveedor por id: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Proveedor> buscarTodos() throws PersistenciaException {
        try {
            return coleccion.find().into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar todos los proveedores: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Proveedor> buscarPorNombre(String nombre) throws PersistenciaException {
        try {
            return coleccion.find(Filters.regex("nombre", ".*" + nombre + ".*", "i")).into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar proveedores por nombre: " + e.getMessage(), e);
        }
    }
}
