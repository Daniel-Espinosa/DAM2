/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cafeconpalito.servidorbasico;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt207
 */
public class ServidorBasico {

    public static void main(String[] args) {
        try {
            ServerSocket servidor; // Socket de escucha del servidor
            Socket cliente; // socket para atender al cliente
            
            int numCliente = 0; //Contador clientes
            
            final int PUERTO = 6666; // puerto de escucha
            
            
            System.out.println("Soy el server y empiezo a escuchar peticiones por el puerto: " + PUERTO);
            
            
            //Apertura Socket de escucha a traves de un puerto
            servidor = new ServerSocket(PUERTO);
            
            
            do {
                
                numCliente++;
                
                cliente = servidor.accept();
                System.out.println("\tllega el cliente: " + numCliente);
                
                //SE DECLARAN LOS CANALES DE COMUNICACION CON EL CLIENTE.
                DataInputStream bufferDatosEntrada = new DataInputStream(cliente.getInputStream()); // Entrada / Lectura
                DataOutputStream bufferDatosSalida = new DataOutputStream(cliente.getOutputStream()); // Salida / Escritura
                
                //A Partir de aqui se establece el protocolo de comunicacion con el cliente.
                System.out.println("Enviando datos al Cliete");
                bufferDatosSalida.writeUTF("Usted es el cliente " + numCliente);
                
                
                
                bufferDatosEntrada.close();
                bufferDatosSalida.close();
                cliente.close();
                
            } while (true);
            
            
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(ServidorBasico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
}
