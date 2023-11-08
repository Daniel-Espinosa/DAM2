/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package di_tarea_3_1_jpanelusuario.Main;

import controlador.ControlerUser;
import entidad.User;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author damt207
 */
public class Main {
    
    public static User usuarioLogin = new User(null, null, null,null);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here


        //Añado Usuarios
        /*
        ControlerUser.addUsuario("Damt207", "12345", "Daniel Espinosa Garcia","daniel.png");
        ControlerUser.addUsuario("CafeOld", "1234", "CafeConPalito 1º","logo-old.png");
        ControlerUser.addUsuario("CafeNew", "1234", "CafeConPalito 2º","logo-simple.png");
        ControlerUser.grabar_coleccion_en_fichero();
        */
        
        
        
        Login vista = new Login();
        vista.setVisible(true);
        
    }

}
