/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Excepcion.PersistenciaException;
import Interfaces.ICategoriaDAO;
import POJOs.Categoria;
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
 * Implementación de ICategoriaDAO para la gestión de categorías en MongoDB.
 * Proporciona operaciones CRUD y búsquedas por nombre.
 *
 * @author SDavidLedesma
 */
public class CategoriaDAO implements ICategoriaDAO {

    private final MongoCollection<Categoria> coleccion;

    /**
     * Constructor. Obtiene la colección de categorías desde la conexión
     * MongoDB.
     */
    public CategoriaDAO() {
        this.coleccion = Conexion.getDatabase().getCollection("Categoria", Categoria.class);
    }

    @Override
    public Categoria insertar(Categoria categoria) throws PersistenciaException {
        try {
            InsertOneResult resultado = coleccion.insertOne(categoria);
            if (resultado.getInsertedId() != null) {
                categoria.setId(resultado.getInsertedId().asObjectId().getValue());
                return categoria;
            } else {
                throw new PersistenciaException("No se pudo insertar la categoría.");
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al insertar categoría: " + e.getMessage(), e);
        }
    }

    @Override
    public Categoria actualizar(Categoria categoria) throws PersistenciaException {
        try {
            Bson filtro = Filters.eq("_id", categoria.getId());
            UpdateResult resultado = coleccion.replaceOne(filtro, categoria);
            if (resultado.getModifiedCount() == 0) {
                throw new PersistenciaException("No se encontró la categoría a actualizar.");
            }
            return categoria;
        } catch (Exception e) {
            throw new PersistenciaException("Error al actualizar categoría: " + e.getMessage(), e);
        }
    }

    @Override
    public void eliminar(Object idCategoria) throws PersistenciaException {
        try {
            DeleteResult resultado = coleccion.deleteOne(Filters.eq("_id", new ObjectId(idCategoria.toString())));
            if (resultado.getDeletedCount() == 0) {
                throw new PersistenciaException("No se encontró la categoría a eliminar.");
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al eliminar categoría: " + e.getMessage(), e);
        }
    }

    @Override
    public Categoria buscarPorId(Object idCategoria) throws PersistenciaException {
        try {
            return coleccion.find(Filters.eq("_id", new ObjectId(idCategoria.toString()))).first();
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar categoría por id: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Categoria> buscarTodos() throws PersistenciaException {
        try {
            return coleccion.find().into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar todas las categorías: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Categoria> buscarPorNombre(String nombre) throws PersistenciaException {
        try {
            return coleccion.find(Filters.regex("nombre", ".*" + nombre + ".*", "i")).into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar categorías por nombre: " + e.getMessage(), e);
        }
    }
}
