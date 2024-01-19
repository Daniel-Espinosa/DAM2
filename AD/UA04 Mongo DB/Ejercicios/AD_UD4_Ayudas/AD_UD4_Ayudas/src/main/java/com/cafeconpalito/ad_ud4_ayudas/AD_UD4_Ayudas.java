/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.cafeconpalito.ad_ud4_ayudas;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

/**
 *
 * @author Cafe Con Palito
 */
public class AD_UD4_Ayudas {

    public static void main(String[] args) {

        //Metodo para crear la conexion
        //MongoDatabase db = ConexionMongoDB.getInstance().getMongoDataBase();
        //MongoCollection<Document> collection = db.getCollection("mydata");
        
        //Crear la conexion en una linea
        MongoCollection<Document> collection = ConexionMongoDB.getInstance().getMongoDataBase().getCollection("mydata");
        
        String provincia = "BURGOS";
        int minimoSolicitudes = 200;

        System.out.println("CONSULTA 1");
        System.out.println("\tMétodo que muestre los datos de las secciones agrarias comarcales y el\n"
                + "\tnúmero de solicitudes para una provincia determinada, ordenadas\n"
                + "\tascendentemente por número de solicitudes.\n");
        System.out.println("Datos de la secciones agrarias de " + provincia + "\n");
        Consultas.seccionesAgrarias(collection, provincia);
        System.out.println("\n----------------------------------------------------------------------\n");


        System.out.println("CONSULTA 2");
        System.out.println("\tMétodo que devuelve la lista con el nombre de las 9 provincias\n" +
                            "\tincluidas en la colección.\n");
        for (String i : Consultas.nombreProvincias(collection)) {
            System.out.println(i);
        }
        System.out.println("\n----------------------------------------------------------------------\n");


        System.out.println("CONSULTA 3");
        System.out.println("\tMétodo que devuelve el número total de solicitudes\n"
                + "\tpresentadas en una provincia concreta.\n");
        int aux = Consultas.solicitudesPorProvincia(collection,provincia);
        System.out.println("Total de solicitudes de la provincia de " + provincia + " son: " + aux);
        System.out.println("\n----------------------------------------------------------------------\n");

        System.out.println("CONSULTA 4");
        System.out.println("\tMétodo que muestra la provincia, sección agraria y número de\n" 
                        + "\tsolicitudes cuando el número de solicitudes sea menor a un valor\n" 
                        + " \tespecificado como parámetro.\n");
        Consultas.muestraDatosDeProvinciaPorSolicitudesInferiores(collection, minimoSolicitudes);
        System.out.println("\n----------------------------------------------------------------------\n");
        
    }
}
