/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cafeconpalito.ad_ua2_ejercicio1;

/**
 *
 * @author damt207
 */
public class AD_UA2_Ejercicio1 {
    
    public static ConexionBBDD con = new ConexionBBDD();
    
    public static void main(String[] args) {
        
        LecturaFicheroProps.lecturaProps();
        
         con.conectar();
        
         Login vista = new Login();
         vista.setVisible(true);
        
        
    }
}
