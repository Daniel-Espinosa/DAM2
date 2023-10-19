/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.pruebaconeccionbbdd;

import java.sql.*;

/**
 *
 * @author damt207
 */
public class metodosBBDD {

    /**
     * 1. Lista el nombre de todos los productos que hay en la tabla producto
     */
    private static Connection con;

    public static void setCon(Connection con) {
        metodosBBDD.con = con;
    }
    
    
    /**
     * 1. Lista el nombre de todos los productos que hay en la tabla producto.
     */
    public static void listarProductos() {
        
        System.out.println("\nListando Todo de productos (Select *)");
        PreparedStatement ps = null;
        ResultSet rs = null;

        String select = "select * from producto";

        try {

            ps = con.prepareStatement(select);

            rs = ps.executeQuery();

            //si encuentra resultado del reto de ese jugador busca la info
            while (rs.next()) {

                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }

    }

    /**
     * Lista los nombres y los precios de todos los productos de la tabla producto
     */
    public static void listarProductosNombrePrecio() {

        System.out.println("\nListando Nombre y Precio de Productos");
        PreparedStatement ps = null;
        ResultSet rs = null;

        String select = "select nombre,precio from producto";
        
        try {

            ps = con.prepareStatement(select);

            rs = ps.executeQuery();

            //si encuentra resultado del reto de ese jugador busca la info
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2));
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }

    }
    
    
}
