/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.psp_tema3_troyano_server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt207
 */
public class HiloServer implements Runnable {

    Socket cliente = null;
    DataInputStream bufferDatosEntrada = null;
    DataOutputStream bufferDatosSalida = null;
    
    static boolean enviarMensaje = false;

    public static void setEnviarMensaje(boolean enviarMensaje) {
        HiloServer.enviarMensaje = enviarMensaje;
    }


    public HiloServer(Socket cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {

        try {

            //Inicilizo las conexiones con el server con los parametros de este
            bufferDatosEntrada = new DataInputStream(cliente.getInputStream());
            bufferDatosSalida = new DataOutputStream(cliente.getOutputStream());

            cliente.setSoLinger(true, 10);

            //Recibo la info del usuario
            System.out.println("\nCliente Conectado estos son sus Datos");
            System.out.println(bufferDatosEntrada.readUTF() + "\n");

            //Mantengo la conex
            do {
                
                if (enviarMensaje) {
                    System.out.println("EnviarMensaje a True;");
                    bufferDatosSalida.writeBoolean(true);
                    
                    enviarMensaje = false;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(HiloServer.class.getName()).log(Level.SEVERE, null, ex);
                }

            } while (true);

        } catch (IOException ex) {
            System.err.println(ex.getMessage());

        } finally {

            try {

                //Cerrando los flujos
                if (bufferDatosEntrada != null) {
                    bufferDatosEntrada.close();
                }
                if (bufferDatosSalida != null) {
                    bufferDatosSalida.close();
                }
                //Cerrando cliente
                if (cliente != null) {
                    cliente.close();
                }

                System.out.println("Adios Cliente");

            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }

    }

}
