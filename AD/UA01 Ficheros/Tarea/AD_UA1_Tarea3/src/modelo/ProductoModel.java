/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import entidades.Producto;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author damt207
 */
public class ProductoModel {
    
    private static ArrayList<Producto> lista = new ArrayList<>();
    private static final File archivo = new File("BBDD_Productos.dat");
    
    public void escribirFichero(String nombre, double precio){
        
        leerFichero();
        Producto producto = new Producto(nombre, precio);
        lista.add(producto);
        
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {

            oos = new ObjectOutputStream(fos = new FileOutputStream(archivo));
            oos.writeObject(lista);

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

     
   
    public void leerFichero(){
        
        
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            // comprueba que el archivo existe y si es asi carga la informacion en el array list.
            if (archivo.isFile()) {
                ois = new ObjectInputStream(fis = new FileInputStream(archivo));
                lista = (ArrayList) ois.readObject();
                //System.err.println("archivo " + archivo.getName() + " Cargado");
            } else {
                System.err.println("El archivo " + archivo.getName() + " no existe, No se carga nada");
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

    public static ArrayList<Producto> getLista() {
        return lista;
    }

    public static void setLista(ArrayList<Producto> lista) {
        ProductoModel.lista = lista;
    }


}
