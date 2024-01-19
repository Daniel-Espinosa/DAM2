/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cafeconpalito.ad_ud4_coneccion_mongodb;

/**
 *
 * @author Cafe Con Palito
 */
public class AD_UD4_Coneccion_MongoDB {

    public static void main(String[] args) {
        
        ConeccionMongoDB con = new  ConeccionMongoDB("daniel", "1234", "@cluster0.ht8aq4h.mongodb.net/?retryWrites=true&w=majority");
        con.createConecction();
        con.startConecction();
        
    }
}
