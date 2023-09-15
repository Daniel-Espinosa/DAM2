/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author produccion
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        File archivo = new File("F_W_R_ejemplo.txt");

        //file reader
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(archivo);
            
            System.out.println("Lectura Caracter a Caracter");
//bucle para leer la informacion caracter a caracter
//se necesita almacenar esta informacion en un int
            int caracter;
            String cadena = "";
            while ((caracter = fr.read()) > 0) {
                //recasteo el valor a un char para imprimirlo lo almaceno en un String
                cadena += (char) caracter;
            }
            System.out.println(cadena);

            System.out.println("\nLectura Linea A Linea");
            
            String cadena2;
//bucle para leer linea a linea se necesita introducir un BufferReader se le pasa como parametro el FileReader
            br = new BufferedReader(new FileReader(archivo));
            while ((cadena2 = br.readLine()) != null) {
                System.out.println(cadena2);
            }

        } catch (FileNotFoundException e) {
            System.err.println("el archivo no existe");
        } catch (IOException e) {
            System.err.println("IOException");
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                System.err.println("IOException cierre flujo");
            }
        }

    }

}
