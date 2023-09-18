/*
1. Crea un método para serializar un objeto de la clase Persona. Se trata de escribir en un
fichero los datos de un objeto de tipo Producto.
2. Crea un método para leer un objeto de tipo Persona del fichero creado anteriormente.
3. Crea un método que escriba en un fichero binario un ArrayList de objetos de tipo Persona.
4. Crea un método que vuelque en un ArrayList los objetos almacenados en el fichero anterior
 */
package ad_ua1_tarea2;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author damt207
 */
public class MetodosPersona {

    /**
     * Serializa un objeto de tipo persona y guarda la infomarcion en un fichero .dat
     * @param nombreFichero nombre del fichero no es necesario añadir la extencion
     * @param persona Objeto de tipo persona
     */
    public static void serializarPersona(String nombreFichero, Persona persona) {

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            //se le pasa la ruta del archivo
            fos = new FileOutputStream(nombreFichero + ".dat");
            //se le pasa el fos como parametro
            oos = new ObjectOutputStream(fos);

            //utilizamos el metodo oos.writeObject para pasarle el objeto
            //podemos utilizar este metodo tantos objetos tengamos
            oos.writeObject(persona);

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

    /**
     * Lee de un fichero .dat los datos de un Objeto de tipo persona
     * @param nombreFichero nombre del fichero no es necesario añadir la extencion
     */
    public static void deserializarPersona(String nombreFichero) {

        // se utiliza para leer ficheros .dat y leer objetos.
        // se necesita el FileOutputStream y el ObjectOutputStream.
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        Persona persona = null;

        try {
            fis = new FileInputStream(nombreFichero + ".dat");
            ois = new ObjectInputStream(fis);

            //se utiliza el available del FIS para saber el tamaño del fichero y que lo recorra.
            while (fis.available() > 0) {
                persona = (Persona) ois.readObject();
                System.out.println(persona.toString());
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

    
    /**
     * Guarda en un fichero .dat un arraylist con la informacion de Objetos del tipo persona
     * @param nombreFichero nombre del fichero no es necesario añadir la extencion
     * @param personas Objeto de tipo persona
     */
    public static void grabarColeccionFichero(String nombreFichero, ArrayList<Persona> personas) {

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        nombreFichero += ".dat";

        try {

            oos = new ObjectOutputStream(fos = new FileOutputStream(nombreFichero));
            oos.writeObject(personas);

        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException");
        } catch (IOException e) {
            System.err.println("IOException");
        } finally {
            try {
                if (fos != null) {
                    oos.close();
                    fos.close();
                }
            } catch (IOException e) {
                System.err.println("IOException");
            }

        }

    }

    /**
     * Lee de un fichero .dat un arraylist con la informacion de Objetos del tipo persona
     * @param nombreFichero  nombre del fichero no es necesario añadir la extencion
     */
    public static void leerColeccionFichero(String nombreFichero) {

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        ArrayList<Persona> personas = new ArrayList<>();
        File fichero = new File(nombreFichero + ".dat");

        try {
            // comprueba que el archivo existe y si es asi carga la informacion en el array list.
            if (fichero.isFile()) {
                ois = new ObjectInputStream(fis = new FileInputStream(fichero));
                personas = (ArrayList) ois.readObject();
                System.out.println("archivo " + fichero.getName() + " Cargado");

                if (!personas.isEmpty()) {
                    for (Persona i : personas) {
                        System.out.println(i.toString());
                    }
                } else {
                    System.out.println("no tienes alumnos en el listado");
                }

            } else {
                System.out.println("El archivo " + fichero.getName() + " no existe, No se carga nada");
            }

        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException");
        } catch (IOException e) {
            System.err.println("IOException");
        } catch (ClassNotFoundException ex) {
            System.err.println("ClassNotFoundException");
        } finally {
            try {
                if (fis != null) {
                    ois.close();
                    fis.close();
                }
            } catch (IOException e) {
            }
        }
    }

}
