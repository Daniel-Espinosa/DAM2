/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad4tejemplobd;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author marina
 */
public class tools {

    public static Date parseUtilDate(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date lafecha = null;       
        
        try {
            lafecha = formato.parse(fecha);
        } catch (ParseException ex) {
            System.out.println("Error al formatear la fecha");
        }
       
        return  lafecha;
    }

}
