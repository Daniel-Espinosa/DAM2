/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controlador.ControlerGame;
import java.awt.Image;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author damt207
 */
public class AddGame extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    public AddGame() {

        initComponents();

        ImageIcon imageBuscar = new ImageIcon("src/images/Buscar.png");
        Image imgBuscarEscalada = imageBuscar.getImage().getScaledInstance(26, 26, WIDTH);
        ImageIcon imgBuscarFinal = new ImageIcon(imgBuscarEscalada);
        jLabelImageAdd.setIcon(imgBuscarFinal);

        /*
        ImageIcon image = new ImageIcon("src/images/SteamBlueLogo.png");
        Image imgEscalada = image.getImage().getScaledInstance(jLabelLogo.getWidth(), jLabelLogo.getHeight(), WIDTH);
        ImageIcon imgFinal = new ImageIcon(imgEscalada);
        jLabelLogo.setIcon(imgFinal);
         */
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titulo = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFielName = new javax.swing.JTextField();
        jDateChooserDateRelease = new com.toedter.calendar.JDateChooser();
        jComboBoxCompani = new javax.swing.JComboBox<>();
        jSpinnerPegi = new javax.swing.JSpinner();
        jComboBoxGenre = new javax.swing.JComboBox<>();
        jTextFielPrice = new javax.swing.JTextField();
        jLabelImageAdd = new javax.swing.JLabel();
        jTextFielDirImagen = new javax.swing.JTextField();
        jLabelDireccion = new javax.swing.JLabel();
        jPanelDescripcion = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescripcion = new javax.swing.JTextArea();
        jLabelErrorNombre = new javax.swing.JLabel();
        jLabelErrorGenre = new javax.swing.JLabel();
        jLabelErrorCompany = new javax.swing.JLabel();
        jLabelErrorDateRelease = new javax.swing.JLabel();
        jLabelErrorPegi = new javax.swing.JLabel();
        jLabelErrorPrecio = new javax.swing.JLabel();
        jLabelErrorDirImagen = new javax.swing.JLabel();
        jLabelErrorDescripcion = new javax.swing.JLabel();
        jButtonSaveGame = new javax.swing.JButton();
        jButtonSaveGame1 = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(940, 690));
        setMinimumSize(new java.awt.Dimension(940, 690));
        setPreferredSize(new java.awt.Dimension(940, 690));

        Titulo.setBackground(new java.awt.Color(27, 40, 56));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(197, 195, 192));
        jLabel3.setText("Agregar Juego");

        javax.swing.GroupLayout TituloLayout = new javax.swing.GroupLayout(Titulo);
        Titulo.setLayout(TituloLayout);
        TituloLayout.setHorizontalGroup(
            TituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TituloLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TituloLayout.setVerticalGroup(
            TituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TituloLayout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(10, 10, 10))
        );

        jPanel1.setBackground(new java.awt.Color(23, 26, 33));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(197, 195, 192));
        jLabel2.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(197, 195, 192));
        jLabel4.setText("Genero");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(197, 195, 192));
        jLabel5.setText("Fecha Lanzamiento");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(197, 195, 192));
        jLabel6.setText("Compañia");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(197, 195, 192));
        jLabel7.setText("Precio");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(197, 195, 192));
        jLabel9.setText("Pegi");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(197, 195, 192));
        jLabel10.setText("Imagen");

        jTextFielName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFielName.setText("Nombre");
        jTextFielName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFielNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFielNameFocusLost(evt);
            }
        });
        jTextFielName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFielNameKeyReleased(evt);
            }
        });

        jDateChooserDateRelease.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jComboBoxCompani.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBoxCompani.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "< Seleccionar >", "Bethesda", "CD PROJEKT RED", "Larian Studios", "Nintendo", "SEGA" }));

        jSpinnerPegi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jSpinnerPegi.setModel(new javax.swing.SpinnerListModel(new String[] {"< Seleccionar >", "Pegi +3", "Pegi +4", "Pegi +6", "Pegi +7", "Pegi +12", "Pegi +16", "Pegi +18"}));

        jComboBoxGenre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBoxGenre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "< Seleccionar >", "Accion", "Aventura", "Carreras", "Puzzle", "Rol", "Shooter", "Terror" }));

        jTextFielPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFielPrice.setText("Precio");
        jTextFielPrice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFielPriceFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFielPriceFocusLost(evt);
            }
        });
        jTextFielPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFielPriceKeyTyped(evt);
            }
        });

        jLabelImageAdd.setMaximumSize(new java.awt.Dimension(26, 26));
        jLabelImageAdd.setMinimumSize(new java.awt.Dimension(26, 26));
        jLabelImageAdd.setPreferredSize(new java.awt.Dimension(26, 26));
        jLabelImageAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelImageAddMousePressed(evt);
            }
        });

        jTextFielDirImagen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFielDirImagen.setText("Dirección");
        jTextFielDirImagen.setToolTipText("");
        jTextFielDirImagen.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFielDirImagenFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFielDirImagenFocusLost(evt);
            }
        });

        jLabelDireccion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelDireccion.setForeground(new java.awt.Color(197, 195, 192));
        jLabelDireccion.setText("Descripcion");

        jTextAreaDescripcion.setColumns(7);
        jTextAreaDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextAreaDescripcion.setRows(5);
        jTextAreaDescripcion.setText("Añade una descripcion del juego");
        jTextAreaDescripcion.setToolTipText("");
        jTextAreaDescripcion.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        jTextAreaDescripcion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextAreaDescripcionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextAreaDescripcionFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(jTextAreaDescripcion);

        javax.swing.GroupLayout jPanelDescripcionLayout = new javax.swing.GroupLayout(jPanelDescripcion);
        jPanelDescripcion.setLayout(jPanelDescripcionLayout);
        jPanelDescripcionLayout.setHorizontalGroup(
            jPanelDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanelDescripcionLayout.setVerticalGroup(
            jPanelDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDescripcionLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabelErrorNombre.setForeground(new java.awt.Color(255, 0, 51));
        jLabelErrorNombre.setText(" ");

        jLabelErrorGenre.setForeground(new java.awt.Color(255, 0, 51));
        jLabelErrorGenre.setText(" ");

        jLabelErrorCompany.setForeground(new java.awt.Color(255, 0, 51));
        jLabelErrorCompany.setText(" ");

        jLabelErrorDateRelease.setForeground(new java.awt.Color(255, 0, 51));
        jLabelErrorDateRelease.setText(" ");

        jLabelErrorPegi.setForeground(new java.awt.Color(255, 0, 51));
        jLabelErrorPegi.setText(" ");

        jLabelErrorPrecio.setForeground(new java.awt.Color(255, 0, 51));
        jLabelErrorPrecio.setText(" ");

        jLabelErrorDirImagen.setForeground(new java.awt.Color(255, 0, 51));
        jLabelErrorDirImagen.setText(" ");

        jLabelErrorDescripcion.setForeground(new java.awt.Color(255, 0, 51));
        jLabelErrorDescripcion.setText(" ");

        jButtonSaveGame.setBackground(new java.awt.Color(172, 213, 80));
        jButtonSaveGame.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButtonSaveGame.setText("Guardar");
        jButtonSaveGame.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonSaveGame.setFocusPainted(false);
        jButtonSaveGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveGameActionPerformed(evt);
            }
        });

        jButtonSaveGame1.setBackground(new java.awt.Color(197, 195, 192));
        jButtonSaveGame1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButtonSaveGame1.setText("Limpiar");
        jButtonSaveGame1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonSaveGame1.setFocusPainted(false);
        jButtonSaveGame1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveGame1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelErrorDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelErrorPegi, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jButtonSaveGame1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButtonSaveGame, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanelDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jSpinnerPegi, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFielName)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabelErrorNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBoxGenre, 0, 188, Short.MAX_VALUE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFielPrice))
                                    .addComponent(jLabelErrorGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelErrorPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBoxCompani, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelErrorCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(39, 39, 39)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelErrorDateRelease, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jDateChooserDateRelease, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabelImageAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelErrorDirImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFielDirImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFielName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxCompani, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooserDateRelease, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelErrorNombre)
                    .addComponent(jLabelErrorGenre)
                    .addComponent(jLabelErrorCompany)
                    .addComponent(jLabelErrorDateRelease))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinnerPegi, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFielPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelImageAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFielDirImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelErrorPegi)
                    .addComponent(jLabelErrorPrecio)
                    .addComponent(jLabelErrorDirImagen))
                .addGap(1, 1, 1)
                .addComponent(jLabelDireccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelErrorDescripcion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSaveGame, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSaveGame1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFielPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFielPriceKeyTyped
        // TODO add your handling code here:
        String linea = jTextFielPrice.getText();
        boolean tienePunto = false;
        if (linea.contains(".")) {
            tienePunto = true;
        }
        char c = evt.getKeyChar();
        if ((c == ',' || c == '.') && !tienePunto) {
            evt.setKeyChar('.');
        } else if (!Character.isDigit(c)) {
            evt.consume();
        }

    }//GEN-LAST:event_jTextFielPriceKeyTyped

    private void jTextFielPriceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFielPriceFocusGained
        // TODO add your handling code here:
        if (jTextFielPrice.getText().equalsIgnoreCase("Precio")) {
            jTextFielPrice.setText("");
        }
    }//GEN-LAST:event_jTextFielPriceFocusGained

    private void jTextFielPriceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFielPriceFocusLost
        // TODO add your handling code here:
        if (jTextFielPrice.getText().isBlank()) {
            jTextFielPrice.setText("Precio");
        }

    }//GEN-LAST:event_jTextFielPriceFocusLost

    private void jTextFielNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFielNameFocusGained
        // TODO add your handling code here:
        if (jTextFielName.getText().equalsIgnoreCase("Nombre")) {
            jTextFielName.setText("");
        }
    }//GEN-LAST:event_jTextFielNameFocusGained

    private void jTextFielNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFielNameFocusLost
        // TODO add your handling code here:
        if (jTextFielName.getText().isBlank()) {
            jTextFielName.setText("Nombre");
        }
    }//GEN-LAST:event_jTextFielNameFocusLost

    private void jTextFielDirImagenFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFielDirImagenFocusGained
        // TODO add your handling code here:
        if (jTextFielDirImagen.getText().equalsIgnoreCase("Dirección")) {
            jTextFielDirImagen.setText("");
        }
    }//GEN-LAST:event_jTextFielDirImagenFocusGained

    private void jTextFielDirImagenFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFielDirImagenFocusLost
        // TODO add your handling code here:
        if (jTextFielDirImagen.getText().isBlank()) {
            jTextFielDirImagen.setText("Dirección");
        }
    }//GEN-LAST:event_jTextFielDirImagenFocusLost

    private void jTextAreaDescripcionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextAreaDescripcionFocusGained
        // TODO add your handling code here:
        //Añade una descripcion del juego
        if (jTextAreaDescripcion.getText().equalsIgnoreCase("Añade una descripcion del juego")) {
            jTextAreaDescripcion.setText("");
        }

    }//GEN-LAST:event_jTextAreaDescripcionFocusGained

    private void jTextAreaDescripcionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextAreaDescripcionFocusLost
        // TODO add your handling code here:
        if (jTextAreaDescripcion.getText().isBlank()) {
            jTextAreaDescripcion.setText("Añade una descripcion del juego");
        }
    }//GEN-LAST:event_jTextAreaDescripcionFocusLost

    private void jButtonSaveGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveGameActionPerformed
        // TODO add your handling code here:

        if (comprobarFormulario()) {
            //Guardar El juego
            //System.out.println("GUARDAR BIEN");

            //CAMBIAR EL FORMATO DE LA FECHA
            //Creo un formato de fecha
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            // Almaceno en date la fecha con el formato nuevo
            String date = formatter.format(jDateChooserDateRelease.getDate());

            ControlerGame.addGame(
                    jTextFielName.getText(),
                    jComboBoxGenre.getSelectedItem().toString(),
                    date,
                    jComboBoxCompani.getSelectedItem().toString(),
                    jSpinnerPegi.getValue().toString(),
                    jTextAreaDescripcion.getText(),
                    jTextFielDirImagen.getText(),
                    Double.parseDouble(jTextFielPrice.getText())
            );
            ControlerGame.grabar_coleccion_en_fichero();
            
            //Mensaje de Juego Guardado correctamente.
            JOptionPane jop = new JOptionPane("Juego guardado correctamente ", JOptionPane.INFORMATION_MESSAGE);
            JDialog jd = jop.createDialog("Exito");
            jd.setLocationRelativeTo(null);
            jd.setVisible(true);
            
            
            
        } else {
            //System.out.println("GUARDAR NO ESTA BIEN");
        }

    }//GEN-LAST:event_jButtonSaveGameActionPerformed


    private void jLabelImageAddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImageAddMousePressed

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(AddGame.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Creamos el objeto JFileChooser
        JFileChooser fc = new JFileChooser();

        //Indicamos lo que podemos seleccionar
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        //Creamos el filtro
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.png", "png");

        //Le indicamos el filtro
        fc.setFileFilter(filtro);

        //Abrimos la ventana, guardamos la opcion seleccionada por el usuario
        int seleccion = fc.showOpenDialog(this);

        //Si el usuario, pincha en aceptar
        if (seleccion == JFileChooser.APPROVE_OPTION) {

            //Seleccionamos el fichero
            File fichero = fc.getSelectedFile();
            String ruta = fichero.getAbsolutePath();

            Path origenPath = FileSystems.getDefault().getPath(ruta);
            Path destinoPath = FileSystems.getDefault().getPath("repoImagesGames/" + fichero.getName());

            try {
                Files.copy(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);

                ruta = "repoImagesGames/" + fichero.getName();
                //Ecribe la ruta del fichero seleccionado en el campo de texto
                jTextFielDirImagen.setText(fichero.getAbsolutePath());

            } catch (IOException ex) {
                Logger.getLogger(AddGame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_jLabelImageAddMousePressed

    private void jTextFielNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFielNameKeyReleased
        // TODO add your handling code here:
        if (ControlerGame.gameExist(jTextFielName.getText())) {
            //Si devuelve true el juego ya existe y esta añadido
            jLabelErrorNombre.setText("El juego ya esta añadido");
        } else {
            jLabelErrorNombre.setText(" ");
        }
    }//GEN-LAST:event_jTextFielNameKeyReleased

    private void jButtonSaveGame1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveGame1ActionPerformed
        // TODO add your handling code here:
        limparFormulario();
    }//GEN-LAST:event_jButtonSaveGame1ActionPerformed

    private void limparFormulario(){
        jTextFielName.setText("Nombre");
        jTextFielPrice.setText("Precio");
        jTextAreaDescripcion.setText("Añade una descripcion del juego");
        jTextFielDirImagen.setText("Dirección");
        jComboBoxCompani.setSelectedIndex(0);
        jComboBoxGenre.setSelectedIndex(0);
        //jSpinnerPegi.Get
        
    }
    
    private boolean comprobarFormulario() {

        boolean comprobar = true;

        if (!comprobarNombre()) {
            if (comprobar) {
                comprobar = false;
            }
        }
        if (!comprobarGenero()) {
            if (comprobar) {
                comprobar = false;
            }
        }
        if (!comprobarCompany()) {
            if (comprobar) {
                comprobar = false;
            }
        }
        if (!comprobarPegi()) {
            if (comprobar) {
                comprobar = false;
            }
        }
        if (!comprobarPrecio()) {
            if (comprobar) {
                comprobar = false;
            }
        }
        if (!comprobarDateReleace()) {
            if (comprobar) {
                comprobar = false;
            }
        }
        if (!comprobarDirImagen()) {
            if (comprobar) {
                comprobar = false;
            }
        }
        if (!comprobarDescripcion()) {
            if (comprobar) {
                comprobar = false;
            }
        }

        return comprobar;
    }

    private boolean comprobarNombre() {

        String nombre = jTextFielName.getText();

        ControlerGame.listarJuegos();

        if (nombre.equalsIgnoreCase("Nombre") || nombre.isBlank() || nombre == null) {
            jLabelErrorNombre.setText("Introduce el nombre del Juego");
            return false;
        }
        if (ControlerGame.gameExist(nombre)) {
            //Si devuelve true el juego ya existe y esta añadido
            jLabelErrorNombre.setText("El juego ya esta añadido");
            return false;
        }

        jLabelErrorNombre.setText(" ");
        return true;
    }

    private boolean comprobarGenero() {

        if (jComboBoxGenre.getSelectedIndex() == 0) {
            jLabelErrorGenre.setText("Selecciona un Genero");
            return false;
        } else {
            jLabelErrorGenre.setText(" ");
            return true;
        }
    }

    private boolean comprobarCompany() {

        if (jComboBoxCompani.getSelectedIndex() == 0) {
            jLabelErrorCompany.setText("Selecciona una Compañia");
            return false;
        } else {
            jLabelErrorCompany.setText(" ");
            return true;
        }
    }

    private boolean comprobarPegi() {

        if (jSpinnerPegi.getValue().toString().equals("< Seleccionar >")) {
            jLabelErrorPegi.setText("Selecciona categoria PEGI");
            return false;
        } else {
            jLabelErrorPegi.setText(" ");
            return true;
        }
    }

    private boolean comprobarPrecio() {

        String precio = jTextFielPrice.getText();

        if (precio.equalsIgnoreCase("Precio") || precio.isBlank() || precio == null) {
            jLabelErrorPrecio.setText("Introduce un precio");
            return false;
        } else {
            //Si devuelve true el juego ya existe y esta añadido
            jLabelErrorPrecio.setText(" ");
        }
        return true;
    }

    private boolean comprobarDateReleace() {

        //si la fecha no esta null (no fecha seleccionada)
        if (jDateChooserDateRelease.getDate() == null) {
            jLabelErrorDateRelease.setText("Introduce una fecha correcta");
            return false;
        } else {
            jLabelErrorDateRelease.setText(" ");
            return true;
        }
    }

    private boolean comprobarDirImagen() {

        String dirImg = jTextFielDirImagen.getText();

        if (dirImg.equalsIgnoreCase("Dirección") || dirImg.isBlank() || dirImg == null) {
            jLabelErrorDirImagen.setText("Introduce una Imagen correcta");
            return false;
        } else {
            //Si devuelve true el juego ya existe y esta añadido
            jLabelErrorDirImagen.setText(" ");
        }
        return true;
    }

    private boolean comprobarDescripcion() {

        String descipcion = jTextAreaDescripcion.getText();

        if (descipcion.equalsIgnoreCase("Añade una descripcion del juego") || descipcion.isBlank() || descipcion == null) {
            jLabelErrorDescripcion.setText("Introduce una descripcion");
            return false;
        } else {
            jLabelErrorDescripcion.setText(" ");
        }

        return true;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Titulo;
    private javax.swing.JButton jButtonSaveGame;
    private javax.swing.JButton jButtonSaveGame1;
    private javax.swing.JComboBox<String> jComboBoxCompani;
    private javax.swing.JComboBox<String> jComboBoxGenre;
    private com.toedter.calendar.JDateChooser jDateChooserDateRelease;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelErrorCompany;
    private javax.swing.JLabel jLabelErrorDateRelease;
    private javax.swing.JLabel jLabelErrorDescripcion;
    private javax.swing.JLabel jLabelErrorDirImagen;
    private javax.swing.JLabel jLabelErrorGenre;
    private javax.swing.JLabel jLabelErrorNombre;
    private javax.swing.JLabel jLabelErrorPegi;
    private javax.swing.JLabel jLabelErrorPrecio;
    private javax.swing.JLabel jLabelImageAdd;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelDescripcion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerPegi;
    private javax.swing.JTextArea jTextAreaDescripcion;
    private javax.swing.JTextField jTextFielDirImagen;
    private javax.swing.JTextField jTextFielName;
    private javax.swing.JTextField jTextFielPrice;
    // End of variables declaration//GEN-END:variables
}
