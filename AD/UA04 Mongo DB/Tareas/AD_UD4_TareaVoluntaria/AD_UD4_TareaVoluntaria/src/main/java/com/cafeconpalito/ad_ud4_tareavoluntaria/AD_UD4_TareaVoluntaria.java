/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cafeconpalito.ad_ud4_tareavoluntaria;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

/**
 *
 * @author produccion
 */
public class AD_UD4_TareaVoluntaria {

    public static void main(String[] args) {
        
        MongoCollection<Document> collection = ConexionMongoDB.getInstance().getMongoDataBase().getCollection("tarea_examen");
     
        //VARIABLES PARA LAS BUSQUEDAS
        String municipio = "GETXO";
        String dificultad = "MEDIA-BAJA";
        String nuevaColeccion = "tarea_examen_rutasCirculares";
        
        
        System.out.println("\nINSERCIONES\n");
        
        System.out.println("------------------------------------------------------------------------");
        System.out.println("\nInsercion 1");
        System.out.println("Insertando Senda Ciclable");
        Inserciones.insertarSenda(collection, "BILBAO", "BILBAO", 5, 3);
       
        
        System.out.println("------------------------------------------------------------------------");
        System.out.println("\nInsercion 2");
        System.out.println("Creando Coleccion en la DB");
        Inserciones.nuevaColeccionCircular(collection, nuevaColeccion);
        
        
        System.out.println("------------------------------------------------------------------------");
        System.out.println("\nCONSULTAS\n");
        
        
        System.out.println("------------------------------------------------------------------------");
        System.out.println("\nConsulta 1");
        System.out.println("Rutas con llegada o salida desde " + municipio );
        Consultas.listaRutasSalida(municipio, collection);
        
        
        System.out.println("------------------------------------------------------------------------");
        System.out.println("\nConsulta 2");
        System.out.println("Total de rutas con dificultad " + dificultad + " : " + Consultas.totalRutasDificultad(dificultad, collection));
        
        
        System.out.println("------------------------------------------------------------------------");
        System.out.println("\nConsulta 3");
        System.out.println("EL total de kilometros de las rutas con salida desde " + municipio + " son: " + Consultas.totalKmRutaLocalidad(collection, municipio));
        
    }
}
