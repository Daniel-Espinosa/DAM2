/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.cafeconpalito.cliente_numero_secreto;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ramiro
 */
public class Cliente_numero_secreto {

    public static void main(String[] args) {
        Socket servidor = null;
        DataInputStream bufferDatosEntrada = null;
        DataOutputStream bufferDatosSalida = null;
        Scanner sc = new Scanner(System.in);

        try {

            //Parametros para conectar al server
            final String SERVER_IP = "localhost";
            final int PUERTO = 6666;

            //Constuimos el Socket con el server
            servidor = new Socket(SERVER_IP, PUERTO);

            //Inicializo las conexiones con el server con los parametros de este
            bufferDatosEntrada = new DataInputStream(servidor.getInputStream());
            bufferDatosSalida = new DataOutputStream(servidor.getOutputStream());
            
            // RECIBO INSTRUCCIONES
            System.out.println(bufferDatosEntrada.readUTF());

            boolean comprobar = true;
            do {
                // 1 RECIBO INFO
                System.out.println(bufferDatosEntrada.readUTF());

                // 2 ENVIO NUMERO
                bufferDatosSalida.writeInt(sc.nextInt());

                // 3 RECIBO MENSAJE
                System.out.println(bufferDatosEntrada.readUTF());

                // 4 RECIBO BOOLEAN
                comprobar = bufferDatosEntrada.readBoolean();

            } while (comprobar);

        } catch (IOException ex) {
            Logger.getLogger(Cliente_numero_secreto.class.getName()).log(Level.SEVERE, null, ex);

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
                Logger.getLogger(Cliente_numero_secreto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
