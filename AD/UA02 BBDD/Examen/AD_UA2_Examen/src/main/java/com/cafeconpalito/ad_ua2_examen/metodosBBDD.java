/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.ad_ua2_examen;

import java.sql.Connection;
import java.sql.*;

/**
 *
 * @author damt207
 */
public class metodosBBDD {
    
    private static Connection con;
    
    public static void setCon(Connection con) {
        metodosBBDD.con = con;
    }
 
    public static void datosClientes() {

        System.out.println("\nListando Todos los datos de los Clientes ");
        PreparedStatement ps = null;
        ResultSet rs = null;

        String select = "select * from cliente";

        try {

            ps = con.prepareStatement(select);

            rs = ps.executeQuery();

            //si encuentra resultado de cliente devuelve los datos
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " +rs.getString(3) 
                            + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6));
            }

            
        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }

    }
    
    public static void datosComerciales() {

        System.out.println("\nListando Todos los datos de los Comerciales ");
        PreparedStatement ps = null;
        ResultSet rs = null;

        String select = "select * from comercial";

        try {

            ps = con.prepareStatement(select);

            rs = ps.executeQuery();

            //si encuentra resultado de cliente devuelve los datos
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " +rs.getString(3) 
                            + " " + rs.getString(4) + " " + rs.getString(5));
            }

        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }

    }

    public static void datosPedido() {

        System.out.println("\nListando Todos los datos de los pedidos ordenados por fecha mas proxima ");
        PreparedStatement ps = null;
        ResultSet rs = null;

        String select = "select * from pedido order by fecha desc";

        try {

            ps = con.prepareStatement(select);

            rs = ps.executeQuery();

            //si encuentra resultado de cliente devuelve los datos
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " +rs.getString(3) 
                            + " " + rs.getString(4) + " " + rs.getString(5));
            }

            
        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }

    }
    
    public static void datosClientePedidoComercial() {

        System.out.println("\nListado de los clientes con sus pedidos realizados y los datos de los comerciales asociados al pedido ");
        PreparedStatement ps = null;
        ResultSet rs = null;

        String select = "select cliente.id, cliente.nombre, cliente.apellido1 , cliente.apellido2, ciudad, categoría , pedido.id, total , fecha , comercial.nombre , comercial.apellido1  , comercial.apellido2 , comercial.comisión from cliente inner join pedido on cliente.id = id_cliente inner join comercial on comercial.id = id_comercial";

        try {

            ps = con.prepareStatement(select);

            rs = ps.executeQuery();

            //si encuentra resultado de cliente devuelve los datos
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " +rs.getString(3) 
                            + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6 )
                + " " + rs.getString(7)+ " " + rs.getString(8)+ " " + rs.getString(9)
                        + " " + rs.getString(10)+ " " + rs.getString(11)+ " " + rs.getString(12)
                        + " " + rs.getString(13)
                );
            }

            
        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }

    
    }
    
    
     public static void insertarPedido() {

        System.out.println("\nInserta pedido");
        PreparedStatement ps = null;
        ResultSet rs = null;

        
        String insert = "insert into pedido(total,fecha,id_cliente,id_comercial) values (?,?,?,?)";

        
        try {
            con.setAutoCommit(false);

            ps = con.prepareStatement(insert);

            ps.setDouble(1, 3000.5);
            ps.setString(2, "2023-11-16");
            ps.setInt(3, 1);
            ps.setInt(4, 1);
            
            System.out.println("Pedido insertado: total = 3000.5 fecha = 2023-11-16 cliente = 1 comercial = 1");
            
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getSQLState());
            System.err.println("Error en el select");
        }
    }
    
    
    public static void confirmarCambios() {

        System.out.println("\nCambios Guardados");
        
        try {
            con.commit();
            con.setAutoCommit(true);
            
        } catch (SQLException ex) {
            System.out.println(ex.getSQLState());
            System.err.println("Error en el select");
        }
    }
    
    
    
    
    
    

}
