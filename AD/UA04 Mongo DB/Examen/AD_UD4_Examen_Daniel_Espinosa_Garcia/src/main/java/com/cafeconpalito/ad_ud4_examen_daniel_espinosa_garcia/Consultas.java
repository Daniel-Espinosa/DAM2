/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.ad_ud4_examen_daniel_espinosa_garcia;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Sorts.*;
import org.bson.Document;

/**
 *
 * @author Daniel Espinosa Garcia
 */
public class Consultas {
    
    
    
    public static double mediaEdadClientes(MongoCollection collection) {

        int aux = 0;
        int sumaEdad = 0;

        FindIterable<Document> documents = collection.find( gt("Age",0));
        MongoCursor<Document> cursor = documents.iterator();
        while (cursor.hasNext()) {
            aux++;
            sumaEdad+= cursor.next().getInteger("Age");
        }

        return sumaEdad/aux;
    }
    
    
    public static void clientesNivelMenbresia4oMayor(MongoCollection collection) {
        
        FindIterable<Document> documents = collection.find(and(gte("Level_of_membership",4),gt("Age",35)));
        
        MongoCursor<Document> cursor = documents.iterator();
        while (cursor.hasNext()) {
            //Document aux = cursor.next();
            System.out.println(cursor.next());
        }
        
    }
    
    public static void tiempoCompraClienteMas15MinOrdenAlfabetico(MongoCollection collection) {
        
        FindIterable<Document> documents = collection.find(gt("Time_of_purchase",15)).sort(ascending("Name"));
        
        MongoCursor<Document> cursor = documents.iterator();
        while (cursor.hasNext()) {
            //Document aux = cursor.next();
            System.out.println("Nombre: " + cursor.next().getString("Name"));
        }
        
    }
    
    public static void datosDeClienteConMebresiaBlack(MongoCollection collection) {
        
        FindIterable<Document> documents = collection.find(eq("Membership_card","Black"));
        
        MongoCursor<Document> cursor = documents.iterator();
        while (cursor.hasNext()) {
            //Document aux = cursor.next();
            System.out.println(cursor.next());
        }
        
    }
    
    public static void insertarCliente(MongoCollection collection){
        
        Document doc = new Document();

        doc.append("Member_ID", 11);
        doc.append("Name", "Daniel Espinosa Garcia");
        doc.append("Membership_card", "Black");
        doc.append("Age", 40);
        doc.append("Time_of_purchase", 18);
        doc.append("Level_of_membership", 4);
        doc.append("Address", "Santander");

        collection.insertOne(doc);

        System.out.println("Insercion Realizada");
        
    }
    
    
    public static void listarTodosLosClientes(MongoCollection collection){
        
        FindIterable<Document> documents = collection.find(gt("Age",0));
        
        MongoCursor<Document> cursor = documents.iterator();
        while (cursor.hasNext()) {
            //Document aux = cursor.next();
            System.out.println(cursor.next());
        }
        
    }
    
    
    
    
}
