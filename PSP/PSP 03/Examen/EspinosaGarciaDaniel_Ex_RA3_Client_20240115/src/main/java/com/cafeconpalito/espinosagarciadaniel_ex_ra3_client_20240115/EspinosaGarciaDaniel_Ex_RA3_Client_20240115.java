/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.cafeconpalito.espinosagarciadaniel_ex_ra3_client_20240115;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt207
 */
public class EspinosaGarciaDaniel_Ex_RA3_Client_20240115 {

    public static void main(String[] args) {

        Socket servidor = null;
        DataInputStream bufferDatosEntrada = null;
        DataOutputStream bufferDatosSalida = null;
        Scanner sc = new Scanner(System.in);

        //Inicializo las conexionas a nulo dentro del TRY para que se cierren solas al salir
        try {

            String server_ip = "";
            int puerto = 0;

            boolean comprobar = false;
            //IP SERVER
            do {
                System.out.println("Por favor, Introduce la IP o FQDN del servidor:");
                server_ip = sc.nextLine();
                if ("".equals(server_ip)) {
                    //FALTA AÑADIR COMPROBACIONES!
                    System.out.println("Introduce una IP");
                    comprobar = true;
                } else {
                    comprobar = false;
                }

            } while (comprobar);

            //PUERTO SERVER
            do {
                System.out.println("Por favor, Introduce el puerto de escucha del servidor:");
                String aux = sc.nextLine();

                try {
                    puerto = Integer.parseInt(aux);
                    comprobar = false;

                    //FALTA AÑADIR COMPROBACIONES!
                } catch (NumberFormatException e) {

                    System.out.println("el puerto solo admite numeros");
                    comprobar = true;
                }

            } while (comprobar);

            //Parametros para conectar al server
            //Constuimos el Socket con el server
            servidor = new Socket(server_ip, puerto);

            //Inicilizo las conexiones con el server con los parametros de este
            bufferDatosEntrada = new DataInputStream(servidor.getInputStream());
            bufferDatosSalida = new DataOutputStream(servidor.getOutputStream());

            //1
            // Primero el cliente inicia conexión y recibe la bienvenida del servidor
            System.out.println(bufferDatosEntrada.readUTF());

            //LOGUEO
            String user = "";
            String password = "";

            String mensajeServer;
            int numeroIntentos;

            do {
                
                do {

                    //SE PUEDEN AÑADIR MAS COMPROBACIONES
                    System.out.println("Por favor, introduce el usuario:");
                    user = sc.nextLine();

                } while (user.equals(""));

                do {

                    //SE PUEDEN AÑADIR MAS COMPROBACIONES
                    System.out.println("Por favor, introduce la contraseña");
                    password = sc.nextLine();

                } while ("".equals(password));

                //2
                bufferDatosSalida.writeUTF(user);
                bufferDatosSalida.writeUTF(password);

                //3
                mensajeServer = bufferDatosEntrada.readUTF();
                numeroIntentos = bufferDatosEntrada.readInt();

            } while (!"CREDENCIALES CORRECTAS".equals(mensajeServer)&& numeroIntentos !=0);

            System.out.println(bufferDatosEntrada.readUTF());

        } catch (IOException ex) {
            Logger.getLogger(EspinosaGarciaDaniel_Ex_RA3_Client_20240115.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            try {

                //Cerrando los flujos
                if (bufferDatosEntrada != null) {
                    bufferDatosEntrada.close();
                }
                if (bufferDatosSalida != null) {
                    bufferDatosSalida.close();
                }
                //Cerrando Server
                if (servidor != null) {
                    servidor.close();
                }

            } catch (IOException ex) {
                Logger.getLogger(EspinosaGarciaDaniel_Ex_RA3_Client_20240115.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
