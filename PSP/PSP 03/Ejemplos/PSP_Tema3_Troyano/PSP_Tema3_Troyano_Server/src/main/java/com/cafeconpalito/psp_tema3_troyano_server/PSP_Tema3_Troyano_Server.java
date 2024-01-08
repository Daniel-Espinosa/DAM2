/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.cafeconpalito.psp_tema3_troyano_server;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt207
 */
public class PSP_Tema3_Troyano_Server {

    public static void main(String[] args) {

        HiloMain h = new HiloMain();
        Thread t = new Thread(h);
        t.start(); //lanzamos el hilo

        boolean salir = true;

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Que quieres hacer");
            System.out.println("\t1. Enviar Mensajes a los clientes conectados!");
            System.out.println("\t2. Apagar Server");
            String opt = sc.nextLine();

            switch (opt) {
                case "1":
                    HiloServer.enviarMensaje = true;
                    System.out.println("Mensaje enviado, ¡Hakuna Matata!");
                    
                    break;


                case "2":
                    System.out.println("Adios!");
                    System.exit(0);
                    salir = false;
                    
                    break;
                default:
                    System.err.println("Selecciona una opcion valida");
            }

        } while (salir);

    }
}
