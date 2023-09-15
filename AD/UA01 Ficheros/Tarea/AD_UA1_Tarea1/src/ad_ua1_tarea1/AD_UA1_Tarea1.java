/*
Hoja de ejercicios 1. Ficheros de texto.
1. Crea un método en java que escriba en un fichero de texto.
2. Crea un método en java que lea un fichero de texto línea a línea.
3. Crea un método en java que escriba en un fichero de configuración los parámetros de
conexión utilizando las propiedades de setProperty de System Properties.
USER = administrador
PASSW = Admin-123
SERVER = localhost
PORT = 3306
4. Crea un método en java que lea las propiedades de un fichero de propiedades.props
*/
package ad_ua1_tarea1;

import java.util.Scanner;

/**
 *
 * @author damt207
 */
public class AD_UA1_Tarea1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            
            String nombreCreacion;
            String texto;
        
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Dame un nombre para el archivo(no es necesario añadir la extencion)");
            nombreCreacion = sc.nextLine();
            
            System.out.println("\nIntroduce el texto que quieres añadir al archivo");
            texto = sc.nextLine();
            Metodos.createFile(nombreCreacion, texto);
            
            System.out.println("\nLectura del archivo creado");
            Metodos.readFile(nombreCreacion);
            
            System.out.println("\nCreando archivo propiedades.props");
            Metodos.ficheroConfigEscritura();
            System.out.println("\nLectura del archivo propiedades.props");
            Metodos.ficheroConfigLectura();
        
    }
    
}
