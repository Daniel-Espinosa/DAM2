/*
1)     Método que recibe el nombre del fichero y un objeto para añadir al fichero. El método comprueba que no exista el objeto que se quiere añadir, 
       es decir, que no esté almacenado otro objeto con la misma clave.  Siempre se añade contenido al fichero.
2)     Método que borra un JUEGO del fichero anterior, localizado a partir del identificador.
3)     Documenta bien el código y genera el javadoc.
 */
package tema1_exament1_parte2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author damt207
 */
public class ControladorJuego {

    public static ArrayList<Juego> arrayJuegos = new ArrayList<>();

    /**
     * Metodo que recibe como parametro el nombre de un fichero y lee este
     * fichero y carga la informacion en un array list
     *
     * @param archivo nombre del fichero
     */
    public static void leerFichero(File archivo) {

        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            // comprueba que el archivo existe y si es asi carga la informacion en el array list.
            if (archivo.isFile()) {
                ois = new ObjectInputStream(fis = new FileInputStream(archivo));
                arrayJuegos = (ArrayList) ois.readObject();
                System.out.println("archivo " + archivo.getName() + " Cargado");
            } else {
                System.out.println("El archivo " + archivo.getName() + " no existe, No se carga nada");
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

    /**
     * Metodo que recibe por parametro el nombre de un fichero para guardar la
     * informacion de el mismo
     *
     * @param archivo
     */
    private static void guardarFichero(File archivo) {

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {

            oos = new ObjectOutputStream(fos = new FileOutputStream(archivo));
            oos.writeObject(arrayJuegos);

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
     * Metodo que recibe como parametro el nombre del archivo y la clave del
     * Juego para borrarlo
     *
     * @param archivo nombre del archivo
     * @param clave clave del archivo
     */
    public static void borrarJuego(File archivo, int clave) {

        // si no hay juegos en el array no se puede borrar y da error.
        if (arrayJuegos.isEmpty()) {
            System.out.println("Aun no tienes juegos en el listado, no puedes borrar");
        } else {

            boolean controlBorrado = false;
            // Boolean de control para controlar si se borra o no un juego y poder imprimir mensaje

            for (int i = 0; i < arrayJuegos.size(); i++) {

                if (arrayJuegos.get(i).getClave() == clave) {
                    System.out.println("BORRADO: " + arrayJuegos.get(i).toString());
                    arrayJuegos.remove(i);
                    controlBorrado = true;
                }
            }

            // mensaje si no se borra ningun juego
            if (controlBorrado == false) {
                System.out.println("clave: " + clave + " no encontrada no se puede borrar");
            } else {
                guardarFichero(archivo);
            }
        }

    }

    /**
     * Metodo para añadir un juego a la lista recibe por parametro el nombre del
     * archivo, la clave, el titulo, y el pegi
     *
     * @param archivo nombre del archivo
     * @param clave clave del Juego
     * @param titulo titulo del juego
     * @param pegi pegi del juego
     */
    public static void añadirJuego(File archivo, int clave, String titulo, String pegi) {

        boolean control = false;
        for (int i = 0; i < arrayJuegos.size(); i++) {

            if (arrayJuegos.get(i).getClave() == clave) {
                System.out.println("la clave ya existe: " + arrayJuegos.get(i).toString());
                control = true;
            }
        }

        // si todo es correcto se añade el juego al array list
        if (control == false) {
            Juego juego = new Juego(clave, titulo, pegi);
            arrayJuegos.add(juego);
            //llama al metodo guardar
            guardarFichero(archivo);
        }

    }

    /**
     * Lista los juegos del array list
     */
    public static void listarJuegos() {
        if (arrayJuegos.isEmpty()) {
            System.out.println("no tienes juegos cargados");
        } else {
            for (Juego i : arrayJuegos) {
                System.out.println(i.toString());
            }

        }
    }

}
