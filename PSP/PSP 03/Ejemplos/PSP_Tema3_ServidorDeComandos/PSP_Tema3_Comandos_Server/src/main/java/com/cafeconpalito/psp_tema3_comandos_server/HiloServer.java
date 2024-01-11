/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.psp_tema3_comandos_server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt207
 */
public class HiloServer implements Runnable {

    String ruta = "./";

    private Socket cliente = null;

    public HiloServer(Socket cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {

        String option;
        boolean salir = true;

        DataInputStream bufferDatosEntrada = null;
        DataOutputStream bufferDatosSalida = null;

        try {

            //Inicilizo las conexiones con el server con los parametros de este
            bufferDatosEntrada = new DataInputStream(cliente.getInputStream());
            bufferDatosSalida = new DataOutputStream(cliente.getOutputStream());

            //
            //TODO LO QUE QUIERAS QUE HAGA LA CONEXION CON EL CLIENTE.
            //
            do {

                //Opcion
                option = bufferDatosEntrada.readUTF();

                switch (option) {
                    case "1":

                        //1
                        bufferDatosSalida.writeUTF(ls());

                        break;
                    case "2":
                        
                        bufferDatosSalida.writeUTF(readFile("text.txt"));
                        
                        break;
                    case "3": //SALIR
                        System.out.println("cliente desconectado");
                        salir = false;
                        break;
                    default:
                        System.out.println("el cliente no sabe lo que hace!");
                }

            } while (salir);

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

                System.out.println("Mensaje Despedida");

            } catch (IOException ex) {
                Logger.getLogger(HiloServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private String ls() {

        String archivos = "";
        File f = new File(ruta);
        String[] lista = f.list();

        for (int i = 0; i < lista.length; i++) {
            archivos = archivos + lista[i] + "\n";
        }

        //System.out.println(txt);
        return archivos;

    }

    private String readFile(String archivo) {

        String lectura = "EL ARCHIVO NO EXISTE";

        File f = new File(ruta + archivo);
        FileReader fr = null;
        BufferedReader br = null;
        
        if (f.exists()) {

            try {
                fr = new FileReader(f);

                lectura = "";
                String aux;
                //bucle para leer linea a linea se necesita introducir un BufferReader se le pasa como parametro el FileReader
                br = new BufferedReader(fr);
                while ((aux = br.readLine()) != null) {
                    //3 envio texto archivo
                    lectura = lectura + aux + "\n";
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(HiloServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(HiloServer.class.getName()).log(Level.SEVERE, null, ex);
            } finally {

                try {
                    if (br != null) {
                        br.close();
                    }
                    if (fr != null) {
                        fr.close();
                    }

                } catch (IOException ex) {
                    Logger.getLogger(HiloServer.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }

        return lectura;
    }

}
