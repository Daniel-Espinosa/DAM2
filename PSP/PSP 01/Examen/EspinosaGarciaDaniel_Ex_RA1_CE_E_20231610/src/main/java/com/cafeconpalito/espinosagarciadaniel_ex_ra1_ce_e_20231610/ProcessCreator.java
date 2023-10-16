/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.espinosagarciadaniel_ex_ra1_ce_e_20231610;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt207
 */
public class ProcessCreator {

    private ProcessBuilder pbGenerator;
    private ProcessBuilder pbCopiar;
    private ProcessBuilder pbAbrirFichero;
    

    public ProcessCreator(String generator, String txt, String copiatxt) {

         String command1 = "java -jar " + generator + " " + txt;
         String command2 = "copy " + txt + " " + copiatxt;
        //Creando un PB al cual controlaremos el flujo de salida (retorno de la consola para leerlo mostrarlo por pantalla y escribirlo en un fichero)           
        pbGenerator = new ProcessBuilder("CMD", "/c", command1);
        pbCopiar = new ProcessBuilder("CMD", "/c", command2);
        pbAbrirFichero = new ProcessBuilder("notepad.exe", copiatxt);
    }
    
    
    //Bloquea el proceso y salida del valor de fin de proceso
    public void blockProcess(Process p) {
        
        try {
            int valorProceso = p.waitFor();
            System.out.println("Valor de fin de proceso = " + valorProceso);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProcessCreator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    //pid del proceso
    public void pidProcess(Process p) {
        
        System.out.println("Pid del Proceso = " + p.pid());p.pid();

    }

    
    /*
    Para hacer la copia del fichero no lo haremos nosotros con código, sino que, utilizaremos un comando
de Windows que ya hace la copia por nosotros. Por tanto, se ejecutará el siguiente comando de
Windows de la terminal que hace la copia de un fichero (primer parámetro) en otro fichero cuyo
nombre se establece en el segundo parámetro:
a. Windows: cmd /c copy /ruta/nombreFicheroAleatorios.txt /ruta/nombreFicheroCopia.txt
    
     */
    public void launchCreandoCopia() {
        
        Process p = null;
        
        try {
            p= pbCopiar.start();
            /*
            if (p.exitValue()==0) {
                System.out.println("Copia realizada con éxito");
            } else {
                System.out.println("Error en la copia");
            }
            */
            
        } catch (IOException ex) {
            Logger.getLogger(ProcessCreator.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void launchAbriendoCopia(){
        Process p = null;
        
        try {
            p= pbAbrirFichero.start();
        } catch (IOException ex) {
            Logger.getLogger(ProcessCreator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Punto 4 y 5
    public void launchProcessGenerator() {

    Process p = null;
        try {

            String linea = null;

            //Capturo todo lo que devuelve el hijo. y lo muestro por pantalla
            p = pbGenerator.start();

            // declaramos los Flujos dentro del Try con "try-with-resources" para que cierre los flujos al finalizar el Try.
            try (InputStream is = p.getInputStream(); BufferedReader br = new BufferedReader(new InputStreamReader(is));) {

                //Inicio de lectura linea a linea
                linea = br.readLine();
                //comienza a capturar el retorno del CMD y lo imprime por pantalla y lo escribe en el fichero.

                while (linea != null) {
                    //mostrando las lineas por consola
                    System.out.println(linea);
                    //escribiendo en el fichero cada linea
                    //fw.write(linea + "\n");
                    linea = br.readLine();

                }
                

            } catch (IOException e) {
                System.err.println("IOEX2");
            }

        } catch (IOException ex) {
            System.err.println("IOEX1");
        }

    }

}
