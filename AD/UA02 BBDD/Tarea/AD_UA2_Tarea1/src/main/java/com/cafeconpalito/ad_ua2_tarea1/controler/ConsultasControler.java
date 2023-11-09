/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.ad_ua2_tarea1.controler;

import com.cafeconpalito.ad_ua2_tarea1.view.Consultas;
import com.cafeconpalito.ad_ua2_tarea1.view.Login;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author damt207
 */
public class ConsultasControler implements MouseListener {

    Consultas consulta;

    public ConsultasControler() {
        consulta = new Consultas();
    }

    /*
    ConsultasDB.juego();
    ConsultasDB.jugador();
    ConsultasDB.jugadorSesionJuego();
     */
    public void launchConsultas() {

        consulta = new Consultas();

        consulta.setLocationRelativeTo(null);
        consulta.setVisible(true);

        //Botones
        consulta.getjButtonExit().addMouseListener(this);
        consulta.getjButtonJuegos().addMouseListener(this);
        consulta.getjButtonJugJuego().addMouseListener(this);
        consulta.getjButtonJugadores().addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        //Boton Jugadores
        if (e.getComponent().getName().equals("Jugadores")) {
            
        }

        //Boton Juegos
        if (e.getComponent().getName().equals("Juegos")) {
           
        }
        
        
        //Boton Jugadores / Juego
        if (e.getComponent().getName().equals("JugJuego")) {

        }

        //Boton Exit
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

    /*
            JTableHeader tableHeader = view.jTable1.getTableHeader();
            TableColumnModel tableColumnModel = tableHeader.getColumnModel();
            tableColumnModel.getColumn(0).setHeaderValue("id_jugador");
            tableColumnModel.getColumn(1).setHeaderValue("alias");
            tableColumnModel.getColumn(2).setHeaderValue("nombre");
            tableHeader.repaint();
     */
}
