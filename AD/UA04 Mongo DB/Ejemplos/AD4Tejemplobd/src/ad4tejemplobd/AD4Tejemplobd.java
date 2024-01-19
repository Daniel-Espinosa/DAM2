/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad4tejemplobd;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author msola
 */
public class AD4Tejemplobd {
    
    public static MongoClient conecta(){
        String url= "mongodb+srv://marina:marina@cluster0.8fdxw.mongodb.net/ejemplobd?retryWrites=true&w=majority";
        MongoClientURI uri =new MongoClientURI(url);
        MongoClient mongoclient = new MongoClient(uri);   
        System.out.println("Devuelvo MongoClient");
        return mongoclient;
    }
    
    public static MongoCollection conectaCollectionBD(MongoClient mongoclient){
        MongoDatabase database= mongoclient.getDatabase("ejemplobd");
        MongoCollection collection = database.getCollection("clientes");
        System.out.println("Devuelvo la collection");
        return collection;
    }
    
    public static void desconecta(MongoClient mongoclient){
        mongoclient.close();
    }
    
    public static void insertOneDocument(Cliente cliente, MongoCollection collection){
        Document doc = new Document();
        doc.append("nombre", cliente.getNombre());
        doc.append("f_nac", cliente.getF_nac());
        doc.append("calle", cliente.getCalle());
        doc.append("bono_regalo", cliente.getBono_regalo());
        collection.insertOne(doc);
        System.out.println("Documento insertado");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MongoClient mongoclient= conecta();
        MongoCollection collection = conectaCollectionBD(mongoclient);
        
        Cliente cliente = new Cliente();
        cliente.setNombre("Miguel");
        cliente.setF_nac(tools.parseUtilDate("2000-01-01"));
        cliente.setCalle("Av Primero Mayo, 1");
        cliente.setBono_regalo(200);
        
        insertOneDocument(cliente, collection);
    }
    
}
