/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Excepcion.PersistenciaException;
import Interfaces.IProductoDAO;
import POJOs.Producto;
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
 * Implementación de IProductoDAO para la gestión de productos en MongoDB.
 * Proporciona operaciones CRUD y consultas especializadas para productos.
 *
 * @author SDavidLedesma
 */
public class ProductoDAO implements IProductoDAO {

    private final MongoCollection<Producto> coleccion;

    /**
     * Constructor. Obtiene la colección de productos desde la conexión MongoDB.
     */
    public ProductoDAO() {
        this.coleccion = Conexion.getDatabase().getCollection("Producto", Producto.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Producto insertar(Producto producto) throws PersistenciaException {
        try {
            InsertOneResult resultado = coleccion.insertOne(producto);
            if (resultado.getInsertedId() != null) {
                producto.setId(resultado.getInsertedId().asObjectId().getValue());
                return producto;
            } else {
                throw new PersistenciaException("No se pudo insertar el producto.");
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al insertar producto: " + e.getMessage(), e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Producto actualizar(Producto producto) throws PersistenciaException {
        try {
            Bson filtro = Filters.eq("_id", producto.getId());
            UpdateResult resultado = coleccion.replaceOne(filtro, producto);
            if (resultado.getModifiedCount() == 0) {
                throw new PersistenciaException("No se encontró el producto a actualizar.");
            }
            return producto;
        } catch (Exception e) {
            throw new PersistenciaException("Error al actualizar producto: " + e.getMessage(), e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void eliminar(Object idProducto) throws PersistenciaException {
        try {
            DeleteResult resultado = coleccion.deleteOne(Filters.eq("_id", new ObjectId(idProducto.toString())));
            if (resultado.getDeletedCount() == 0) {
                throw new PersistenciaException("No se encontró el producto a eliminar.");
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al eliminar producto: " + e.getMessage(), e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Producto buscarPorId(Object idProducto) throws PersistenciaException {
        try {
            return coleccion.find(Filters.eq("_id", new ObjectId(idProducto.toString()))).first();
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar producto por id: " + e.getMessage(), e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Producto> buscarTodos() throws PersistenciaException {
        try {
            return coleccion.find().into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar todos los productos: " + e.getMessage(), e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Producto> buscarPorNombre(String nombre) throws PersistenciaException {
        try {
            // Búsqueda insensible a mayúsculas, contiene 'nombre'
            return coleccion.find(Filters.regex("nombre", ".*" + nombre + ".*", "i")).into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar producto por nombre: " + e.getMessage(), e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Producto> buscarPorCategoria(Object idCategoria) throws PersistenciaException {
        try {
            return coleccion.find(Filters.eq("idCategoria", new ObjectId(idCategoria.toString()))).into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar productos por categoría: " + e.getMessage(), e);
        }
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public List<Producto> buscarPorUnidadMedida(Object idUnidadMedida) throws PersistenciaException {
        try {
            return coleccion.find(Filters.eq("idUnidadMedida", new ObjectId(idUnidadMedida.toString()))).into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar productos por unidad de medida: " + e.getMessage(), e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Producto> productosBajoStock(int limite) throws PersistenciaException {
        try {
            return coleccion.find(Filters.lte("existencias", limite)).into(new ArrayList<>());
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar productos con bajo stock: " + e.getMessage(), e);
        }
    }
}
