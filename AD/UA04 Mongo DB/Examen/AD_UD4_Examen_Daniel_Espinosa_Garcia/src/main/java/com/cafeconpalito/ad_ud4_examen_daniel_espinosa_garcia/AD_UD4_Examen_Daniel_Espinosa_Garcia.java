/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cafeconpalito.ad_ud4_examen_daniel_espinosa_garcia;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

/**
 *
 * @author Daniel Espinosa Garcia
 */
public class AD_UD4_Examen_Daniel_Espinosa_Garcia {

    public static void main(String[] args) {
        
        MongoCollection<Document> collection = ConexionMongoDB.getInstance().getMongoDataBase().getCollection("coffe_shop");
        
        
        System.out.println("PUNTO 3\n");
        
        System.out.println("------------------------------------------------------------------------");
        System.out.println("\nApartado A\n");
        System.out.println("La media de edad de los clientes es: " + Consultas.mediaEdadClientes(collection));
        
        System.out.println("------------------------------------------------------------------------");
        System.out.println("\nApartado B\n");
        System.out.println("Clientes con nivel de menbresia  mayor o igual a 4 \n y edad mayor que 35\n");
        Consultas.clientesNivelMenbresia4oMayor(collection);
        
        System.out.println("------------------------------------------------------------------------");
        System.out.println("\nApartado E\n");
        System.out.println("Nombre de los clientes que han comprado mas de 15 minutos. ordenado alfabeticamente\n");
        Consultas.tiempoCompraClienteMas15MinOrdenAlfabetico(collection);
        
        System.out.println("------------------------------------------------------------------------");
        System.out.println("\nApartado F\n");
        System.out.println("Datos de los clientes con tarjeta de membresia Black\n");
        Consultas.datosDeClienteConMebresiaBlack(collection);
        
        
        System.out.println("------------------------------------------------------------------------");
        System.out.println("PUNTO 5\n");
        
        //COMENTO ESTA LINEA PARA QUE NO INSERTA MAS VECES A DANIEL
        //Consultas.insertarCliente(collection);
        
        System.out.println("------------------------------------------------------------------------");
        System.out.println("\nListando Todos los Clientes\n");
        Consultas.listarTodosLosClientes(collection);
        
        
        //Cierro la conexión
        ConexionMongoDB.getInstance().desconectar();
        
        
    }
}
