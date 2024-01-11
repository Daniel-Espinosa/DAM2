/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.cafeconpalito.psp_tema3_comandos_cliente;

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
public class PSP_Tema3_Comandos_Cliente {

    public static void main(String[] args) {
        System.out.println("Mensaje Inicio Cliente");

        Socket servidor = null;
        DataInputStream bufferDatosEntrada = null;
        DataOutputStream bufferDatosSalida = null;

        Scanner sc = new Scanner(System.in);

        String option;
        boolean salir = true;

        //Inicializo las conexionas a nulo dentro del TRY para que se cierren solas al salir
        try {

            //Parametros para conectar al server
            final String SERVER_IP = "localhost"; // "127.0.0.1"
            final int PUERTO = 6666;

            //Constuimos el Socket con el server
            servidor = new Socket(SERVER_IP, PUERTO);

            //Inicilizo las conexiones con el server con los parametros de este
            bufferDatosEntrada = new DataInputStream(servidor.getInputStream());
            bufferDatosSalida = new DataOutputStream(servidor.getOutputStream());

            //
            // TODO LO QUE QUIERAS HACER CON EL SERVIDOR
            //
            do {

                System.out.println("Que quieres hacer:");
                System.out.println("1. Listar Archivos");
                System.out.println("2. Leer Archivo");
                System.out.println("3. Salir");

                option = sc.nextLine();

                //Opcion
                bufferDatosSalida.writeUTF(option);

                switch (option) {
                    case "1":
                        
                        //1
                        System.out.println(bufferDatosEntrada.readUTF());

                        break;
                    case "2":

                        System.out.println(bufferDatosEntrada.readUTF());
                        
                        break;
                    case "3": // SALIR
                        System.out.println("Adios!");
                        salir = false;
                        break;
                    default:
                        System.out.println("Introduce una opcion valida");
                }

            } while (salir);

        } catch (IOException ex) {
            Logger.getLogger(PSP_Tema3_Comandos_Cliente.class.getName()).log(Level.SEVERE, null, ex);

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
                Logger.getLogger(PSP_Tema3_Comandos_Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
