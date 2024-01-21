/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.ad_ud4_tareavoluntaria;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Sorts.*;
import org.bson.Document;

/**
 *
 * @author produccion
 */
public class Consultas {

    /**
     * Muestra por pantalla las rutas ciclables que salen o llegan de un
     * municipio.
     *
     * @param municipio
     * @param collection
     */
    public static void listaRutasSalida(String municipio, MongoCollection collection) {

        FindIterable<Document> documents = collection.find(or(eq("MUNICIPIO_SALIDA", municipio), eq("MUNICIPIO_LLEGADA", municipio)));
        MongoCursor<Document> cursor = documents.iterator();
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }

    }

    /**
     * Método que devuelve el total de rutas ciclables que hay con una
     * dificultad determinada
     *
     * @param dificultad
     * @param collection
     * @return el total de rutas
     */
    public static int totalRutasDificultad(String dificultad, MongoCollection collection) {

        int aux = 0;

        FindIterable<Document> documents = collection.find(eq("DIFICULTAD", dificultad));
        MongoCursor<Document> cursor = documents.iterator();
        while (cursor.hasNext()) {
            aux++;
            cursor.next();
        }

        return aux;
    }

    /**
     * Método que devuelve el número total de kilómetros de todas las rutas que
     * salen de una determinada localidad
     *
     * @param collection
     * @param salida
     * @return int sumakm
     */
    public static int totalKmRutaLocalidad(MongoCollection collection, String salida) {
        
        int aux = 0;
        
        FindIterable<Document> documents = collection.find(and(eq("MUNICIPIO_SALIDA",salida),gt("LONGITUD_KM",0)));
        MongoCursor<Document> cursor = documents.iterator();
        while (cursor.hasNext()) {
            aux += cursor.next().getInteger("LONGITUD_KM");
        }
        
        return aux;
    }

}
