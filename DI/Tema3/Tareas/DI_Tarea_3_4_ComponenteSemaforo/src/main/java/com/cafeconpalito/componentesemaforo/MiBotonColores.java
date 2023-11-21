/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.componentesemaforo;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author damt207
 */
public class MiBotonColores extends JButton implements Serializable , MouseListener{

    Color a_BotonColorInicia, a_BotonColorSobre, a_BotonTextoInicial, a_BotonTextoSobre, a_ColorTextoModificado;
    JLabel a_labelCambiar;
    String a_textoOculto;

    public MiBotonColores() {
    
            this.addMouseListener(this);
            a_BotonColorInicia = Color.WHITE;
            a_BotonColorSobre = Color.GRAY;
            a_BotonTextoInicial = Color.BLACK;
            a_BotonTextoSobre = Color.WHITE;
            a_textoOculto = "Introduce texto que quieres modificar";
            a_ColorTextoModificado = Color.RED;
    }

    public void setA_BotonColorInicia(Color a_BotonColorInicia) {
        this.a_BotonColorInicia = a_BotonColorInicia;
        this.setBackground(a_BotonColorInicia);
    }

    public void setA_BotonColorSobre(Color a_BotonColorSobre) {
        this.a_BotonColorSobre = a_BotonColorSobre;
    }

    public void setA_BotonTextoInicial(Color a_BotonTextoInicial) {
        this.a_BotonTextoInicial = a_BotonTextoInicial;
        this.setForeground(a_BotonTextoInicial);
    }

    public void setA_BotonTextoSobre(Color a_BotonTextoSobre) {
        this.a_BotonTextoSobre = a_BotonTextoSobre;
    }

    public void setA_ColorTextoModificado(Color a_ColorTextoModificado) {
        this.a_ColorTextoModificado = a_ColorTextoModificado;
    }

    public void setA_labelCambiar(JLabel a_labelCambiar) {
        this.a_labelCambiar = a_labelCambiar;
    }

    public void setA_textoOculto(String a_textoOculto) {
        this.a_textoOculto = a_textoOculto;
    }

    public Color getA_BotonColorInicia() {
        return a_BotonColorInicia;
    }

    public Color getA_BotonColorSobre() {
        return a_BotonColorSobre;
    }

    public Color getA_BotonTextoInicial() {
        return a_BotonTextoInicial;
    }

    public Color getA_BotonTextoSobre() {
        return a_BotonTextoSobre;
    }

    public Color getA_ColorTextoModificado() {
        return a_ColorTextoModificado;
    }

    public JLabel getA_labelCambiar() {
        return a_labelCambiar;
    }

    public String getA_textoOculto() {
        return a_textoOculto;
    }

    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        a_labelCambiar.setText(a_textoOculto);
        a_labelCambiar.setForeground(a_ColorTextoModificado);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
        this.setBackground(a_BotonColorSobre);
        this.setForeground(a_BotonTextoSobre);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
            
}
