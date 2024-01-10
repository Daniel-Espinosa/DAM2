/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cafeconpalito.clientebasico;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt207
 */
public class ClienteBasico {

    public static void main(String[] args) {
        try {
            String direccion; // La IP direccion de conexion
            Socket servidor;
            final int PUERTO = 6666;
            
            System.out.println("Soy el cliente e intento conectarme");
            
            //Direccion de conexion;
            direccion = "127.0.0.1";
            servidor = new Socket(direccion, PUERTO);
            
            DataInputStream bufferDatosEntrada = new DataInputStream(servidor.getInputStream());
            DataOutputStream bufferDatosSalida = new DataOutputStream(servidor.getOutputStream());
            
            //SE establece el protocolo de comunicacion con el servidor
            String mensajeServer = bufferDatosEntrada.readUTF();
            System.out.println(mensajeServer);
            
            bufferDatosEntrada.close();
            bufferDatosSalida.close();
            servidor.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ClienteBasico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
