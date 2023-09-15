/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp_ejercicios_repaso.Contraseña;

/**
 *
 * @author damt207
 */
public class ComprobarContraseñaSinREGEX {

    private static String contraseña;

    private static boolean comprobarLongitud() {

        if (contraseña.length() < 8) {
            return false;
        }
        return true;
    }

    private static boolean comprobarMinus() {

        for (int i = 0; i < contraseña.length(); i++) {
            if (Character.isLowerCase(contraseña.charAt(i))) {
                return true;
            }

        }
        return false;
    }

    private static boolean comprobarMayus() {

        for (int i = 0; i < contraseña.length(); i++) {
            if (Character.isUpperCase(contraseña.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean comprobarNumero() {

        for (int i = 0; i < contraseña.length(); i++) {
            if (Character.isDigit(contraseña.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean comprobarSimbolo() {

        for (int i = 0; i < contraseña.length(); i++) {
            if (contraseña.charAt(i) == '$' || contraseña.charAt(i) == '-' || contraseña.charAt(i) == '_') {
                return true;
            }
        }
        return false;
    }

    public static boolean comprobarContraseñaSinRegex() {

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
        ComprobarContraseñaSinREGEX.contraseña = contraseña;
    }

    public static String getContraseña() {
        return contraseña;
    }

}
