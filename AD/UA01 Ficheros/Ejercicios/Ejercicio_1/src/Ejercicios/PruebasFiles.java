/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicios;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author damt207
 */
public class PruebasFiles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File archivo = new File("PAPAS.txt");
        if (archivo.exists()) {
            System.out.println("El archivo existe");
        } else {
            System.out.println("El archivo NO existe");
        }
        System.out.println("Archivo Nombre: " + archivo.getName());
        System.out.println("Archivo Tamaño: " + archivo.length());
        System.out.println("Archivo Ruta Absoluta: " + archivo.getAbsolutePath());

        System.out.println("");

        File carpeta = new File("CARPETA_PAPAS");
        if (carpeta.exists()) {
            System.out.println("La carpeta existe");
        } else {
            System.out.println("La Carpeta NO existe");
        }
        System.out.println("Carpeta Nombre: " + carpeta.getName());
        System.out.println("Carpeta Tamaño: " + carpeta.length());
        System.out.println("Carpeta Ruta Absoluta: " + carpeta.getAbsolutePath());

        System.out.println("");

        if (archivo.exists()) {
            System.out.println("como existe no hago nada");
        } else {
            System.out.println("como NO existe creo el archivo");
            try {
                archivo.createNewFile();
            } catch (IOException e) {
            }

        }

        System.out.println("\nCREANDO ARCHIVO CON .createNewFile");

        File archivo2 = new File("PAPAPITAS.txt");
        try {
            if (archivo2.createNewFile()) {
                System.out.println("Archivo creado");
            } else {
                System.out.println("El Archivo ya existe");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nCREANDO CARPETAS CON .mkdir");

        File directorio2 = new File("nuevaCarpeta");
        if (directorio2.mkdir()) {
            System.out.println("Directorio creado");
        } else {
            System.out.println("Directorio ya existe");
        }

        System.out.println("\nBORRAR ARCHIVO USANDO .delete");

        File archivoBorrar = new File("archivoParaEliminar.txt");
        if (archivoBorrar.delete()) {
            System.out.println("Archivo Borrado");
        } else {
            System.out.println("Archivo no borrado el archivo no existe");
        }

        System.out.println("\nLISTANDO ARCHIVOS DENTRO DE UNA CARPETA UTILIZANDO .list");

        System.out.println("CARPETAS EN C:/");
        File raiz = new File("C:/");
        String[] lista = raiz.list();
        if (lista != null) {
            for (String i : lista) {
                System.out.println(i);
            }

        }

        System.out.println("\nLISTANDO ARCHIVOS DENTRO DE UNA CARPETA UTILIZANDO .listFiles");

        System.out.println("ARCHIVOS EN C:/");
        File raiz2 = new File("C:/");
        File[] lista2 = raiz2.listFiles();
        if (lista2 != null) {
            for (File i : lista2) {
                if (i.isFile()) {
                    System.out.println("Nombre: " + i.getName() + " bytes: " + i.length());
                }
            }
        } else {
            System.out.println("la ruta esta vacia o no es una carpeta");
        }

    }

}
