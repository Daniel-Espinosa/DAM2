/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.cafeconpalito.pruebaconeccionbbdd;

/**
 *
 * @author damt207
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Genero un objeto de tipo Coneccion.
        conecctionDB conexion = new conecctionDB();
        
        //Seteo la conexion en los metodos para no tener que volver a llamarla (es una trampilla)
        metodosBBDD.setCon(conexion.conectar());
        
        //Lista los productos.       
        metodosBBDD.listarProductos();
        
        metodosBBDD.listarProductosNombrePrecio();
        
    }
    
}
