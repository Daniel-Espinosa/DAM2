/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package di_tarea_1_6;

import javax.swing.ButtonModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author damt207
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
    }
    
    private void errorSeleccionRadioButton() {
        JOptionPane jop = new JOptionPane("¡Selecciona una opcion para el Sistema Operativo!", JOptionPane.ERROR_MESSAGE);
        JDialog jd = jop.createDialog("ERROR");
        jd.setLocationRelativeTo(null);
        jd.setVisible(true);
    }
    
    private void errorSeleccionCheckBox() {
        JOptionPane jop = new JOptionPane("¡Elige tu campo de especialización!", JOptionPane.ERROR_MESSAGE);
        JDialog jd = jop.createDialog("ERROR");
        jd.setLocationRelativeTo(null);
        jd.setVisible(true);
    }
    
    private void generarEncuesta() {
        
        if (groupRadioButton() == null) {
            errorSeleccionRadioButton();
        } else if (groupChekBox() == null) {
            errorSeleccionCheckBox();
        } else {
            
            JOptionPane jop = new JOptionPane("El sistema operativo elegido es: " + groupRadioButton()
                    + "\nEl Campo de especializacion elegido es: " + groupChekBox()
                    + "\nEl numero de horas de visualizacion de pantalla es: " + jSlider1.getValue(), JOptionPane.INFORMATION_MESSAGE);
            JDialog jd = jop.createDialog("¡Encuesta Generada!");
            jd.setLocationRelativeTo(null);
            jd.setVisible(true);
            reiniciarEncuesta();
        }
    }
    
    private void reiniciarEncuesta() {
        Grupo.clearSelection();
        jSlider1.setValue(12);
        jCheckBoxAdmin.setSelected(false);
        jCheckBoxDisGraf.setSelected(false);
        jCheckBoxProgramacion.setSelected(false);
        
    }
    
    private String groupRadioButton() {
        
        String seleccion = null;
        
        if (jRadioButtonWin.isSelected()) {
            seleccion = "Windows";
        }
        if (jRadioButtonLinux.isSelected()) {
            seleccion = "Linux";
        }
        if (jRadioButtonMac.isSelected()) {
            seleccion = "Mac";
        }
        if (jRadioButtonUbuntu.isSelected()) {
            seleccion = "Ubuntu";
        }
        if (jRadioButtonOtros.isSelected()) {
            seleccion = "Otros";
        }
        
        return seleccion;
    }
    
    private String groupChekBox() {
        
        String seleccion = null;
        
        if (jCheckBoxProgramacion.isSelected()) {
            if (seleccion == null) {
                seleccion = "\nProgramación";
            } else {
                seleccion += "\nProgramación";
            }
        }
        if (jCheckBoxDisGraf.isSelected()) {
            if (seleccion == null) {
                seleccion = "\nDiseño Gráfico";
            } else {
                seleccion += "\nDiseño Gráfico";
            }
        }
        if (jCheckBoxAdmin.isSelected()) {
            if (seleccion == null) {
                seleccion = "\nAdministración y Gestión";
            } else {
                seleccion += "\nAdministración y Gestión";
            }
        }
        return seleccion;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Grupo = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jRadioButtonWin = new javax.swing.JRadioButton();
        jRadioButtonMac = new javax.swing.JRadioButton();
        jRadioButtonLinux = new javax.swing.JRadioButton();
        jRadioButtonUbuntu = new javax.swing.JRadioButton();
        jRadioButtonOtros = new javax.swing.JRadioButton();
        jCheckBoxProgramacion = new javax.swing.JCheckBox();
        jCheckBoxDisGraf = new javax.swing.JCheckBox();
        jCheckBoxAdmin = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSlider1 = new javax.swing.JSlider();
        jButton1 = new javax.swing.JButton();
        jLabelValor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("“Tarea  1_4_MiniEncuesta_Daniel_Espinosa_Garcia");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Elige un sistema operativo");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Elige tu campo de especialización");
        jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Grupo.add(jRadioButtonWin);
        jRadioButtonWin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRadioButtonWin.setText("Windows");

        Grupo.add(jRadioButtonMac);
        jRadioButtonMac.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRadioButtonMac.setText("MacOS");

        Grupo.add(jRadioButtonLinux);
        jRadioButtonLinux.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRadioButtonLinux.setText("Linux");

        Grupo.add(jRadioButtonUbuntu);
        jRadioButtonUbuntu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRadioButtonUbuntu.setText("Ubuntu");

        Grupo.add(jRadioButtonOtros);
        jRadioButtonOtros.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jRadioButtonOtros.setText("Otros");

        jCheckBoxProgramacion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCheckBoxProgramacion.setText("Programación");

        jCheckBoxDisGraf.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCheckBoxDisGraf.setText("Diseño Gráfico");

        jCheckBoxAdmin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCheckBoxAdmin.setText("Administración y Gestión");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Horas de Uso o Visualización de Pantallas");
        jLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jSlider1.setMajorTickSpacing(1);
        jSlider1.setMaximum(24);
        jSlider1.setMinorTickSpacing(1);
        jSlider1.setPaintTicks(true);
        jSlider1.setSnapToTicks(true);
        jSlider1.setValue(12);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Generar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabelValor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelValor.setText("12");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelValor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxAdmin)
                    .addComponent(jCheckBoxDisGraf)
                    .addComponent(jCheckBoxProgramacion)
                    .addComponent(jRadioButtonOtros)
                    .addComponent(jRadioButtonUbuntu)
                    .addComponent(jRadioButtonLinux)
                    .addComponent(jRadioButtonMac)
                    .addComponent(jRadioButtonWin)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonWin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonMac)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonLinux)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonUbuntu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonOtros)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBoxProgramacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxDisGraf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelValor, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        generarEncuesta();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        // TODO add your handling code here:
        jLabelValor.setText(jSlider1.getValue() + "");
    }//GEN-LAST:event_jSlider1StateChanged

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Grupo;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBoxAdmin;
    private javax.swing.JCheckBox jCheckBoxDisGraf;
    private javax.swing.JCheckBox jCheckBoxProgramacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelValor;
    private javax.swing.JRadioButton jRadioButtonLinux;
    private javax.swing.JRadioButton jRadioButtonMac;
    private javax.swing.JRadioButton jRadioButtonOtros;
    private javax.swing.JRadioButton jRadioButtonUbuntu;
    private javax.swing.JRadioButton jRadioButtonWin;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSlider jSlider1;
    // End of variables declaration//GEN-END:variables
}
