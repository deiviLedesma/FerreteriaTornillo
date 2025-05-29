/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 * Clase que gestiona la conexion con la base de datos MongoDb para el sistema
 * de ferreteria "El tornillo feliz"
 *
 * @author SDavidLedesma
 */
public class Conexion {

    /**
     * Objeto que mantiene la conexion activa hacia el servidor MongoDB
     */
    private static MongoClient mongoClient = null;

    /**
     * se conecta por altas el url
     */
    private static final String URL = "mongodb://localhost:27017";

    /**
     * nombre de la base de datos
     */
    private static final String DATABASE_NAME = "ElTornilloFeliz";

    /**
     * Constructor privado para prevenir instaciacion evita que se cree una
     * instancia usando new Conexion() se accede solo mediante el meotdo
     * getDatabase()
     */
    private Conexion() {

    }

    public static MongoDatabase getDatabase() {
        if (mongoClient == null) {
            /**
             * Configuracion del codec para manejo de POJOs
             */
            CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(
                    /**
                     * Codecs basicos
                     */
                    MongoClientSettings.getDefaultCodecRegistry(),
                    /**
                     * le comunica a mongoDb que intente mapear cualquier clae
                     * Pojo automaticamente
                     */
                    CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).register("POJOs").build())
            );

            /**
             * Configuracion de los ajutos del cliente MongoDB, incluyendo la
             * cadena de conexion (URL) y el registro de codecs anterior
             *
             * se configura la conexion el codecRegistry hhabilita soporte para
             * POJOs todo se empaqueta en MogoClientSettings
             *
             */
            MongoClientSettings clientSettings = MongoClientSettings.builder()
                    .applyConnectionString(new com.mongodb.ConnectionString(URL))
                    .codecRegistry(pojoCodecRegistry).build();

            /**
             * se asigna los ajustes al MongoCliente estático de la clase con
             * eto se crea la conexion con todos los ajustes definidos antes
             */
            mongoClient = MongoClients.create(clientSettings);

            /**
             * regresamos la base de datos con la configuracion codecs aqui se
             * asegura que se respete la configuracion al acceder a la base de
             * datos
             */
            return mongoClient.getDatabase(DATABASE_NAME).withCodecRegistry(pojoCodecRegistry);

        }
        /**
         * si no es null, regresa la base de datos
         */
        return mongoClient.getDatabase(DATABASE_NAME);
    }

    /**
     * Cierra la conexión con MongoDB
     */
    public static void close() {
        if (mongoClient != null) {
            mongoClient.close();
            mongoClient = null;
        }
    }
}
