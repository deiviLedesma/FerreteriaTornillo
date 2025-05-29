/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Excepcion.PersistenciaException;
import Interfaces.ICompraDAO;
import POJOs.Compra;
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
 * Implementación de ICompraDAO para la gestión de compras en MongoDB.
 * Proporciona operaciones CRUD y consultas de reporte para compras.
 *
 * @author SDavidLedesma
 */
public class CompraDAO implements ICompraDAO {

    private final MongoCollection<Compra> coleccion;

    /**
     * Constructor. Obtiene la colección de compras desde la conexión MongoDB.
     */
    public CompraDAO() {
        this.coleccion = Conexion.getDatabase().getCollection("Compra", Compra.class);
    }

    @Override
    public Compra insertar(Compra compra) throws PersistenciaException {
        try {
            InsertOneResult resultado = coleccion.insertOne(compra);
            if (resultado.getInsertedId() != null) {
                compra.setId(resultado.getInsertedId().asObjectId().getValue());
                return compra;
            } else {
                throw new PersistenciaException("No se pudo insertar la compra.");
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al insertar compra: " + e.getMessage(), e);
        }
    }

    @Override
    public Compra actualizar(Compra compra) throws PersistenciaException {
        try {
            Bson filtro = Filters.eq("_id", compra.getId());
            UpdateResult resultado = coleccion.replaceOne(filtro, compra);
            if (resultado.getModifiedCount() == 0) {
                throw new PersistenciaException("No se encontró la compra a actualizar.");
            }
            return compra;
        } catch (Exception e) {
            throw new PersistenciaException("Error al actualizar compra: " + e.getMessage(), e);
        }
    }

    @Override
    public void eliminar(Object idCompra) throws PersistenciaException {
        try {
            DeleteResult resultado = coleccion.deleteOne(Filters.eq("_id", new ObjectId(idCompra.toString())));
            if (resultado.getDeletedCount() == 0) {
                throw new PersistenciaException("No se encontró la compra a eliminar.");
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al eliminar compra: " + e.getMessage(), e);
        }
    }

    @Override
    public Compra buscarPorId(Object idCompra) throws PersistenciaException {
        try {
            return coleccion.find(Filters.eq("_id", new ObjectId(idCompra.toString()))).first();
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar compra por id: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Compra> buscarTodos() throws PersistenciaException {
        try {
            return coleccion.find().into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar todas las compras: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Compra> buscarPorRangoFechas(Date inicio, Date fin) throws PersistenciaException {
        try {
            Bson filtro = Filters.and(
                    Filters.gte("fechaHora", inicio),
                    Filters.lte("fechaHora", fin)
            );
            return coleccion.find(filtro).into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar compras por rango de fechas: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Compra> buscarPorProveedor(Object idProveedor) throws PersistenciaException {
        try {
            return coleccion.find(Filters.eq("idProveedor", new ObjectId(idProveedor.toString()))).into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar compras por proveedor: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Compra> reporteComprasPorFechasYProveedor(Date inicio, Date fin, Object idProveedor) throws PersistenciaException {
        try {
            List<Bson> filtros = new ArrayList<>();
            filtros.add(Filters.gte("fechaHora", inicio));
            filtros.add(Filters.lte("fechaHora", fin));
            if (idProveedor != null) {
                filtros.add(Filters.eq("idProveedor", new ObjectId(idProveedor.toString())));
            }
            Bson filtro = Filters.and(filtros.toArray(Bson[]::new )); //con este bson[]::new evito crear dos arreglos
            return coleccion.find(filtro).into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al generar reporte de compras: " + e.getMessage(), e);
        }
    }

}
