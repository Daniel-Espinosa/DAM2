/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.cafeconpalito.ad_ud4_superficiescultivo;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

/**
 *
 * @author Cafe Con Palito
 */
public class AD_UD4_SuperficiesCultivo {

    public static void main(String[] args) {

        MongoCollection<Document> collection = ConexionMongoDB.getInstance().getMongoDataBase().getCollection("cultivo");

        String provincia = "BURGOS";
        String producto = "CENTENO";
        
        System.out.println("\n----------------------------------------------------------------------\n");
        
        System.out.println("CONSULTA 1");
        System.out.println("\tMétodo que muestre los datos del tipo de cultivo y la\n"
                + "\tsuperficie de cultivo de una provincia determinada ordenadas\n"
                + "\tascendentemente por superficie.\n");
        System.out.println("Datos de tipo de cultivo de la provincia de " + provincia + "\n");
        Consultas.cultivoProvincia(collection, provincia);
        System.out.println("\n----------------------------------------------------------------------\n");

        System.out.println("CONSULTA 2");
        System.out.println("\tMétodo que devuelve la lista con el nombre de las 9 provincias\n"
                + "\tincluidas en la colección.\n");
        System.out.println("Nombres de las provincias\n");
        for (String nombreProvincia : Consultas.nombreProvincias(collection)) {
            System.out.println(nombreProvincia);
        }
        System.out.println("\n----------------------------------------------------------------------\n");

        System.out.println("CONSULTA 3");
        System.out.println("\tMétodo que devuelve la superficie de cultivo en una provincia\n"
                + "\tpara un producto concreto\n");
        int aux = Consultas.superficieProvinciaProducto(collection, provincia, producto);
        System.out.println("La superficies de cultivo en la provincia de " + provincia + " del cultivo " + producto +" son: " + aux );
        System.out.println("\n----------------------------------------------------------------------\n");

        ConexionMongoDB.getInstance().desconectar();
        
    }
}
