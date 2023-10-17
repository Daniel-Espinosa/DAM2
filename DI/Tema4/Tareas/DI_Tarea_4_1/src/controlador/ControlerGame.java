/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import static controlador.ControlerUser.arrayUser;
import entidad.User;
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
public class ControlerGame {
    
    public static ArrayList<User> arrayGame = new ArrayList<>();
    private final static File ARCHIVO = new File("Games.dat");
    
    public static void leer_coleccion_del_fichero() {

        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            // comprueba que el archivo existe y si es asi carga la informacion en el array list.
            if (ARCHIVO.isFile()) {
                ois = new ObjectInputStream(fis = new FileInputStream(ARCHIVO));
                arrayGame = (ArrayList) ois.readObject();
                System.out.println("archivo " + ARCHIVO.getName() + " Cargado");
            } else {
                System.out.println("El archivo " + ARCHIVO.getName() + " no existe, No se carga nada");
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

    public static void grabar_coleccion_en_fichero() {

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {

            oos = new ObjectOutputStream(fos = new FileOutputStream(ARCHIVO));
            oos.writeObject(arrayGame);

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
    
    
}
