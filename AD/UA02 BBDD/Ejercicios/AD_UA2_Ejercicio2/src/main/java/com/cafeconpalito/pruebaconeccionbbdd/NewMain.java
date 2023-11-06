/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.cafeconpalito.pruebaconeccionbbdd;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            //metodosBBDD.ProductorListarNombreMinusPrecios();
            //8
            //metodosBBDD.FabricantesNombreDosPrimerosCaracteres();
            //9
            //metodosBBDD.ProductosListarNombrePreciosRedondeado();
            //10
            //metodosBBDD.ProductosListarNombrePreciosSinDecimal();
            //11
            //metodosBBDD.ProductosListarIdentificadorFabricantes();
            //12
            //metodosBBDD.ProductosListarIdentificadorFabricantesSinRepetidos();
            //13
            //metodosBBDD.FabricanteListarFabricantesOrdenAscendente();
            //14
            //metodosBBDD.FabricanteListarFabricantesOrdenDescendente();
            //15
            //metodosBBDD.ProductoListarNombreProductoOrdenNombreAscPrecioDesc();
            //16
            //metodosBBDD.ProductoAddProducto();
            //17
            //metodosBBDD.FabricanteAddFabricante();
            //18
            //metodosBBDD.ProductoModificarFabricante();
            //19
            //metodosBBDD.FabricanteBorrarFabricantesEmpiezanA();

    }

}
