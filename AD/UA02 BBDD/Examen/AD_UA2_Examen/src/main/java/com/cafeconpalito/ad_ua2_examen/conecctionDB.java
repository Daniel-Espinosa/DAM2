/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.ad_ua2_examen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt207
 */
public class conecctionDB {
    
    //Datos necesarios para configurar la conexión a la base de datos
    private static Connection con;

    public static Connection getCon() {
        return con;
    }
    
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; // esto por lo que entiendo utiliza el driver que bajamos (el jar)
    static final String USER = "daniel"; 
    static final String PASS = "1234";
    static final String BD = "ventas"; // nombre de la base de datos
    //la direccion para conectar a la bbdd se le pasa como parametro "BD"
    
    //IP PARA TRABAJAR EN EL SERVER
    //static final String IP = "192.168.24.16";

    //IP PARA TRABAJAR EN LOCAL
    //static final String IP = "127.0.0.1";
    static final String IP = "localhost";
    
    //Todos los parametros para conectar a la BBDD
    static final String DB_URL = "jdbc:mysql://"+ IP +":3306/"+BD+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; 
       
    
    /**
     * Metodo para crear una conexion a la BBDD
     * @return Objeto de la clase Connection
     */
    public Connection conectar (){
        
        try {

            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            if (con != null) {
                System.out.println("conexion realizada");
            }
            
        } catch (SQLException ex) {
            System.err.println("problemas de conexión\n" + ex.toString());
        } catch (ClassNotFoundException e) {
            System.err.println(e.toString());
        }
        
        return con;
        
    }

    /**
     * Metodo para desconectar la BBDD
     */
    public void desconectar(){
        
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(conecctionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
