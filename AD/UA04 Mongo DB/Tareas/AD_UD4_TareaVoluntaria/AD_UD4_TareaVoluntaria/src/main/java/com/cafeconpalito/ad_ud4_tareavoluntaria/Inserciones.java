/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.ad_ud4_tareavoluntaria;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;

/**
 *
 * @author produccion
 */
public class Inserciones {

    /**
     * Método que inserta un documento con los siguientes datos
     * MUNICIPIO_SALIDA, MUNICIPIO_LLEGADA, LONGITUD_KM, DURACION_H
     *
     * @param collection
     * @param salida MUNICIPIO_SALIDA
     * @param llegada MUNICIPIO_LLEGADA
     * @param km LONGITUD_KM
     * @param horas DURACION_H
     */
    public static void insertarSenda(MongoCollection collection, String salida, String llegada, int km, int horas) {

        Document doc = new Document();
        doc.append("MUNICIPIO_SALIDA", salida);
        doc.append("MUNICIPIO_LLEGADA", llegada);
        doc.append("LONGITUD_KM", km);
        doc.append("DURACION_H", horas);

        collection.insertOne(doc);

        System.out.println("Insercion Realizada");
    }

    /**
     * Insertar una colección nueva en la base datos Los datos se obtienen con
     * una consulta a la colección actual para obtener la lista de todos los
     * documentos recorrido CIRCULAR Solo nos interesa proyectar el municipio
     * de salida, el recorrido y kilómetros.
     * 
     * 
     * @param collectionGetData  MongoCollection de la cual se obtienen los datos
     * @param nombreColeccion nombre de la nueva coleccion
     */
    public static void nuevaColeccionCircular(MongoCollection collectionGetData,String nombreColeccion) {

        //Creo una nueva conexion con el nombre de la nueva coleccion
        ConexionMongoDB.getInstance().getMongoDataBase().createCollection(nombreColeccion);
        
        //Genero la conexion a la nueva coleccion
        MongoCollection collection = ConexionMongoDB.getInstance().getMongoDataBase().getCollection(nombreColeccion);
        
        //BUSCO LA INFO EN LA COLECCION PARA OBTENER LAS CIRCULARES
        FindIterable<Document> documents = collectionGetData.find(eq("RECORRIDO","CIRCULAR"));
        MongoCursor<Document> cursor = documents.iterator();
        
        //ITERO Y AÑADO A LA NUEVA COLECCION LAS RUTAS
        while (cursor.hasNext()) {
            
            Document doc = cursor.next();

            sendaCircular(collection, doc.getString("MUNICIPIO_SALIDA"), doc.getString("RECORRIDO"), doc.getInteger("LONGITUD_KM"));
            
            System.out.println("RUTA CIRCULAR INSERTADA");
            
        }
        
        System.out.println("RUTAS INSERTADAS");
        
    }
    
    /**
     * Metodo para insertar RUTAS CIRCULARES EN UNA COLLECCION
     * @param collection
     * @param munSalida
     * @param recorrido
     * @param km 
     */
    private static void sendaCircular(MongoCollection collection,String munSalida,String recorrido, int km){
        
        //Genero el documento con la informacion necesaria
        Document doc = new Document();
        
        doc.append("MUNICIPIO_SALIDA", munSalida);
        doc.append("RECORRIDO", recorrido);
        doc.append("LONGITUD_KM", km);
        
        collection.insertOne(doc);
        
    }

}
