/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import entidad.User;
import view.Login;

/**
 *
 * @author damt207
 */
public class Main {
    
    public static User usuarioLogin = new User(null, null, null);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Login vista = new Login();
        vista.setVisible(true);
        
    }

}
