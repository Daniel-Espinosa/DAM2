/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package codigossueltos;

/**
 *
 * @author damt207
 */
public class CodigosSueltos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //Reescalado de imagen
        /*
        //Marcos
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabel1, "src/main/java/img/botin.png");
       
        ImageIcon image = new ImageIcon("src/main/java/img/botin.png");
        Image imgEscalada =  image.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), WIDTH);
        ImageIcon imgFinal = new ImageIcon(imgEscalada);
        jLabel1.setIcon(imgFinal);
        
        //Sergio
        ImageIcon image = new ImageIcon("src/img/Botin.png");
          Image imgEscalada =  image.getImage().getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), WIDTH);
          ImageIcon imgFinal = new ImageIcon(imgEscalada);
          jLabel2.setIcon(imgFinal);
        
         */
        //ICONO Ventana
        /*
        @Override
        public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Images/logo.png"));
        return retValue;
        }
        
         */
        
        
        // MENSAJE DE ERROR
        /*
        private void errorMensaje(String campo) {
        JOptionPane jop = new JOptionPane("Error en el campo " + campo, JOptionPane.ERROR_MESSAGE);
        JDialog jd = jop.createDialog("ERROR");
        jd.setLocationRelativeTo(null);
        jd.setVisible(true);
        }
        */
        
        
        //COMPROBAR TEXTO SIN NUMEROS Y NO BLANCOS
        /*
        private boolean comprobarApellido2() {
        if (jTextFieldApellido2.getText().isBlank()) {
            errorMensaje("segundo apellido esta en blanco");
            return false;
        }
        if (jTextFieldApellido2.getText().matches(".*\\d.*")) {
            errorMensaje("segundo apellido contiene numeros");
            return false;
        }
        return true;
        */
                
        
        //Solo permite numeros y puntos (Cambia la , por un punto)
        
        /*
                String linea = jTextFielPrice.getText();
        boolean tienePunto = false;
        if (linea.contains(".")) {
            tienePunto = true;
        }       
        char c = evt.getKeyChar();
        if ((c == ',' || c == '.') && !tienePunto){
            evt.setKeyChar('.');
        } else if (!Character.isDigit(c)) {
            evt.consume();
        }
        */
        
        
        
    }

}
