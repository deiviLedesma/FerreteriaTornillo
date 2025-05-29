/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Excepcion.PersistenciaException;
import Interfaces.IDevolucionDAO;
import POJOs.Devolucion;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * Implementación de IDevolucionDAO para la gestión de devoluciones en MongoDB.
 * Proporciona operaciones CRUD y búsquedas especializadas.
 *
 * @author SDavidLedesma
 */
public class DevolucionDAO implements IDevolucionDAO {

    private final MongoCollection<Devolucion> coleccion;

    /**
     * Constructor. Obtiene la colección de devoluciones desde la conexión
     * MongoDB.
     */
    public DevolucionDAO() {
        this.coleccion = Conexion.getDatabase().getCollection("Devolucion", Devolucion.class);
    }

    @Override
    public Devolucion insertar(Devolucion devolucion) throws PersistenciaException {
        try {
            InsertOneResult resultado = coleccion.insertOne(devolucion);
            if (resultado.getInsertedId() != null) {
                devolucion.setId(resultado.getInsertedId().asObjectId().getValue());
                return devolucion;
            } else {
                throw new PersistenciaException("No se pudo insertar la devolución.");
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al insertar devolución: " + e.getMessage(), e);
        }
    }

    @Override
    public Devolucion actualizar(Devolucion devolucion) throws PersistenciaException {
        try {
            Bson filtro = Filters.eq("_id", devolucion.getId());
            UpdateResult resultado = coleccion.replaceOne(filtro, devolucion);
            if (resultado.getModifiedCount() == 0) {
                throw new PersistenciaException("No se encontró la devolución a actualizar.");
            }
            return devolucion;
        } catch (Exception e) {
            throw new PersistenciaException("Error al actualizar devolución: " + e.getMessage(), e);
        }
    }

    @Override
    public void eliminar(Object idDevolucion) throws PersistenciaException {
        try {
            DeleteResult resultado = coleccion.deleteOne(Filters.eq("_id", new ObjectId(idDevolucion.toString())));
            if (resultado.getDeletedCount() == 0) {
                throw new PersistenciaException("No se encontró la devolución a eliminar.");
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al eliminar devolución: " + e.getMessage(), e);
        }
    }

    @Override
    public Devolucion buscarPorId(Object idDevolucion) throws PersistenciaException {
        try {
            return coleccion.find(Filters.eq("_id", new ObjectId(idDevolucion.toString()))).first();
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar devolución por id: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Devolucion> buscarTodos() throws PersistenciaException {
        try {
            return coleccion.find().into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar todas las devoluciones: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Devolucion> buscarPorRangoFechas(Date inicio, Date fin) throws PersistenciaException {
        try {
            List<Bson> filtros = new ArrayList<>();
            filtros.add(Filters.gte("fecha", inicio));
            filtros.add(Filters.lte("fecha", fin));
            Bson filtro = Filters.and(filtros.toArray(Bson[]::new));
            return coleccion.find(filtro).into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar devoluciones por rango de fechas: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Devolucion> buscarPorUsuario(Object idUsuario) throws PersistenciaException {
        try {
            return coleccion.find(Filters.eq("usuario", idUsuario.toString())).into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar devoluciones por usuario: " + e.getMessage(), e);
        }
    }
}
