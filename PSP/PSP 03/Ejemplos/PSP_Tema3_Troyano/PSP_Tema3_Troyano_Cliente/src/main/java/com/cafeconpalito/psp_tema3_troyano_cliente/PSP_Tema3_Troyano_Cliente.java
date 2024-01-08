/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.cafeconpalito.psp_tema3_troyano_cliente;

/**
 *
 * @author damt207
 */
public class PSP_Tema3_Troyano_Cliente {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        HiloCliente h = new HiloCliente();
        Thread t = new Thread(h);
        t.start(); //lanzamos el hilo

    }
}
