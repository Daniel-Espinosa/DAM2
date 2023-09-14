/*
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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author damt207
 */
public class Metodos {

    //1. Crea un método en java que escriba en un fichero de texto.
    /**
     * Metodo para crear un fichero de texto TXT y que escriba informacion en el
     *
     * @param nombre nombre del archivo, no es necesario pasar la extencion
     * @param texto Texto a almacenar en el fichero
     */
    public static void createFile(String nombre, String texto) {

        File archivo = new File(nombre + ".txt");

        if (archivo.exists()) {
            System.out.println("El archivo ya existe no se hara nada");

        } else {

            System.out.println("Archivo Creado Correctamente");

            FileWriter fw = null;

            try {
                fw = new FileWriter(archivo);
                fw.write(texto);

            } catch (IOException e) {
                System.err.println("IOException");
            } finally {
                try {
                    if (fw != null) {
                        fw.close();
                    }
                } catch (IOException e) {
                    System.err.println("IOException cierre flujo");
                }
            }

        }

    }

    // 2. Crea un método en java que lea un fichero de texto línea a línea.
    /**
     * Lee un archivo y muestra por pantalla linea a linea la informacion del
     * mismo
     *
     * @param nombre nombre del archivo, no es necesario pasar la extencion
     */
    public static void readFile(String nombre) {

        File archivo = new File(nombre + ".txt");

        if (archivo.exists()) {

            FileReader fr = null;
            BufferedReader br = null;

            try {
                fr = new FileReader(archivo);

                String cadena;
                //bucle para leer linea a linea se necesita introducir un BufferReader se le pasa como parametro el FileReader
                br = new BufferedReader(new FileReader(archivo));
                while ((cadena = br.readLine()) != null) {
                    System.out.println(cadena);
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

        } else {
            System.out.println("No se puede leer el archivo no existe");
        }

    }

    /*
    3. Crea un método en java que escriba en un fichero de configuración los parámetros de
    conexión utilizando las propiedades de setProperty de System Properties.
    USER = administrador
    PASSW = Admin-123
    SERVER = localhost
    PORT = 3306
    */
    
    /**
     * Método Que escriba en un fichero de configuración los parámetros de conexión utilizando las propiedades de setProperty de System Properties
     * @throws java.io.FileNotFoundException
     */
    public static void ficheroConfiguracion () throws FileNotFoundException, IOException{
        
        FileInputStream propFile = new FileInputStream( "systemPropertiestxt");
        Properties p = new Properties(System.getProperties());
        p.load(propFile);

        // set the system properties
        System.setProperties(p);
        // display new properties
        System.getProperties().list(System.out);
        
    }
    
    
    
    //4. Crea un método en java que lea las propiedades de un fichero de propiedades.props
    
}
