/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.psp_tema5_tarea3_trabajofinal.Metodos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author damt207
 */
public class PasswordValidator {

    //
    private static final String PASS_REGEX ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#*_$%^&+=!])(?=\\S+$).{8,}$";
    
    /**
     * La contraseña introducida por el usuario será analizada por el programa
     * para comprobar que es segura, y en caso contrario informarle de que no es
     * segura y qué condiciones reúne una contraseña segura.
     * @param pass Contraseña para validar
     * @return True si la contraseña es valida
     */
    public static boolean validate(String pass){
        
        Pattern p = Pattern.compile(PASS_REGEX);
        Matcher m = p.matcher(pass);
        
        return m.matches();
        
    } 
    
}
