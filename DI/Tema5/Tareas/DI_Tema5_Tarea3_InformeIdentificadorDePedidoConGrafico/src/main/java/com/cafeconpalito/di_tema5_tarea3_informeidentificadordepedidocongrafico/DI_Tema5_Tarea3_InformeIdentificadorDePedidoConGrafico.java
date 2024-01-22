/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cafeconpalito.di_tema5_tarea3_informeidentificadordepedidocongrafico;

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
public class DI_Tema5_Tarea3_InformeIdentificadorDePedidoConGrafico {

    public static void main(String[] args) {
        try {
            
            Connection con = ConexionBBDD.getInstance().getConnection();
            
            Map parametros = new HashMap();
            parametros.put("FILTRO_ID_PEDIDO", 4);
            
            JasperPrint print = JasperFillManager.fillReport("informes/Tema5_Tarea3.jasper", parametros, con);
            JasperExportManager.exportReportToPdfFile(print, "Tema5_Tarea3.pdf");
            
        } catch (JRException ex) {
            Logger.getLogger(DI_Tema5_Tarea3_InformeIdentificadorDePedidoConGrafico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
