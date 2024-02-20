/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.psp_tema5_tarea3_trabajofinal.Metodos;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author damt207
 */
public class Logs {

    /**
     * Generar un log con los errores (excepciones) del programa y otro con la
     * actividad del usuario en el tiempo.
     */
    public static final Logger LOGGER_ERRORS = Logger.getLogger("LoggerErros");

    /**
     * Generar un log con la actividad del usuario en el tiempo.
     */
    public static final Logger LOGGER_USER = Logger.getLogger("LoggerUser");

    private static FileHandler fileHandlerErrors = null;
    private static FileHandler fileHandlerUser = null;

    //Añado info al log
    //LOGGER_ERRORS.warning("Este es un mensaje de advertencia.");
    //LOGGER_ERRORS.severe("Este es un mensaje de error.");
    //Añado la info al log
    //LOGGER_USER.info("Este es un mensaje de informacion.");
    
    /**
     * Metodo para inicializar los logs y abrir los flujos.
     */
    public static void openLogs() {

        try {
            
            File logsPath = new File("logs");
            if (!logsPath.isDirectory()) {
                logsPath.mkdir();
            }

            //Formato para guardar el error
            SimpleFormatter formatter = new SimpleFormatter();

            //Log ERRORES, defino el nombre del archivo.
            fileHandlerErrors = new FileHandler("logs/logsErrors.txt", true);
            LOGGER_ERRORS.addHandler(fileHandlerErrors);
            fileHandlerErrors.setFormatter(formatter);

            //Log USUARIO, defino el nombre del archivo.
            fileHandlerUser = new FileHandler("logs/logsUser.txt", true);
            LOGGER_USER.addHandler(fileHandlerUser);
            fileHandlerUser.setFormatter(formatter);

            //Para que solo salgan por el output los mensajes de error Severos.
            LOGGER_ERRORS.setLevel(Level.SEVERE);
            
            //CON ESTO NO MUESTRA POR CONSOLA LOS MESAJES DEL USUARIO PERO SI LOS REGISTRA
            //FALSE para que no los muestre por pantalla pero si los registra.
            LOGGER_USER.setUseParentHandlers(false);
            
        } catch (IOException | SecurityException ex) {
            //Logger.getLogger(PSP_Tema5_Tarea3_TrabajoFinal.class.getName()).log(Level.SEVERE, null, ex);
            LOGGER_ERRORS.log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Metodo para cerrar los flujos.
     */
    public static void closeLogs() {

        fileHandlerErrors.close();
        fileHandlerUser.close();

    }

}

