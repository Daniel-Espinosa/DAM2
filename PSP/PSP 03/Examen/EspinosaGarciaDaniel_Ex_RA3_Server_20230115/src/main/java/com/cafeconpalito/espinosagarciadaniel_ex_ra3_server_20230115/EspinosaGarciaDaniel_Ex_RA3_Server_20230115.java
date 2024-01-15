/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cafeconpalito.espinosagarciadaniel_ex_ra3_server_20230115;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt207
 */
public class EspinosaGarciaDaniel_Ex_RA3_Server_20230115 {
    
    public static final String USER = "DAMDaniel";
    public static final String PASSWORD = "Espinosa";

    public static void main(String[] args) {
        ServerSocket servidor; //escucha del servidor
        final int PUERTO = 9666; //puerto de escucha (a partir del 1024)
        Socket cliente; // atencion a cliente
        
        int numeroClientes = 0;

        System.out.println("Server Iniciado");

        try {

            //apertura de socket para escuchar a través de un puerto
            servidor = new ServerSocket(PUERTO);

            do {

                numeroClientes ++;
                
                cliente = servidor.accept(); //aceptamos la conexión de un cliente

                HiloServer h = new HiloServer(cliente, numeroClientes); // creamos un hilo de cliente

                Thread t = new Thread(h);

                t.start(); //lanzamos el hilo

            } while (true);

        } catch (IOException ex) {

            Logger.getLogger(EspinosaGarciaDaniel_Ex_RA3_Server_20230115.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}
