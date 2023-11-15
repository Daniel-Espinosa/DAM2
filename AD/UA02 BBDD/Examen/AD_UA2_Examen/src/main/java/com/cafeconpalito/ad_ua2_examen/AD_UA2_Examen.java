/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.cafeconpalito.ad_ua2_examen;

import java.util.Scanner;

/**
 *
 * @author damt207
 */
public class AD_UA2_Examen {

    public static void main(String[] args) {

        //inicio la conexion
        conecctionDB conexion = new conecctionDB();
        metodosBBDD.setCon(conexion.conectar());

        Scanner scNum = new Scanner(System.in);
        Scanner scTxt = new Scanner(System.in);

        boolean salir = false;

        while (!salir) {

            System.out.println("Selecciona una Opcion");
            System.out.println("1. Consultar datos de los clientes");
            System.out.println("2. Consultar datos de los Comerciales");
            System.out.println("3. Consultar datos de los pedidos. ordenados por fecha mas reciente");
            System.out.println("4. Listado de los clientes con sus pedidos realizados y los datos de los comerciales asociados al pedido");
            System.out.println("5. Insertar Pedido");
            System.out.println("6. Confirmar cambios");
            System.out.println("7. Salir");

            String opt = scTxt.nextLine();

            switch (opt) {
                case "1":
                    metodosBBDD.datosClientes();
                    break;

                case "2":
                    metodosBBDD.datosComerciales();
                    break;

                case "3":
                    metodosBBDD.datosPedido();
                    break;

                case "4":
                    metodosBBDD.datosClientePedidoComercial();
                    break;
                case "5":
                    metodosBBDD.insertarPedido();
                    break;
                case "6":
                    metodosBBDD.confirmarCambios();
                    break;
                case "7":
                    System.out.println("Adios!");
                    salir = true;
                    break;

                default:
                    System.out.println("Selecciona Una Opcion valida");
            }

            System.out.println("");
        }

    }
}
