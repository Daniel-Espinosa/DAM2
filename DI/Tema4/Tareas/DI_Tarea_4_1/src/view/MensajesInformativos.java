/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

/**
 *
 * @author produccion
 */
public class MensajesInformativos {

    /**
     * Lanza un mensaje de informacion o error
     * @param titulo Titulo del mensaje
     * @param mensaje Texto del Mensaje
     * @param tipoMensaje true INFORMATION_MESSAGE, false ERROR_MESSAGE
     */
    public static void lanzarMensaje(String titulo, String mensaje, boolean tipoMensaje) {

        //Para cambiar el color de fondo del mensaje
        /*
        UIManager UI=new UIManager();
        UI.put("OptionPane.background",new ColorUIResource(23,26,33));
        UI.put("Panel.background",new ColorUIResource(23,26,33));
        */

        //si es mensaje de error o informacion
        JOptionPane jop;
        if (tipoMensaje) {
            jop = new JOptionPane(mensaje, JOptionPane.INFORMATION_MESSAGE);
        } else {
            jop = new JOptionPane(mensaje, JOptionPane.ERROR_MESSAGE);
            
        }
        
        //Titulo del mensaje
        JDialog jd = jop.createDialog(titulo);
        
        //ICONO DE LA APP DEL MENSAJE
        //al estar englobado dentro de una aplicacion le cargo la imangen de la misma.
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/SteamBlueLogo.png"));
        jd.setIconImage(retValue);
        
        //Lanza el mensaje
        jd.setLocationRelativeTo(null);
        jd.setVisible(true);
    }

}
