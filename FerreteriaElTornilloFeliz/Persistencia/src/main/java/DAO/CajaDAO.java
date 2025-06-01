/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Excepcion.PersistenciaException;
import Interfaces.ICajaDAO;
import POJOs.Caja;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * Implementación de ICajaDAO para la gestión de cajas en MongoDB. Proporciona
 * operaciones de apertura/cierre y búsquedas para cajas diarias.
 *
 * @author SDavidLedesma
 */
public class CajaDAO implements ICajaDAO {

    private final MongoCollection<Caja> coleccion;

    /**
     * Constructor. Obtiene la colección de cajas desde la conexión MongoDB.
     */
    public CajaDAO() {
        this.coleccion = Conexion.getDatabase().getCollection("Caja", Caja.class);
    }

    @Override
    public Caja abrirCaja(Caja caja) throws PersistenciaException {
        try {
            InsertOneResult resultado = coleccion.insertOne(caja);
            if (resultado.getInsertedId() != null) {
                caja.setId(resultado.getInsertedId().asObjectId().getValue());
                return caja;
            } else {
                throw new PersistenciaException("No se pudo abrir la caja.");
            }
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Error al abrir caja: " + e.getMessage(), e);
        }
    }

    @Override
    public Caja cerrarCaja(Caja caja) throws PersistenciaException {
        try {
            Bson filtro = Filters.eq("_id", caja.getId());
            UpdateResult resultado = coleccion.replaceOne(filtro, caja);
            if (resultado.getModifiedCount() == 0) {
                throw new PersistenciaException("No se encontró la caja a cerrar.");
            }
            return caja;
        } catch (Exception e) {
            throw new PersistenciaException("Error al cerrar caja: " + e.getMessage(), e);
        }
    }

    @Override
    public Caja buscarPorId(Object idCaja) throws PersistenciaException {
        try {
            return coleccion.find(Filters.eq("_id", new ObjectId(idCaja.toString()))).first();
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar caja por id: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Caja> buscarTodos() throws PersistenciaException {
        try {
            return coleccion.find().into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar todas las cajas: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Caja> buscarPorRangoFechas(Date inicio, Date fin) throws PersistenciaException {
        try {
            List<Bson> filtros = new ArrayList<>();
            filtros.add(Filters.gte("fechaHoraApertura", inicio));
            filtros.add(Filters.lte("fechaHoraApertura", fin));
            Bson filtro = Filters.and(filtros.toArray(Bson[]::new));
            return coleccion.find(filtro).into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar cajas por rango de fechas: " + e.getMessage(), e);
        }
    }

    @Override
    public Caja buscarCajaActiva() throws PersistenciaException {
        try {
            // Caja activa: que no tenga fecha de cierre
            return coleccion.find(Filters.eq("fechaHoraCierre", null)).first();
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar la caja activa: " + e.getMessage(), e);
        }
    }
}
