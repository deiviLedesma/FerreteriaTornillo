/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Excepcion.PersistenciaException;
import Interfaces.IVentaDAO;
import POJOs.Venta;
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
 * Implementación de IVentaDAO para la gestión de ventas en MongoDB. Proporciona
 * operaciones CRUD y consultas de reporte para ventas.
 *
 * @author SDavidLedesmaS
 */
public class VentaDAO implements IVentaDAO {

    private final MongoCollection<Venta> coleccion;

    /**
     * Constructor. Obtiene la colección de ventas desde la conexión MongoDB.
     */
    public VentaDAO() {
        this.coleccion = Conexion.getDatabase().getCollection("Venta", Venta.class);
    }

    @Override
    public Venta insertar(Venta venta) throws PersistenciaException {
        try {
            InsertOneResult resultado = coleccion.insertOne(venta);
            if (resultado.getInsertedId() != null) {
                return venta;
            } else {
                throw new PersistenciaException("No se pudo insertar la venta.");
            }
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error al insertar venta: " + e.getMessage(), e);
        }
    }

    @Override
    public Venta actualizar(Venta venta) throws PersistenciaException {
        try {
            Bson filtro = Filters.eq("_id", venta.getId());
            UpdateResult resultado = coleccion.replaceOne(filtro, venta);
            if (resultado.getModifiedCount() == 0) {
                throw new PersistenciaException("No se encontró la venta a actualizar.");
            }
            return venta;
        } catch (Exception e) {
            throw new PersistenciaException("Error al actualizar venta: " + e.getMessage(), e);
        }
    }

    @Override
    public void eliminar(Object idVenta) throws PersistenciaException {
        try {
            DeleteResult resultado = coleccion.deleteOne(Filters.eq("_id", new ObjectId(idVenta.toString())));
            if (resultado.getDeletedCount() == 0) {
                throw new PersistenciaException("No se encontró la venta a eliminar.");
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al eliminar venta: " + e.getMessage(), e);
        }
    }

    @Override
    public Venta buscarPorId(Object idVenta) throws PersistenciaException {
        try {
            return coleccion.find(Filters.eq("_id", new ObjectId(idVenta.toString()))).first();
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar venta por id: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Venta> buscarTodos() throws PersistenciaException {
        try {
            return coleccion.find().into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar todas las ventas: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Venta> buscarPorRangoFechas(Date inicio, Date fin) throws PersistenciaException {
        try {
            List<Bson> filtros = new ArrayList<>();
            filtros.add(Filters.gte("fechaHora", inicio));
            filtros.add(Filters.lte("fechaHora", fin));
            Bson filtro = Filters.and(filtros.toArray(Bson[]::new));
            return coleccion.find(filtro).into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar ventas por rango de fechas: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Venta> buscarPorUsuario(Object idUsuario) throws PersistenciaException {
        try {
            return coleccion.find(Filters.eq("idUsuario", new ObjectId(idUsuario.toString()))).into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar ventas por usuario: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Venta> reporteVentasPorFechasYUsuario(Date inicio, Date fin, Object idUsuario) throws PersistenciaException {
        try {
            List<Bson> filtros = new ArrayList<>();
            filtros.add(Filters.gte("fechaHora", inicio));
            filtros.add(Filters.lte("fechaHora", fin));
            if (idUsuario != null) {
                filtros.add(Filters.eq("idUsuario", idUsuario.toString()));
            }
            Bson filtro = Filters.and(filtros.toArray(Bson[]::new));
            return coleccion.find(filtro).into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al generar reporte de ventas: " + e.getMessage(), e);
        }
    }
}
