/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di_tarea_3_1_jpanelusuario;

import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author damt207
 */
public class JPanelUsuarioImagen extends JPanel implements Serializable {

    private File rutaImagen;

    public JPanelUsuarioImagen() {
    }

    public File getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(File rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody

        if (rutaImagen != null && rutaImagen.exists()) {
            ImageIcon image = new ImageIcon(rutaImagen.getAbsolutePath());
            Dimension escalaCorrecta = getScaledDimension(new Dimension(image.getIconWidth(), image.getIconHeight()), //Dimension Imagen
                    new Dimension(this.getWidth(), this.getHeight())); // Dimension del Panel
            g.drawImage(image.getImage(), 0, 0, escalaCorrecta.width, escalaCorrecta.height, null);
        }

    }

    public static Dimension getScaledDimension(Dimension imgSize, Dimension boundary) {

        int original_width = imgSize.width;
        int original_height = imgSize.height;
        int bound_width = boundary.width;
        int bound_height = boundary.height;
        int new_width = original_width;
        int new_height = original_height;

        // first check if we need to scale width
        if (original_width > bound_width) {
            //scale width to fit
            new_width = bound_width;
            //scale height to maintain aspect ratio
            new_height = (new_width * original_height) / original_width;
        }

        // then check if we need to scale even with the new height
        if (new_height > bound_height) {
            //scale height to fit instead
            new_height = bound_height;
            //scale width to maintain aspect ratio
            new_width = (new_height * original_width) / original_height;
        }

        return new Dimension(new_width, new_height);
    }

}
