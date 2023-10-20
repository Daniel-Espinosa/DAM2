/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import static controlador.ControlerUser.arrayUser;
import entidad.Game;
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

    public static ArrayList<Game> arrayGame = new ArrayList<>();
    private final static File ARCHIVO = new File("Games.dat");

    public static void leer_coleccion_del_fichero() {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            // comprueba que el archivo existe y si es asi carga la informacion en el array list.
            if (ARCHIVO.isFile()) {
                arrayGame = (ArrayList) ois.readObject();
                //System.out.println("archivo " + ARCHIVO.getName() + " Cargado");
            } else {
                //System.out.println("El archivo " + ARCHIVO.getName() + " no existe, No se carga nada");
            }
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException");
        } catch (IOException e) {
            System.err.println("IOException");
        } catch (ClassNotFoundException ex) {
            System.err.println("ClassNotFoundException");
        }
    }

    public static void grabar_coleccion_en_fichero() {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            oos.writeObject(arrayGame);
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException");
        } catch (IOException e) {
            System.err.println("IOException");
        }
    }

    public static void addGame(String nombre, String genre, String date, String company, String pegi, String descripcion, String image, double precio) {

        Game g = new Game(nombre, genre, date, company, pegi, descripcion, image, precio);
        arrayGame.add(g);
    }

    public static boolean gameExist(String nombre) {

        if (arrayGame.isEmpty()) {
            //System.err.println("La lista esta vacia, no se puede buscar un Juego");
            return false;
        } else {
            //se recorre el array buscando coincidencia con el nombre Ignorando Case
            //System.out.println("lectura de la lista Juegos");
            for (Game i : arrayGame) {
                if (nombre.equalsIgnoreCase(i.getNombre())) {
                    //System.out.println("el juego ya esta en la lista");
                    return true;
                }
            }
        }
        return false;
    }

    public static void listarJuegos(){
        for (Game game : arrayGame) {
            System.out.println(game.getNombre());
        }
    }
    
}
