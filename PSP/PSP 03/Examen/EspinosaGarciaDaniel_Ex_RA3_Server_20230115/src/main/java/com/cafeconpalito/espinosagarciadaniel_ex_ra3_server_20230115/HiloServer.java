/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.espinosagarciadaniel_ex_ra3_server_20230115;

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

    private Socket cliente = null;

    int numeroCliente;
    int numeroIntentos = 3;
    
    boolean tryLogin = false;

    public HiloServer(Socket cliente, int numeroCliente) {
        this.cliente = cliente;
        this.numeroCliente = numeroCliente;

    }

    @Override
    public void run() {
        DataInputStream bufferDatosEntrada = null;
        DataOutputStream bufferDatosSalida = null;

        try {

            //Inicilizo las conexiones con el server con los parametros de este
            bufferDatosEntrada = new DataInputStream(cliente.getInputStream());
            bufferDatosSalida = new DataOutputStream(cliente.getOutputStream());

            //1
            // Primero el cliente inicia conexión y recibe la bienvenida del servidor
            bufferDatosSalida.writeUTF(
                    "*******************************\n"
                    + "Examen RA3 - Servidor Login\n"
                    + "por Daniel Espinosa Garcia\n"
                    + "*******************************\n"
                    + "Eres el cliente Nº " + numeroCliente
                    + "\nPor favor introduce usuario y contraseña para acceder\n");

            //LOGUEO

            String user;
            String password;
            String mensajeServer;
            
            do {
                numeroIntentos --;
                //2
                user = bufferDatosEntrada.readUTF();
                password = bufferDatosEntrada.readUTF();
                                
                //3
                if (user.equals(EspinosaGarciaDaniel_Ex_RA3_Server_20230115.USER) && password.equals(EspinosaGarciaDaniel_Ex_RA3_Server_20230115.PASSWORD)) {
                    mensajeServer = "CREDENCIALES CORRECTAS";
                } else {
                    mensajeServer = ("Credenciales incorrectas,"
                            + " vuelve a intentarlo te quedan " + numeroIntentos +  " oportunidades");
                }
                
                bufferDatosSalida.writeUTF(mensajeServer);
                bufferDatosSalida.writeInt(numeroIntentos);

                
            } while (!"CREDENCIALES CORRECTAS".equals(mensajeServer)&& numeroIntentos != 0);

            
            if (mensajeServer.equals("CREDENCIALES CORRECTAS")) {
                
                bufferDatosSalida.writeUTF("BIENVENIDO AL SERVIDOR");
            
            }else{
                bufferDatosSalida.writeUTF("NO SE PUDO CONECTAR AL SERVIDOR");
            
            }
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(HiloServer.class.getName()).log(Level.SEVERE, null, ex);

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

            } catch (IOException ex) {
                Logger.getLogger(HiloServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
