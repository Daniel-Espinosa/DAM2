/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.ad_ua2_tarea1.controler;

import com.cafeconpalito.ad_ua2_tarea1.model.ConsultasDB;
import com.cafeconpalito.ad_ua2_tarea1.view.Consultas;
import com.cafeconpalito.ad_ua2_tarea1.view.Login;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

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
            
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnCount(3);
            model.setRowCount(0);
            
            consulta.getjTable1().setModel(model);
                 
            JTableHeader tableHeader = consulta.getjTable1().getTableHeader();
            TableColumnModel tableColumnModel = tableHeader.getColumnModel();
            tableColumnModel.getColumn(0).setHeaderValue("id_jugador");
            tableColumnModel.getColumn(1).setHeaderValue("Alias");
            tableColumnModel.getColumn(2).setHeaderValue("Nombre");
            
            ArrayList<String[]> lista = ConsultasDB.jugador();
            
            for (String[] i : lista) {
                model.addRow(i);
            }
            
            consulta.getjTable1().repaint();
            
        }

        //Boton Juegos
        if (e.getComponent().getName().equals("Juegos")) {
            
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnCount(3);
            model.setRowCount(0);
            
            consulta.getjTable1().setModel(model);
                 
            JTableHeader tableHeader = consulta.getjTable1().getTableHeader();
            TableColumnModel tableColumnModel = tableHeader.getColumnModel();
            tableColumnModel.getColumn(0).setHeaderValue("id_juego");
            tableColumnModel.getColumn(1).setHeaderValue("Nombre Juego");
            tableColumnModel.getColumn(2).setHeaderValue("Tipo");
            
            ArrayList<String[]> lista = ConsultasDB.juego();
            
            for (String[] i : lista) {
                model.addRow(i);
            }
            
            consulta.getjTable1().repaint();
           
        }
        
        
        //Boton Jugadores / Juego
        if (e.getComponent().getName().equals("JugJuego")) {
            
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnCount(3);
            model.setRowCount(0);
            
            consulta.getjTable1().setModel(model);
                 
            JTableHeader tableHeader = consulta.getjTable1().getTableHeader();
            TableColumnModel tableColumnModel = tableHeader.getColumnModel();
            tableColumnModel.getColumn(0).setHeaderValue("Alias Jugador");
            tableColumnModel.getColumn(1).setHeaderValue("Juego Nombre");
            tableColumnModel.getColumn(2).setHeaderValue("Fecha Partida");
            
            
            ArrayList<String[]> lista = ConsultasDB.jugadorSesionJuego();
            
            for (String[] i : lista) {
                model.addRow(i);
            }
            
            consulta.getjTable1().repaint();

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
