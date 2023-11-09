/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cafeconpalito.ad_ua2_tarea1;


import com.cafeconpalito.ad_ua2_tarea1.controler.LoginControler;


/**
 *
 * @author damt207
 */
public class AD_UA2_Tarea1 {

    public static void main(String[] args) {
        
        //Connection con = ConnectionDB.getInstance().getConnection();
        LoginControler l = new LoginControler();
        l.launchLogin();
        
    }
}
