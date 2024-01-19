/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.ad_ud4_superficiescultivo;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Clase para rgestionar la conexion a la BBDDD MongoDB
 *
 * @author Cafe Con Palito
 */
public class ConexionMongoDB {

    //NECESARIO PARA MONGO DB
    static final String USER = "daniel";
    static final String PASS = "1234";
    static final String CLUSTER = "@superficie.lkjhh2s.mongodb.net/?retryWrites=true&w=majority";
    static final String DB = "Superficie"; // nombre de la base de datos

    private static ConexionMongoDB instance = null;

    private MongoDatabase mongoDatabase = null;
    private MongoClient mongoClient = null;
    private MongoCollection collection = null;

    /**
     * Constructor que inicia la coneccion
     */
    private ConexionMongoDB() {

        String connectionString = "mongodb+srv://" + USER + ":" + PASS + CLUSTER;

        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();
                
            
        
        try {
            mongoClient = MongoClients.create(settings);
            mongoDatabase = mongoClient.getDatabase(DB);
            
            mongoDatabase.runCommand(new Document("ping", 1));
            
            System.out.println("Connection OK");
        } catch (MongoException e) {
            e.printStackTrace();
            System.out.println("ERROR CONECTION MONGO DB");
        }
    }

    public static ConexionMongoDB getInstance() {
        if (instance == null) {
            instance = new ConexionMongoDB();
        }
        return instance;
    }

    /**
     * Método que devuelve la conexión a la base de datos
     * @return MongoDatabase
     */
    public MongoDatabase getMongoDataBase() {
        return mongoDatabase;
    }

    /**
     * Metodo para desconectar la DB
     */
    public void desconectar() {

        mongoClient.close();

    }
    
    /**
     *  Método que devuelve el cliente que conecta a la base de datos.
     * @return MongoClient
     */
    public MongoClient getClient(){
        
        return mongoClient;
    }

}
