/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.ad_ua2_tarea1.DB;

import java.sql.*;
import java.util.logging.*;

/**
 *
 * @author damt207
 */
public class ConnectionDB {
    
    //Datos necesarios para configurar la conexión a la base de datos
    private static ConnectionDB instance = null;
    private Connection con = null;
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; // esto por lo que entiendo utiliza el driver que bajamos (el jar)
    static String USER = "";// static final...
    static String PASS = "";//static final...
    static final String BD = "steam_deg"; // nombre de la base de datos
    //la direccion para conectar a la bbdd se le pasa como parametro "BD"

    //IP PARA TRABAJAR EN EL SERVER
    //static final String IP = "192.168.24.16";
    //IP PARA TRABAJAR EN LOCAL
    //static final String IP = "127.0.0.1";
    static final String IP = "localhost";

    public static void setUSER(String USER) {
        ConnectionDB.USER = USER;
    }

    public static void setPASS(String PASS) {
        ConnectionDB.PASS = PASS;
    }

    public static String getUSER() {
        return USER;
    }

    public static String getPASS() {
        return PASS;
    }
    
    

    //Todos los parametros para conectar a la BBDD
    static final String DB_URL = "jdbc:mysql://" + IP + ":3306/" + BD + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    /**
     * 
     */
    private ConnectionDB() throws SQLException{
     
        try {
            Class.forName(JDBC_DRIVER);
            this.con = DriverManager.getConnection(DB_URL, USER,PASS);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * 
     * @return 
     * @throws java.sql.SQLException 
     */
    public static ConnectionDB getInstance() throws SQLException {
        if (instance == null) {
            instance = new ConnectionDB();
        }
        return instance;
    }

    /**
     * 
     * @return 
     */
    public Connection getConnection() {
        return con;
    }

    /**
     * Metodo para desconectar la BBDD
     */
    public void desconectar() {

        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
