/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.ad_ud4_ayudas;

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
     * Método que muestre los datos de las secciones agrarias comarcales y el
     * número de solicitudes para una provincia determinada, ordenadas
     * ascendentemente por número de solicitudes.
     *
     * @param collection MongoCollection
     * @param provincia Nombre de la provincia
     */
    public static void seccionesAgrarias(MongoCollection collection, String provincia) {

        FindIterable<Document> documents = collection.find(eq("provincia", provincia)).sort(ascending("numero_de_solicitudes_presentadas"));
        MongoCursor<Document> cursor = documents.iterator();
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
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
        
        ArrayList<String> lista = new ArrayList<>() ;
        
        while (cursor.hasNext()) {
            lista.add(cursor.next());
        }

        return lista ;
    }

    /**
     * Método que devuelve el número total de solicitudes presentadas en una
     * provincia concreta.
     *
     * @param collection MongoCollection
     * @param provincia Nombre de la provincia
     *
     * @return int con el número total de solicitudes
     */
    public static int solicitudesPorProvincia(MongoCollection collection, String provincia) {

        FindIterable<Document> documents = collection.find(eq("provincia", provincia));
        MongoCursor<Document> cursor = documents.iterator();
        int aux = 0;
        while (cursor.hasNext()) {
            //ystem.out.println(cursor.next().getInteger("numero_de_solicitudes_presentadas"));
            aux += cursor.next().getInteger("numero_de_solicitudes_presentadas");
        }

        return aux; 
    }

    /**
     * Método que muestra la provincia, sección agraria y número de solicitudes
     * cuando el número de solicitudes sea menor a un valor especificado como
     * parámetro.
     *
     * @param collection MongoCollection
     * @param minimoSolicitudes número mínimo de solicitudes para filtrar
     *
     */
    public static void muestraDatosDeProvinciaPorSolicitudesInferiores(MongoCollection collection, int minimoSolicitudes) {
        
        FindIterable<Document> documents = collection.find(lt("numero_de_solicitudes_presentadas",minimoSolicitudes)).sort(ascending("numero_de_solicitudes_presentadas"));
        MongoCursor<Document> cursor = documents.iterator();
        while (cursor.hasNext()) {
            Document aux = cursor.next();
            String provincia = aux.getString("provincia");
            String seccionAgraria = aux.getString("seccion_agrarica_comarcal");
            int solicitudes = aux.getInteger("numero_de_solicitudes_presentadas");
            System.out.println("Provincia: "+ provincia + " | Seccion agraria: " +seccionAgraria + " | Numero de solicitudes: " + solicitudes);
        }
        
    }

}
