/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.ad_ua2_tarea1.model;

import com.cafeconpalito.ad_ua2_tarea1.DB.ConnectionDB;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author damt207
 */
public class ConsultasDB {
    
    
    /**
     * 
     * @return 
     */
    public static ArrayList<String[]> juego(){
       
        ArrayList<String[]> lista = new ArrayList<>();
        Connection con;

        PreparedStatement ps = null;
        ResultSet rs = null;

        String select = "select * from juego";

        try {
            
            con =  ConnectionDB.getInstance().getConnection();

            ps = con.prepareStatement(select);

            rs = ps.executeQuery();

            //si encuentra resultado del reto de ese jugador busca la info
            while (rs.next()) {
                String[] e = {rs.getString(1),rs.getString(2),rs.getString(3)};
                lista.add(e);
                //System.out.println(rs.getString(1) + " " +rs.getString(2) + " " + rs.getString(3));
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }
       
       return lista;
    }    
    
    public static ArrayList<String[]> jugador(){
       
        ArrayList<String[]> lista = new ArrayList<>();
        Connection con;

        PreparedStatement ps = null;
        ResultSet rs = null;

        String select = "select * from jugador";

        try {
            
            con =  ConnectionDB.getInstance().getConnection();

            ps = con.prepareStatement(select);

            rs = ps.executeQuery();

            //si encuentra resultado del reto de ese jugador busca la info
            while (rs.next()) {
                String[] e = {rs.getString(1),rs.getString(2),rs.getString(3)};
                lista.add(e);
                //System.out.println(rs.getString(1) + " " +rs.getString(2) + " " + rs.getString(3));
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }
       
       return lista;
    }    
    
    public static ArrayList<String[]> jugadorSesionJuego(){
       
        ArrayList<String[]> lista = new ArrayList<>();
        Connection con;

        PreparedStatement ps = null;
        ResultSet rs = null;

        String select = "select alias,juego.nombre,fecha from jugador inner join sesion using (id_jugador) inner join juego using (id_juego)";

        try {
            
            con =  ConnectionDB.getInstance().getConnection();

            ps = con.prepareStatement(select);

            rs = ps.executeQuery();

            //si encuentra resultado del reto de ese jugador busca la info
            while (rs.next()) {
                String[] e = {rs.getString(1),rs.getString(2),rs.getString(3)};
                lista.add(e);
                //System.out.println(rs.getString(1) + " " +rs.getString(2) + " " + rs.getString(3));
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de conversion de numero");
        } catch (SQLException ex) {
            System.err.println("Error en el select");
        }
       
       return lista;
    }
    
}
