/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.servidor_numero_secreto;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ramiro
 */
public class HiloServer implements Runnable {

    private Socket cliente;
    private int numAleat;

    public HiloServer(Socket cliente) {
        this.cliente = cliente;
        numAleat = (int) (Math.random() * 100 + 1);
    }

    @Override
    public void run() {
        DataInputStream bufferDatosEntrada = null;
        DataOutputStream bufferDatosSalida = null;

        try {

            //Inicilizo las conexiones con el server con los parametros de este
            bufferDatosEntrada = new DataInputStream(cliente.getInputStream());
            bufferDatosSalida = new DataOutputStream(cliente.getOutputStream());

            // ENVIO INSTRUCCIONES
            bufferDatosSalida.writeUTF("Intenta adivinar el múmero secreto. Para ello inserta un número de 1 a 100");

            boolean comprobar = true;
            
            do {
                // 1 ENVIO INFO
                bufferDatosSalida.writeUTF("introduce un numero: ");

                // 2 RECIBO NUMERO
                int numero = bufferDatosEntrada.readInt();

                // 3 ENVIO MENSAJE
                if (numero < numAleat) {
                    bufferDatosSalida.writeUTF("El número es mayor");
                }

                if (numero > numAleat) {
                    bufferDatosSalida.writeUTF("El número es menor");
                }

                if (numero == numAleat) {
                    bufferDatosSalida.writeUTF("¡¡¡¡ACERTASTE!!!!");
                    comprobar = false;
                }

                // 4 ENVIO BOOLEAN
                bufferDatosSalida.writeBoolean(comprobar);

            } while (comprobar);

        } catch (IOException ex) {
            Logger.getLogger(HiloServer.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            try {

                // Cerrando los flujos
                if (bufferDatosEntrada != null) {
                    bufferDatosEntrada.close();
                }
                if (bufferDatosSalida != null) {
                    bufferDatosSalida.close();
                }
                // Cerrando cliente
                if (cliente != null) {
                    cliente.close();
                }
                
            } catch (IOException ex) {
                Logger.getLogger(HiloServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
