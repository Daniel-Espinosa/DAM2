/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp_ejercicios_repaso.Contraseña;

import java.util.regex.Pattern;

/**
 *
 * @author produccion
 */
public class ComprobarContraseñaConREGEX {

    private static String contraseña;

    /*
    private static final Pattern[] inputRegexes = new Pattern[4];

    static {
        inputRegexes[0] = Pattern.compile(".*[A-Z].*");
        inputRegexes[1] = Pattern.compile(".*[a-z].*");
        inputRegexes[2] = Pattern.compile(".*\\d.*");
        inputRegexes[3] = Pattern.compile(".*[-_$].*");
    }
     */
    private static boolean comprobarLongitud() {

        if (contraseña.matches(".{8,}")) {
            return true;
        }
        return false;

    }

    private static boolean comprobarMinus() {

        if (contraseña.matches(".*[a-z].*")) {
            return true;
        }
        return false;
    }

    private static boolean comprobarMayus() {

        if (contraseña.matches(".*[A-Z].*")) {
            return true;
        }
        return false;
    }

    private static boolean comprobarNumero() {

        if (contraseña.matches(".*[\\d].*")) {
            return true;
        }
        return false;
    }

    private static boolean comprobarSimbolo() {

        if (contraseña.matches(".*[-].*") || contraseña.matches(".*[_].*") || contraseña.matches(".*[$].*")) {
            return true;
        }
        return false;
    }

    
    public static boolean comprobarContraseñaConRegex() {

        if (!comprobarLongitud()) {
            System.out.println("la contraseña tiene que tener minimo 8 caracteres");
            return false;
        }

        if (!comprobarMayus()) {
            System.out.println("Tiene que contener al menos una mayuscula");
            return false;
        }

        if (!comprobarMinus()) {
            System.out.println("Tiene que contener al menos una minuscula");
            return false;
        }

        if (!comprobarSimbolo()) {
            System.out.println("Tiene que contener al menos un simbolo");
            return false;
        }

        if (!comprobarNumero()) {
            System.out.println("Tiene que contener al menos un numero");
            return false;
        }

        System.out.println("¡Contraseña correcta!");
        return true;

    }

    public static void setContraseña(String contraseña) {
        ComprobarContraseñaConREGEX.contraseña = contraseña;
    }
    
    
}

