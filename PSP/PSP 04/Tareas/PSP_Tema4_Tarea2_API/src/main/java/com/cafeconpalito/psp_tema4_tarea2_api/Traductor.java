/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.cafeconpalito.psp_tema4_tarea2_api;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author produccion
 */
public class Traductor extends javax.swing.JFrame {

    //Almacena las Clave valor de los lenguajes para mostrar la clave en la interfaz grafica
    HashMap<String, String> languages = new HashMap();

    //ApyKey
    String apyKeyTranslate = "16820e57-056b-8f96-52af-3b49f8431a12:fx";

    /**
     * Creates new form Traductor
     */
    public Traductor() {
        initComponents();

        if (statusService()) {

            //Al iniciar la aplicacion obtengo los lenguajes
            obtainLanguages();
            //Cargo los lenguajes en el combo box
            comboBoxUpdateLanguages();
            //Actualiza los campos del uso de la app
            usage();

            //Cargo la imagen en el label ajustando su tamaño
            ImageIcon image = new ImageIcon("images/logo-simple.png");
            Dimension escalaCorrecta = getScaledDimension(new Dimension(image.getIconWidth(), image.getIconHeight()),
                    new Dimension(jLabelLogo.getWidth(), jLabelLogo.getHeight()));
            Image imgEscalada = image.getImage().getScaledInstance(escalaCorrecta.width, escalaCorrecta.height, WIDTH);
            ImageIcon imgFinal = new ImageIcon(imgEscalada);
            jLabelLogo.setIcon(imgFinal);

        } else {
            JOptionPane jop = new JOptionPane("Error de conexion con el servidor ", JOptionPane.ERROR_MESSAGE);
            JDialog jd = jop.createDialog("ERROR");
            jd.setLocationRelativeTo(null);
            jd.setVisible(true);

            System.exit(0);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaInText = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaTraduction = new javax.swing.JTextArea();
        jButtonTraducir = new javax.swing.JButton();
        jButtonLimpiar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabelLimiteCaracteres = new javax.swing.JLabel();
        jLabelCaracteresUsados = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxLanguages = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabelLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Api Traductor");
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTextAreaInText.setColumns(20);
        jTextAreaInText.setRows(5);
        jScrollPane1.setViewportView(jTextAreaInText);

        jTextAreaTraduction.setColumns(20);
        jTextAreaTraduction.setRows(5);
        jTextAreaTraduction.setFocusable(false);
        jScrollPane2.setViewportView(jTextAreaTraduction);

        jButtonTraducir.setText("Traducir");
        jButtonTraducir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonTraducir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTraducirActionPerformed(evt);
            }
        });

        jButtonLimpiar.setText("Limpiar");
        jButtonLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabelLimiteCaracteres.setText("jLabel3");

        jLabelCaracteresUsados.setText("jLabel2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCaracteresUsados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelLimiteCaracteres)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCaracteresUsados)
                .addGap(18, 18, 18)
                .addComponent(jLabelLimiteCaracteres)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText(" Introduce un texto a traducir");

        jComboBoxLanguages.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("<html> Café Con Palito®<br>Traductor - Versión 1.0.0 </html>");

        jLabelLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLogoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxLanguages, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButtonLimpiar)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonTraducir))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxLanguages, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonLimpiar)
                            .addComponent(jButtonTraducir))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Accion del boton Traducir
     *
     * @param evt
     */
    private void jButtonTraducirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTraducirActionPerformed
        traducir();
        usage();
    }//GEN-LAST:event_jButtonTraducirActionPerformed

    /**
     * Accion del boton limpiar. Limpia los campos de los jTextArea.
     *
     * @param evt
     */
    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        jTextAreaInText.setText("");
        jTextAreaTraduction.setText("");
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    private void jLabelLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLogoMouseClicked
        // TODO add your handling code here:
        try {
            Desktop.getDesktop().browse(new URI("https://github.com/CafeConPalito"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jLabelLogoMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Traductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Traductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Traductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Traductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Traductor().setVisible(true);
            }
        });
    }

    /**
     * Metodo que comprube el status de los servicios de la api. si todos son
     * correctos devuelve true;
     */
    private boolean statusService() {

        try {
            HttpRequest getUsage = HttpRequest.newBuilder()
                    .uri(URI.create("https://api-free.deepl.com/v2/usage"))
                    .header("Authorization", "DeepL-Auth-Key " + apyKeyTranslate)
                    .timeout(Duration.ofSeconds(5)) // Tiempo de espera para comprobar
                    .GET()
                    .build();
            //Recibo la respuesta de la API COMO UN STRING
            HttpResponse<String> responseUsage = HttpClient.newHttpClient().send(getUsage, HttpResponse.BodyHandlers.ofString());

            HttpRequest getLanguages = HttpRequest.newBuilder()
                    .uri(URI.create("https://api-free.deepl.com/v2/languages?type=target"))
                    .header("Authorization", "DeepL-Auth-Key " + apyKeyTranslate)
                    .timeout(Duration.ofSeconds(5)) // Tiempo de espera para comprobar
                    .GET()
                    .build();
            HttpResponse<String> responseLang = HttpClient.newHttpClient().send(getLanguages, HttpResponse.BodyHandlers.ofString());

            return true;

        } catch (IOException | InterruptedException ex) {
            return false;
        }
    }

    /**
     * Metodo que obtiene los lenguajes de la api y los almacena en un HashMap.
     */
    private void obtainLanguages() {

        try {
            //Envio la peticion a la API
            HttpRequest getLanguages = HttpRequest.newBuilder()
                    .uri(URI.create("https://api-free.deepl.com/v2/languages?type=target"))
                    .header("Authorization", "DeepL-Auth-Key " + apyKeyTranslate)
                    .timeout(Duration.ofSeconds(5))
                    .GET()
                    .build();
            //Recibo la respuesta de la API COMO UN STRING
            HttpResponse<String> responseLang = HttpClient.newHttpClient().send(getLanguages, HttpResponse.BodyHandlers.ofString());

            //Cargo la respuesta de la apy en un JSONARRAY
            JSONArray jArrayLang = new JSONArray(responseLang.body());

            //Por cada objeto obtenido de la respuesta que lleve al Array lo cargo en un hash map para obtener un par clave 
            //valor y poder luego seleccionar el idioma a traducir.
            for (int i = 0; i < jArrayLang.length(); i++) {
                JSONObject aux = jArrayLang.getJSONObject(i);
                languages.put(aux.getString("name"), aux.getString("language"));
            }

        } catch (IOException ex) {
            Logger.getLogger(Traductor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Traductor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo que carga los lenguajes del HashMap al combo box.
     */
    private void comboBoxUpdateLanguages() {

        for (Map.Entry<String, String> entry : languages.entrySet()) {
            String key = entry.getKey();
            jComboBoxLanguages.addItem(key);
        }

    }

    /**
     * Metodo que devuelve el valor del lenguaje seleccionado.
     *
     * @return lenguaje seleccinado Value.
     */
    private String languageSelected() {

        return languages.get(jComboBoxLanguages.getSelectedItem());
    }

    /**
     * Metodo que envia la peticion POST para que retorne el texto traducido y
     * mostrarlo por pantalla.
     */
    private void traducir() {

        try {
            String texto = jTextAreaInText.getText();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api-free.deepl.com/v2/translate"))
                    .header("Authorization", "DeepL-Auth-Key " + apyKeyTranslate)
                    .header("content-type", "application/x-www-form-urlencoded")
                    .timeout(Duration.ofSeconds(5))
                    .method("POST", HttpRequest.BodyPublishers.ofString("text=" + texto + "&" + "target_lang=" + languageSelected()))
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            JSONObject traduc = new JSONObject(response.body());

            jTextAreaTraduction.setText(traduc.getJSONArray("translations").getJSONObject(0).getString("text"));

        } catch (IOException ex) {
            Logger.getLogger(Traductor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Traductor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Metodo que actualiza el uso que tiene la aplicacion.
     */
    private void usage() {

        try {
            HttpRequest getUsage = HttpRequest.newBuilder()
                    .uri(URI.create("https://api-free.deepl.com/v2/usage"))
                    .header("Authorization", "DeepL-Auth-Key " + apyKeyTranslate)
                    .timeout(Duration.ofSeconds(5))
                    .GET()
                    .build();
            //Recibo la respuesta de la API COMO UN STRING
            HttpResponse<String> responseUsage = HttpClient.newHttpClient().send(getUsage, HttpResponse.BodyHandlers.ofString());

            JSONObject joUsage = new JSONObject(responseUsage.body());

            jLabelCaracteresUsados.setText("Caracteres usados: " + joUsage.getInt("character_count"));
            jLabelLimiteCaracteres.setText("Limite de caracteres: " + joUsage.getInt("character_limit"));

        } catch (IOException ex) {
            Logger.getLogger(Traductor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Traductor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Metodo para escalar una imagen recibe como parametos las dimensiones de
     * una imagen y el contenedor y devuelve la escala necesaria.
     *
     * @param imgSize dimension de la imagen
     * @param boundary dimension del contenedor
     * @return nueva dimension de la imagen.
     */
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JButton jButtonTraducir;
    private javax.swing.JComboBox<String> jComboBoxLanguages;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelCaracteresUsados;
    private javax.swing.JLabel jLabelLimiteCaracteres;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaInText;
    private javax.swing.JTextArea jTextAreaTraduction;
    // End of variables declaration//GEN-END:variables
}
