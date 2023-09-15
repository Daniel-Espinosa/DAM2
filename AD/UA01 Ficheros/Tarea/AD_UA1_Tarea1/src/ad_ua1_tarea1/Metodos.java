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
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
     * Método Que escriba en un fichero de configuración los parámetros de
     * conexión utilizando las propiedades de setProperty de System Properties
     */
    public static void ficheroConfigEscritura() {

        File fichero = new File("propiedades.props");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {

            // si existe lo borro
            if (fichero.exists()) {
                fichero.delete();
            }

            //Creo un nuevo fichero
            fichero.createNewFile();

            //se le pasa la ruta del archivo
            fos = new FileOutputStream(fichero);
            //se le pasa el fos como parametro
            oos = new ObjectOutputStream(fos);

            // Creamos un Objeto de la clase Propiedades
            Properties p = new Properties(System.getProperties());

            //creo las nuevas propiedades con clave - valor
            p.setProperty("USER", "administrador");
            p.setProperty("PASSW", "Admin-123");
            p.setProperty("SERVER", "localhost");
            p.setProperty("PORT", "3306");

            // Escribo en el archivo propiedades.props las nuevas propiedades
            oos.writeObject(p);

            // muestro las propiedades por pantalla
            //System.out.println(p.getProperty("USER"));
            //System.out.println(p.getProperty("PASSW"));
            //System.out.println(p.getProperty("SERVER"));
            //System.out.println(p.getProperty("PORT"));
        } catch (IOException e) {

        } finally {

            try {
                if (oos != null) {
                    oos.close();
                    fos.close();
                }
            } catch (IOException e) {
            }

        }

    }

    //4. Crea un método en java que lea las propiedades de un fichero de propiedades.props
    /**
     * método que lee las propiedades de un fichero de propiedades.props
     */
    public static void ficheroConfigLectura() {

        File fichero = new File("propiedades.props");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
        try {
            fis = new FileInputStream(fichero);
            ois = new ObjectInputStream(fis);
            Properties p = new Properties();
            
            //se utiliza el available del FIS para saber el tamaño del fichero y que lo recorra.
            //Properties p = new Properties(System.getProperties());
            while (fis.available() > 0) {
                p = (Properties) ois.readObject();
                System.out.println(p.toString());
            }

        } catch (FileNotFoundException fnf) {
            System.err.println("Fichero no encontrado" + fnf);
        } catch (IOException ioe) {
            System.err.println("Se ha producido una IoException" + ioe);
        } catch (ClassNotFoundException ex) {
            System.err.println("No se ha podido leer el objeto porque me falta la clase");
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                    ois.close();
                }
            } catch (IOException ioe) {
                System.err.println("Ha ocurrido una IOException");
            }

        }

    }
}
