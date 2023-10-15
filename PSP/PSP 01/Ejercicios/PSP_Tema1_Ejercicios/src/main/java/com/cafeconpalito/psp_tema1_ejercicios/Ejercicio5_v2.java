/*
5. Utilizando la clase ProcessBuilder ejecuta el comando “CMD /c ver” y redirige la salida
estándar a un fichero llamado “salida.txt” y la salida de error a un fichero llamado “error.txt”.
Para ello, utiliza los métodos redirectOutput y redirectError de ProcessBuilder. Ejecuta después
un comando que no exista como por ejemplo “CMD /c verr”.
 */
package com.cafeconpalito.psp_tema1_ejercicios;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt207
 */
public class Ejercicio5_v2 {

    public static void MetodoProcessBuilder() {
        ProcessBuilder pb = new ProcessBuilder("CMD", "/c", "ver");
        //ProcessBuilder pb = new ProcessBuilder("CMD", "/c" , "verr" );

        //pb.redirectOutput(new File("salida.txt"));
        //pb.redirectError(new File("error.txt"));

        try {
            
            Process p = pb.start();

            InputStream is = p.getInputStream();

            InputStreamReader isr = new InputStreamReader(is);

            BufferedReader br = new BufferedReader(isr);

            String linea = null;

            linea = br.readLine();

            while (linea != null) {
                System.out.println(linea);
                linea = br.readLine();
            }

        } catch (IOException ex) {
            Logger.getLogger(Ejercicio5_v2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
