/*
8. En este ejercicio el estudiante debe crear un programa que:
• Abra una aplicación introducida por argumento (String[] args), por ejemplo “Notepad”
en Windows o “gedit” en Linux.
• 10 segundos después se cerrará el proceso (con código no a mano)
• Después de que la app se cierre, el programa espera 5 segundo y se imprimirá “Buenas
noches amigo!”
 */
package com.cafeconpalito.psp_tema1_ejercicios;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt207
 */
public class Ejercicio8 {

    public static void ej8() {

        String operatingSystem = System.getProperty("os.name").toLowerCase();

        if (operatingSystem.contains("win")) {
            sistemaWindows();
        }

        if (operatingSystem.contains("nux")) {
            sistemaLinux();
        }
        try {
            
            Thread.sleep(50);
        
        } catch (InterruptedException ex) {
            Logger.getLogger(Ejercicio8.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("¡Buenas noches amigo!");

    }

    private static void sistemaWindows() {

        Runtime rt = Runtime.getRuntime();
        String[] comando = {"notepad.exe"};
        try {
            Process p = rt.exec(comando);
            ProcessHandle ph = p.toHandle();
            
            if (!p.waitFor(10, TimeUnit.SECONDS)) {
                p.destroy();
            }

            Thread.sleep(5000);
            
            
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Ejercicio8.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void sistemaLinux() {

        Runtime rt = Runtime.getRuntime();
        String[] comando = {"gedit"};
        try {
            Process p = rt.exec(comando);
            ProcessHandle ph = p.toHandle();
            p.waitFor(10, TimeUnit.SECONDS);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Ejercicio8.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
