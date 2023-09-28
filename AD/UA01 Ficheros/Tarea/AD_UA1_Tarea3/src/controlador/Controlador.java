/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controlador;

import entidades.Producto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import vista.JFrameVista;

/**
 *
 * @author damt207
 */
public class Controlador implements ActionListener {

    private static JFrameVista vista = new JFrameVista();
    private static ProductoModel producModel = new ProductoModel();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Controlador c = new Controlador();
        c.iniciar();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(vista.jButtonCancelar)) {
            botonCancelar();
        } else if (e.getSource().equals(vista.jButtonGuardar)) {
            botonGuardar();
        }

        /*
        if (e.getActionCommand() == "Cancelar") {
            botonCancelar();
        } else if (e.getActionCommand() == "Guardar") {
            botonGuardar();
        }
         */
    }

    private void iniciar() {

        vista.setTitle("Inventario Productos");
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        vista.jButtonGuardar.addActionListener(this);
        vista.jButtonCancelar.addActionListener(this);
        producModel.leerFichero();
        actualizarTabla();

    }

    private void botonGuardar() {

        if (comprobarCampoNombre() != false && comprobarCampoPrecio() != false) {
            producModel.escribirFichero(vista.jTextFieldNombre.getText(), Double.parseDouble(vista.jTextFieldPrecio.getText()));
            actualizarTabla();
            vista.jTextFieldNombre.setText("");
            vista.jTextFieldPrecio.setText("");
            vista.jTextFieldNombre.requestFocus();
        }

    }

    private void botonCancelar() {
        vista.dispose();
    }

    private void actualizarTabla() {
 
        DefaultTableModel modelo = (DefaultTableModel) vista.jTable1.getModel();
        
        for (int i = modelo.getRowCount() - 1; i >= 0; i--) {
                modelo.removeRow(i);
            }

        for (Producto i : ProductoModel.getLista()) {
            String[] row = new String[2];
            row[0] = i.getNombre();
            row[1] = String.valueOf(i.getPrecio());
            modelo.addRow(row);
        }

    }

    private boolean comprobarCampoNombre() {

        if (vista.jTextFieldNombre.getText().isBlank()) {
            errorCampoNombreVacio();

        } else {
            return true;
        }

        return false;
    }

    private boolean comprobarCampoPrecio() {

        if (vista.jTextFieldPrecio.getText().isBlank()) {
            errorCampoPrecioVacio();
            return false;
        }

        if (vista.jTextFieldPrecio.getText().contains(",")) {
            errorCampoPrecioConComa();
            return false;
        }

        try {
            double precio = Double.parseDouble(vista.jTextFieldPrecio.getText());
        } catch (NumberFormatException e) {
            errorCampoPrecioConTexto();
            return false;
        }

        return true;

    }

    private void errorCampoNombreVacio() {
        JOptionPane jop = new JOptionPane("El campo nombre no puede estar vacio", JOptionPane.ERROR_MESSAGE);
        JDialog jd = jop.createDialog("ERROR");
        jd.setLocationRelativeTo(null);
        jd.setVisible(true);
    }

    private void errorCampoPrecioVacio() {
        JOptionPane jop = new JOptionPane("El precio no puede estar vacio", JOptionPane.ERROR_MESSAGE);
        JDialog jd = jop.createDialog("ERROR");
        jd.setLocationRelativeTo(null);
        jd.setVisible(true);
    }

    private void errorCampoPrecioConComa() {
        JOptionPane jop = new JOptionPane("El precio no puede contener COMA ',' utiliza PUNTO '.' ", JOptionPane.ERROR_MESSAGE);
        JDialog jd = jop.createDialog("ERROR");
        jd.setLocationRelativeTo(null);
        jd.setVisible(true);
    }

    private void errorCampoPrecioConTexto() {
        JOptionPane jop = new JOptionPane("El precio no puede contener letras", JOptionPane.ERROR_MESSAGE);
        JDialog jd = jop.createDialog("ERROR");
        jd.setLocationRelativeTo(null);
        jd.setVisible(true);
    }

}
