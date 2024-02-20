/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.cafeconpalito.psp_tema5_tarea3_trabajofinal;

import com.cafeconpalito.psp_tema5_tarea3_trabajofinal.Metodos.HashTool;
import com.cafeconpalito.psp_tema5_tarea3_trabajofinal.Metodos.Logs;
import java.util.logging.Level;

/**
 *
 * @author damt207
 */
public class PSP_Tema5_Tarea3_TrabajoFinal {

    
    public static void main(String[] args) {
                
        Logs.openLogs();
        
        //HashTool.getAlgorithms();
        
        HashTool.getStringHash("MD5", "ERA UN DOMINGO EN LA TARDE EN LOS COCHES DE CHOQUE PRIPAIRIAPRA");
        
        Logs.closeLogs();

    }
    

}
