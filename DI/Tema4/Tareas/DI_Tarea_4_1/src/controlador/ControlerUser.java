/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import entidad.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import main.Main;

/**
 *
 * @author damt207
 */
public class ControlerUser implements Serializable {

    //DireccionDelFicheroUsuarios
    public static ArrayList<User> arrayUser = new ArrayList<>();
    private final static File ARCHIVO = new File("Usuarios.dat");

    public static void leer_coleccion_del_fichero() {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO)) ){
            // comprueba que el archivo existe y si es asi carga la informacion en el array list.
            if (ARCHIVO.isFile()) {
                
                arrayUser = (ArrayList) ois.readObject();
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
        
        }
    }

    public static void grabar_coleccion_en_fichero() {


        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {

            oos.writeObject(arrayUser);

        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException");
        } catch (IOException e) {
            System.err.println("IOException");
        }
    }

    public static boolean conectar(String user, String pass) {
        // si no hay Usuarios en el array devuelve un mensaje de que esta vacio
        if (arrayUser.isEmpty()) {
            System.err.println("La lista esta vacia, no se puede buscar un Usuario");
            return false;
            
        } else {
            //se recorre el array buscando coincidencia con el nombre Ignorando Case
            for (User i : arrayUser) {
                if (user.equalsIgnoreCase(i.getUser()) && pass.equals(i.getPass())) {
                    Main.usuarioLogin.setName(i.getName());
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean userExist (String user){
        
        if (arrayUser.isEmpty()) {
            System.err.println("La lista esta vacia, no se puede buscar un Usuario");
            return false;
        } else {
            //se recorre el array buscando coincidencia con el nombre Ignorando Case
            for (User i : arrayUser) {
                if (user.equalsIgnoreCase(i.getUser())) {
                    return true;
                }
            }
        }
        return false;
    }
    
    
    public static void addUsuario(String user, String pass, String nombre){
        
        User u = new User(user, pass, nombre);
        arrayUser.add(u);
        
    }
    

}
