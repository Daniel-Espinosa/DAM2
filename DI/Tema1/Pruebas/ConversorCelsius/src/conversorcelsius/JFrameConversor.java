/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package conversorcelsius;

import java.awt.Color;
import java.awt.event.KeyEvent;


/**
 *
 * @author damt207/
 */
public class JFrameConversor extends javax.swing.JFrame {

    private int maxCaracteres = 20;
    
    /**
     * Creates new form JFrameConversor
     */
    public JFrameConversor() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton_convertir = new javax.swing.JButton();
        jLabel_Respuesta = new javax.swing.JLabel();
        jLabel2_Celsius = new javax.swing.JLabel();
        jTextField_ValorCelcius = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Conversor Celsius");
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jButton_convertir.setText("Convertir");
        jButton_convertir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_convertirActionPerformed(evt);
            }
        });

        jLabel_Respuesta.setToolTipText("");

        jLabel2_Celsius.setText("Celsius");

        jTextField_ValorCelcius.setToolTipText("");
        jTextField_ValorCelcius.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_ValorCelciusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton_convertir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField_ValorCelcius))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2_Celsius, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(jLabel_Respuesta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2_Celsius, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_ValorCelcius, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel_Respuesta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_convertir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_convertirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_convertirActionPerformed
        // TODO add your handling code here:
        igual();
    }//GEN-LAST:event_jButton_convertirActionPerformed

    private void jTextField_ValorCelciusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_ValorCelciusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_ValorCelciusActionPerformed

    private void igual() {
        String valorCelsius = jTextField_ValorCelcius.getText();
        double celsius;
        
        try {
            
            celsius = Double.parseDouble(valorCelsius);
            
            double fahren;
            
            fahren = (celsius * 9/5) + 32;
           
            jLabel_Respuesta.setForeground(Color.black);
            jLabel_Respuesta.setText(fahren +"º Fahrenheit");
            
        } catch (NumberFormatException e) {
            //System.err.println("Error Number Format Exception");
            
            jLabel_Respuesta.setForeground(Color.red);
            jLabel_Respuesta.setText("Error");
        
        }
    }
    
    
    
    
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            igual();
        }
        if (key == KeyEvent.VK_COMMA || key == KeyEvent.VK_DECIMAL) {
            coma();
        }
        
        if (key == KeyEvent.VK_0 || key == KeyEvent.VK_NUMPAD0) {
            i0();
        }
        if (key == KeyEvent.VK_1 || key == KeyEvent.VK_NUMPAD1) {
            i1();
        }
        if (key == KeyEvent.VK_2 || key == KeyEvent.VK_NUMPAD2) {
            i2();
        }
        if (key == KeyEvent.VK_3 || key == KeyEvent.VK_NUMPAD3) {
            i3();
        }
        if (key == KeyEvent.VK_4 || key == KeyEvent.VK_NUMPAD4) {
            i4();
        }
        if (key == KeyEvent.VK_5 || key == KeyEvent.VK_NUMPAD5) {
            i5();
        }
        if (key == KeyEvent.VK_6 || key == KeyEvent.VK_NUMPAD6) {
            i6();
        }
        if (key == KeyEvent.VK_7 || key == KeyEvent.VK_NUMPAD7) {
            i7();
        }
        if (key == KeyEvent.VK_8 || key == KeyEvent.VK_NUMPAD8) {
            i8();
        }
        if (key == KeyEvent.VK_9 || key == KeyEvent.VK_NUMPAD9) {
            i9();
        }
    }//GEN-LAST:event_formKeyPressed

    private void i0() {
        limpiarError();
        limparCerosIzquierda();
        if (jTextField_ValorCelcius.getText().length() < maxCaracteres) {
            jTextField_ValorCelcius.setText(jTextField_ValorCelcius.getText() + "0");
        }
    }

    /**
     * Método que coloca en el panel el digito seleccionado por el usuario
     */
    private void i1() {
        limpiarError();
        limparCerosIzquierda();
        if (jTextField_ValorCelcius.getText().length() < maxCaracteres) {
            jTextField_ValorCelcius.setText(jTextField_ValorCelcius.getText() + "1");
        }
    }

    /**
     * Método que coloca en el panel el digito seleccionado por el usuario
     */
    private void i2() {
        limpiarError();
        limparCerosIzquierda();
        if (jTextField_ValorCelcius.getText().length() < maxCaracteres) {
            jTextField_ValorCelcius.setText(jTextField_ValorCelcius.getText() + "2");
        }
    }
    /**
     * Método que coloca en el panel el digito seleccionado por el usuario
     */
    private void i3() {
        limpiarError();
        limparCerosIzquierda();
        if (jTextField_ValorCelcius.getText().length() < maxCaracteres) {
            jTextField_ValorCelcius.setText(jTextField_ValorCelcius.getText() + "3");
        }
    }
    /**
     * Método que coloca en el panel el digito seleccionado por el usuario
     */
    private void i4() {
        limpiarError();
        limparCerosIzquierda();
        if (jTextField_ValorCelcius.getText().length() < maxCaracteres) {
            jTextField_ValorCelcius.setText(jTextField_ValorCelcius.getText() + "4");
        }
    }
    /**
     * Método que coloca en el panel el digito seleccionado por el usuario
     */
    private void i5() {
        limpiarError();
        limparCerosIzquierda();
        if (jTextField_ValorCelcius.getText().length() < maxCaracteres) {
            jTextField_ValorCelcius.setText(jTextField_ValorCelcius.getText() + "5");
        }
    }
    /**
     * Método que coloca en el panel el digito seleccionado por el usuario
     */
    private void i6() {
        limpiarError();
        limparCerosIzquierda();
        if (jTextField_ValorCelcius.getText().length() < maxCaracteres) {
            jTextField_ValorCelcius.setText(jTextField_ValorCelcius.getText() + "6");
        }
    }
    /**
     * Método que coloca en el panel el digito seleccionado por el usuario
     */
    private void i7() {
        limpiarError();
        limparCerosIzquierda();
        if (jTextField_ValorCelcius.getText().length() < maxCaracteres) {
            jTextField_ValorCelcius.setText(jTextField_ValorCelcius.getText() + "7");
        }
    }
    /**
     * Método que coloca en el panel el digito seleccionado por el usuario
     */
    private void i8() {
        limpiarError();
        limparCerosIzquierda();
        if (jTextField_ValorCelcius.getText().length() < maxCaracteres) {
            jTextField_ValorCelcius.setText(jTextField_ValorCelcius.getText() + "8");
        }
    }
    /**
     * Método que coloca en el panel el digito seleccionado por el usuario
     */
    private void i9() {
        limpiarError();
        limparCerosIzquierda();
        if (jTextField_ValorCelcius.getText().length() < maxCaracteres) {
            jTextField_ValorCelcius.setText(jTextField_ValorCelcius.getText() + "9");
        }
    }
    
     private void coma() {
        limpiarError();
        if (jTextField_ValorCelcius.getText().length() < maxCaracteres) {
            if (jTextField_ValorCelcius.getText().length() == 0) {
                jTextField_ValorCelcius.setText("0.");
            } else if (!jTextField_ValorCelcius.getText().contains(".")) {
                jTextField_ValorCelcius.setText(jTextField_ValorCelcius.getText() + ".");
            }
        }
    }
     
    public void limparCerosIzquierda() {
        if (jTextField_ValorCelcius.getText().equalsIgnoreCase("0")) {
            jTextField_ValorCelcius.setText("");
        }
    }
    
    public void limpiarError() {
        if (jTextField_ValorCelcius.getText().equalsIgnoreCase("ERROR")) {// si tiene un error limpia para volver a colocar numeros ;)
            jTextField_ValorCelcius.setText("0");
            jLabel_Respuesta.setText("");
        }
    }
        
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
            java.util.logging.Logger.getLogger(JFrameConversor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameConversor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameConversor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameConversor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameConversor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_convertir;
    private javax.swing.JLabel jLabel2_Celsius;
    private javax.swing.JLabel jLabel_Respuesta;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField_ValorCelcius;
    // End of variables declaration//GEN-END:variables
}
