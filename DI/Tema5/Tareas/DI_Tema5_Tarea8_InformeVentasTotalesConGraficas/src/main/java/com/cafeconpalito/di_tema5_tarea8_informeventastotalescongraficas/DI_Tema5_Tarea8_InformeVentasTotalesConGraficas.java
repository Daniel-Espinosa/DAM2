/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.cafeconpalito.di_tema5_tarea8_informeventastotalescongraficas;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author damt207
 */
public class DI_Tema5_Tarea8_InformeVentasTotalesConGraficas {

    public static void main(String[] args) {
        try {

            Connection con = ConexionBBDD.getInstance().getConnection();

            Map parametros = new HashMap();
            
            parametros.put("Filtro", 1);

            JasperPrint print = JasperFillManager.fillReport("informes/Tema5_Tarea8.jasper", parametros, con);
            JasperExportManager.exportReportToPdfFile(print, "Tema5_Tarea8.pdf");

        } catch (JRException ex) {
            Logger.getLogger(DI_Tema5_Tarea8_InformeVentasTotalesConGraficas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
