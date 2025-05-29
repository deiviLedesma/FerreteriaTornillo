/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Excepcion.PersistenciaException;
import Interfaces.IUnidadMedidaDAO;
import POJOs.UnidadMedida;
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
 * Implementación de IUnidadMedidaDAO para la gestión de unidades de medida en
 * MongoDB. Proporciona operaciones CRUD y búsquedas por nombre.
 *
 * @author SDavidLedesma
 */
public class UnidadMedidaDAO implements IUnidadMedidaDAO {

    private final MongoCollection<UnidadMedida> coleccion;

    /**
     * Constructor. Obtiene la colección de unidades de medida desde la conexión
     * MongoDB.
     */
    public UnidadMedidaDAO() {
        this.coleccion = Conexion.getDatabase().getCollection("UnidadMedida", UnidadMedida.class);
    }

    @Override
    public UnidadMedida insertar(UnidadMedida unidad) throws PersistenciaException {
        try {
            InsertOneResult resultado = coleccion.insertOne(unidad);
            if (resultado.getInsertedId() != null) {
                unidad.setId(resultado.getInsertedId().asObjectId().getValue());
                return unidad;
            } else {
                throw new PersistenciaException("No se pudo insertar la unidad de medida.");
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al insertar unidad de medida: " + e.getMessage(), e);
        }
    }

    @Override
    public UnidadMedida actualizar(UnidadMedida unidad) throws PersistenciaException {
        try {
            Bson filtro = Filters.eq("_id", unidad.getId());
            UpdateResult resultado = coleccion.replaceOne(filtro, unidad);
            if (resultado.getModifiedCount() == 0) {
                throw new PersistenciaException("No se encontró la unidad de medida a actualizar.");
            }
            return unidad;
        } catch (Exception e) {
            throw new PersistenciaException("Error al actualizar unidad de medida: " + e.getMessage(), e);
        }
    }

    @Override
    public void eliminar(Object idUnidadMedida) throws PersistenciaException {
        try {
            DeleteResult resultado = coleccion.deleteOne(Filters.eq("_id", new ObjectId(idUnidadMedida.toString())));
            if (resultado.getDeletedCount() == 0) {
                throw new PersistenciaException("No se encontró la unidad de medida a eliminar.");
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al eliminar unidad de medida: " + e.getMessage(), e);
        }
    }

    @Override
    public UnidadMedida buscarPorId(Object idUnidadMedida) throws PersistenciaException {
        try {
            return coleccion.find(Filters.eq("_id", new ObjectId(idUnidadMedida.toString()))).first();
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar unidad de medida por id: " + e.getMessage(), e);
        }
    }

    @Override
    public List<UnidadMedida> buscarTodos() throws PersistenciaException {
        try {
            return coleccion.find().into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar todas las unidades de medida: " + e.getMessage(), e);
        }
    }

    @Override
    public List<UnidadMedida> buscarPorNombre(String nombre) throws PersistenciaException {
        try {
            return coleccion.find(Filters.regex("nombre", ".*" + nombre + ".*", "i")).into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar unidades de medida por nombre: " + e.getMessage(), e);
        }
    }
}
