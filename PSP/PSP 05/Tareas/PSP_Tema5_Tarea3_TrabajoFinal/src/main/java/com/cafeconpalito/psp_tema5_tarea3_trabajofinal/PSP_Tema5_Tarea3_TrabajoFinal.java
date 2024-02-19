/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.cafeconpalito.psp_tema5_tarea3_trabajofinal;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author damt207
 */
public class PSP_Tema5_Tarea3_TrabajoFinal {

    public static final Logger LOGGER_ERRORS = Logger.getLogger("LoggerErros");
    public static final Logger LOGGER_USER = Logger.getLogger("LoggerUser");

    public static void main(String[] args) {
        FileHandler fileHandlerErrors = null;
        FileHandler fileHandlerUser = null;

        try {

            SimpleFormatter formatter = new SimpleFormatter();

            //Log ERRORES
            fileHandlerErrors = new FileHandler("logsErrors.txt", true);
            LOGGER_ERRORS.addHandler(fileHandlerErrors);
            fileHandlerErrors.setFormatter(formatter);

            //Añado info al log
            LOGGER_ERRORS.warning("Este es un mensaje de advertencia.");
            LOGGER_ERRORS.severe("Este es un mensaje de error.");

            //Log USUARIO
            fileHandlerUser = new FileHandler("logsUser.txt", true);
            LOGGER_USER.addHandler(fileHandlerUser);
            fileHandlerUser.setFormatter(formatter);

            //Añado la info al log
            LOGGER_USER.info("Este es un mensaje de informacion.");


        } catch (IOException ex) {
            Logger.getLogger(PSP_Tema5_Tarea3_TrabajoFinal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(PSP_Tema5_Tarea3_TrabajoFinal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            fileHandlerErrors.close();
            fileHandlerUser.close();

        }

    }
}
