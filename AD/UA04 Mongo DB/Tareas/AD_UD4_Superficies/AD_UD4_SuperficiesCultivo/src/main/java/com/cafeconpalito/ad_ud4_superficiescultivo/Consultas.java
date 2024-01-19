/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.ad_ud4_superficiescultivo;

import com.mongodb.client.DistinctIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Sorts.*;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author Cafe Con Palito
 */
public class Consultas {

    /**
     * Método que muestre los datos del tipo de cultivo y la superficie de
     * cultivo de una provincia determinada ordenadas ascendentemente por
     * superficie.
     *
     * @param collection MongoCollection
     * @param provincia Nombre de la provincia
     */
    public static void cultivoProvincia(MongoCollection collection, String provincia) {

        FindIterable<Document> documents = collection.find(eq("provincia", provincia)).sort(ascending("superficie"));
        MongoCursor<Document> cursor = documents.iterator();
        while (cursor.hasNext()) {
            Document d = cursor.next();
            String cultivo = d.getString("producto");
            int superficie = d.getInteger("superficie");
            System.out.println("\tCultivo: " + cultivo + " | Superficie: " + superficie);
        }

    }

    /**
     * Método que devuelve la lista con el nombre de las 9 provincias incluidas
     * en la colección.
     *
     * @param collection MongoCollection
     * @return Lista de tipo String con los nombres de las provincias, sin
     * repetir
     */
    public static ArrayList<String> nombreProvincias(MongoCollection collection) {

        DistinctIterable<String> documents = collection.distinct("provincia", String.class);
        MongoCursor<String> cursor = documents.iterator();

        ArrayList<String> lista = new ArrayList<>();

        while (cursor.hasNext()) {
            lista.add(cursor.next());
        }

        return lista;
    }

    /**
     * Método que devuelve la superficie de cultivo en una provincia para un
     * producto concreto
     *
     * @param collection MongoCollection
     * @param provincia Nombre de la provincia
     * @param producto Nombre del producto
     * @return int con la superficie
     */
    public static Integer superficieProvinciaProducto(MongoCollection collection, String provincia, String producto) {

        FindIterable<Document> documents = collection.find(and(eq("provincia", provincia),eq("producto",producto)));
        MongoCursor<Document> cursor = documents.iterator();
        int aux = 0;
        while (cursor.hasNext()) {
            //ystem.out.println(cursor.next().getInteger("numero_de_solicitudes_presentadas"));
            aux += cursor.next().getInteger("superficie");
        }

        return aux;
    }

    
}
