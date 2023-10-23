/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.ad_ua2_ejercicio1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author damt207
 */
public class MetodosBBDD {
    
    

    public static boolean comprobarUsuario(Connection con, String usuario) {

        PreparedStatement ps = null;
        ResultSet rs = null;

        // se prepara la sentencia para la BBDD como un String
        String selectCompUsuario = "select username from users where username = ?";

        try {

            //se crear el Statement Con la conexion a la BBDD y el String
            ps = con.prepareStatement(selectCompUsuario);
            //se añade al select el nombre del usuario
            ps.setString(1, usuario);
            //se ejecuta la sentencia y devuelve un resultado
            rs = ps.executeQuery();

            //Es necesario usar el Next Para pasar a la primera Linea de la busqueda
            //una vez en la primera linea podemos obtener la informacion;
            if (rs.next() && usuario.equals(rs.getString(1))) {
                return true;
            }
            return false;

        } catch (SQLException e) {
            //System.err.println("ERROR AL LEER Login Usuario");
            return false;
        }

    }
         
     public static boolean comprobarContrasena(Connection con, String usuario, String contrasena) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String selectComprobarContraseña = "select pass from users where username = ?;";

        try {

            ps = con.prepareStatement(selectComprobarContraseña);
            ps.setString(1, usuario);

            rs = ps.executeQuery();

            if (rs.next() && contrasena.equals(rs.getString(1))) {
                return true;
            }
            
            return false;

        } catch (SQLException e) {
            //System.err.println("ERROR AL LEER Loging");
            return false;
        }

 

    }
    
}
