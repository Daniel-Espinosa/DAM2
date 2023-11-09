/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.ad_ua2_tarea1.controler;

import com.cafeconpalito.ad_ua2_tarea1.DB.ConnectionDB;
import com.cafeconpalito.ad_ua2_tarea1.model.ConsultasDB;
import com.cafeconpalito.ad_ua2_tarea1.view.Login;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author damt207
 */
public class LoginControler implements MouseListener {
    
    private Login login;
    
    public void launchLogin(){
        login = new Login();
        
        login.setLocationRelativeTo(null);
        login.setVisible(true);
        
        //Botones Clicks
        login.getjButtonLogin().addMouseListener(this);
        login.getjButtonExit().addMouseListener(this);
        
    }

    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getComponent().getName().equals("Login")) {
            login.getjLabelError().setText(" ");
            if (login.getjTextFieldUser().getText().isBlank()) {
                login.getjLabelError().setText("Campo usuario vacio");
            } else if (login.getjTextFieldPass().getText().isBlank()) {
                login.getjLabelError().setText("Campo contraseña vacio");
            } else if (login.getjTextFieldUser().getText().isBlank() && login.getjTextFieldPass().getText().isBlank()) {
                login.getjLabelError().setText("Campo usuario y contraseña vacios");
            } else{
                ConnectionDB.setUSER(login.getjTextFieldUser().getText());
                ConnectionDB.setPASS(login.getjTextFieldPass().getText());
                
                try {
                    Connection con = ConnectionDB.getInstance().getConnection();
                    //System.out.println("log ok");
                    
                    ConsultasDB.juego();
                    ConsultasDB.jugador();
                    ConsultasDB.jugadorSesionJuego();
                    
                } catch (SQLException ex) {
                   System.out.println("ERROR Conection");
                   login.getjLabelError().setText("Usuario o Contraseña Incorrecto");
                }
                
            }
            
        }
        
        if (e.getComponent().getName().equals("Exit")) {
            System.exit(0);
        }
    }


    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    
    
}
