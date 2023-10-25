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
     
        //1       
        //metodosBBDD.ProductosListarNombre();
        //2
        //metodosBBDD.ProductosListarNombrePrecio();
        //3
        //metodosBBDD.ProductosListarTodasColumnas();
        //4
        //metodosBBDD.ProductosListarNombrePrecioEuDol();
        //5
        //metodosBBDD.ProductosListarNombrePrecioEuDol_ModNombreTabla();
        //6
        //metodosBBDD.ProductosListarNombreMayusPrecios();
        //7
        metodosBBDD.ProductorListarNombreMinusPrecios();
        //8
        //metodosBBDD.FabricantesNombreDosPrimerosCaracteres();
        //*
        //metodosBBDD.ProductosListarNombrePreciosRedondeado();
        //10
        //metodosBBDD.ProductosListarNombrePreciosSinDecimal();
    }
    
}
