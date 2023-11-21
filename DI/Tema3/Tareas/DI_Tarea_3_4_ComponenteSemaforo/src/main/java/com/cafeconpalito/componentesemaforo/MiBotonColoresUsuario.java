/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.componentesemaforo;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author damt207
 */
public class MiBotonColoresUsuario extends JButton implements Serializable, MouseListener {

    Container a_ComponenteModificar;

    public Container getA_ComponenteModificar() {
        return a_ComponenteModificar;
    }

    public void setA_ComponenteModificar(Container a_ComponenteModificar) {
        this.a_ComponenteModificar = a_ComponenteModificar;
    }
    Color foregroundColor;

    public MiBotonColoresUsuario() {
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
       foregroundColor = selector();
       a_ComponenteModificar.setForeground(foregroundColor);
       
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

    private Color selector() {
        //Crear Objeto Color Selector
        JColorChooser colorChooser = new JColorChooser();
 
        //Mostrar el selector
        int resultado = JOptionPane.showConfirmDialog(null, colorChooser, "Selecciona un color", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
 
        //Coger el color
        if (resultado == JOptionPane.OK_OPTION) {
            return colorChooser.getColor();
 
        } else {
            return Color.BLACK;
        }
    }
    
}
