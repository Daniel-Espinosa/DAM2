/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di_tema3_3_compcolortextofondo;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import javax.swing.JTextField;

/**
 *
 * @author damt207
 */
public class JTextFieldPersonalizado extends JTextField implements Serializable, KeyListener {

    private Color A_initial_Backgroun_Color, A_initial_Text_Color, A_change_Backgroun_Color, A_change_Text_Color;
    private int A_numCharacters;

    public JTextFieldPersonalizado() {
        this.addKeyListener(this);
        
        this.A_numCharacters = 5;
        this.A_initial_Text_Color = Color.BLACK;
        this.A_initial_Backgroun_Color = Color.WHITE;
        
        this.setForeground(A_initial_Text_Color);
        this.setBackground(A_initial_Backgroun_Color);
        
        this.setText("MiComponente");
        
    }

    public void setA_initial_Backgroun_Color(Color A_initial_Backgroun_Color) {
        this.A_initial_Backgroun_Color = A_initial_Backgroun_Color;
    }

    public void setA_initial_Text_Color(Color A_initial_Text_Color) {
        this.A_initial_Text_Color = A_initial_Text_Color;
    }

    public void setA_change_Backgroun_Color(Color A_change_Backgroun_Color) {
        this.A_change_Backgroun_Color = A_change_Backgroun_Color;
    }

    public void setA_change_Text_Color(Color A_change_Text_Color) {
        this.A_change_Text_Color = A_change_Text_Color;
    }

    public void setA_numCharacters(int A_numCharacters) {
        this.A_numCharacters = A_numCharacters;
    }

    public Color getA_initial_Backgroun_Color() {
        return A_initial_Backgroun_Color;
    }

    public Color getA_initial_Text_Color() {
        return A_initial_Text_Color;
    }

    public Color getA_change_Backgroun_Color() {
        return A_change_Backgroun_Color;
    }

    public Color getA_change_Text_Color() {
        return A_change_Text_Color;
    }

    public int getA_numCharacters() {
        return A_numCharacters;
    }

    
    
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
 
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        if (this.getText().length() >= A_numCharacters) {
            this.setForeground(A_change_Text_Color);//Texto
            this.setBackground(A_change_Backgroun_Color);//Fondo
        } else {
            this.setForeground(A_initial_Text_Color);//Texto
            this.setBackground(A_initial_Backgroun_Color);//Fondo
        }
    }

}
