/*
Tiempo de realización: 1 hora y 15 minutos.

SE PIDE:

1. EJERCICIO 1. Realiza un programa en java que muestre por pantalla el nombre del Sistema Operativo,
del usuario y cambie el nombre del usuario por tu nombre y dos apellidos y establezca un nuevo directorio de trabajo.

Criterios de evaluación:

Se han utilizado clases para la gestión de ficheros y directorios (2 puntos)
Pregunta: Explica y justifica.
¿Qué diferencia hay entre el flujo basado en caracteres y el flujo basado en bytes?
Criterio de evaluación:

Se han valorado las ventajas y los inconvenientes de las distintas formas de acceso. (2 puntos)
 */
package tema1_examen1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author damt207
 */
public class Tema1_Examen1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Escritura de archivo
        File archivo = new File("Ejercicio1.txt");
        
        FileWriter fw = null;
        
        try {
            fw = new FileWriter(archivo);
            fw.write("Sistema Operativo: " + System.getProperty("os.name"));
            fw.write("\nNombre del usuario: " + System.getProperty("user.name"));
            fw.write("\nDirectorio de trabajo: " + System.getProperty("user.dir"));
        } catch (IOException e) {
            System.err.println("IOException");
        } finally {
            try {
                if (fw!=null) {
                    fw.close();
                }
            } catch (IOException e) {
                System.err.println("IOException cierre flujo");
            }
        }
        
        
        //Realiza un programa en java que muestre por pantalla el nombre del Sistema Operativo,
        System.out.println("\nSistema Operativo: " + System.getProperty("os.name"));
        
        //Nombre del usuario
        System.out.println("\nNombre del usuario: " + System.getProperty("user.name"));
        
        //Cambiando nombre del usuario
        System.setProperty("user.name","Daniel Espinosa Garcia");
        
        //mostrando el nombre cambiado.
        System.out.println("\nNombre del usuario CAMBIADO: " + System.getProperty("user.name"));
        
        //Mostrando directorio de trabajo  
        System.out.println("\nDirectorio de trabajo: " + System.getProperty("user.dir"));
        
        //Cambiando directorio de trabajo
        System.setProperty("user.dir","d:\\Users\\DAMT207\\Desktop\\");
        
        //Mostrando directorio de trabajo Cambiado
        System.out.println("\nDirectorio de trabajo CAMBIADO: " + System.getProperty("user.dir"));
    
        

        
        
        
    }

}
