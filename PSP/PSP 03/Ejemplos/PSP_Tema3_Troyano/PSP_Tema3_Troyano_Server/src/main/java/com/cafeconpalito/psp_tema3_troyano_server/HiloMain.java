/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.psp_tema3_troyano_server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author damt207
 */
public class HiloMain implements Runnable{

    @Override
    public void run() {
        
        ServerSocket servidor; //escucha del servidor
        final int PUERTO=6666; //puerto de escucha (a partir del 1024)
        
        Socket cliente; // atencion a cliente
        
        System.out.println("Server Escuchando");
        
        try {
            
            //apertura de socket para escuchar a través de un puerto
            servidor = new ServerSocket(PUERTO);
            
            do {
                cliente=servidor.accept(); //aceptamos la conexión de un cliente
                HiloServer h = new HiloServer(cliente); // creamos un hilo de cliente
                Thread t = new Thread(h);
                t.start(); //lanzamos el hilo
            } while (true);
            
            
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    
    
    }
    
    
    
}
