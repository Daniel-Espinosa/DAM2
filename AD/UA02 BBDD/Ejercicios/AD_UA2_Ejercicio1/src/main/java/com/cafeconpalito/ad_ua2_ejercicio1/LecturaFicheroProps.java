/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.ad_ua2_ejercicio1;

import java.io.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt207
 */
public class LecturaFicheroProps {
    
    public static void lecturaProps(){
    
        try {
            Properties properties = new Properties();
            
            properties.load(new FileInputStream(new File("configuracion.props")));

            System.out.println(properties.get("DB"));
            System.out.println(properties.get("SERVER"));
            System.out.println(properties.get("PORT"));
            System.out.println(properties.get("USER"));
            System.out.println(properties.get("PASSWORD"));
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LecturaFicheroProps.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LecturaFicheroProps.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    
}
