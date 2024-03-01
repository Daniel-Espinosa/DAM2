/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.cafeconpalito.psp_tema5_tarea3_trabajofinal;

import com.cafeconpalito.psp_tema5_tarea3_trabajofinal.Metodos.Logs;

/**
 *
 * @author damt207
 */
public class App {

    public static void main(String[] args) {

        Logs.openLogs();
        
        viewApp app = new viewApp();
        app.setVisible(true);
        
        Logs.closeLogs();
    }

}
