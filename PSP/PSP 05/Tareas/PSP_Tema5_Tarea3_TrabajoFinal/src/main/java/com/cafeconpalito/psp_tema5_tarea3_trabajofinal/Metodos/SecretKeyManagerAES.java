/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.psp_tema5_tarea3_trabajofinal.Metodos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Level;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 *
 * @author damt207
 */
public class SecretKeyManagerAES {

    /**
     * Se generará la clave secreta AES a partir de una contraseña introducida
     * por el usuario convertida en un array de bytes
     *
     * @param pass Password para crear la contraseña
     * @param keySize Tamaño de la contraseña, valores validos 128, 192, 256
     * @return
     */
    public static SecretKey generateKeyAES(String pass, int keySize) {

        try {
            
            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
            sr.setSeed(pass.getBytes());
            KeyGenerator kg = KeyGenerator.getInstance("AES");
            kg.init(keySize, sr);
            SecretKey claveAES = kg.generateKey();

            Logs.LOGGER_USER.log(Level.INFO, "AES Key Generada \n\tPassword: {0} \n\tClave AES: {1}", new Object[]{pass, claveAES.toString()});
            return claveAES;
            
        } catch (NoSuchAlgorithmException ex) {
            Logs.LOGGER_ERRORS.log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Metodo que guarda en un archivo una clave AES.
     * @param directoryPath Ruta donde se quiere guardar.
     * @param claveAES Secret Key.
     * @return True si todo es correcto, False si da error.
     */
    public static boolean saveKeyAES(String directoryPath, SecretKey claveAES) {

        try (FileOutputStream fos = new FileOutputStream(directoryPath + FileSystems.getDefault().getSeparator() + "AES_Key.akey"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.write(claveAES.getEncoded());

            Logs.LOGGER_USER.log(Level.INFO, "AES Key Generada \n\tRuta: {0} \n\tClave AES: {1}", new Object[]{directoryPath, claveAES.toString()});

        } catch (FileNotFoundException ex) {
            Logs.LOGGER_ERRORS.log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logs.LOGGER_ERRORS.log(Level.SEVERE, null, ex);
            return false;
        }

        Logs.LOGGER_USER.log(Level.INFO, "AES Key Guardada | Ruta: {0} ", new Object[]{directoryPath});
        return true;

    }

    /**
     * Metodo que lee una clave AES desde la ruta de un fichero.
     * @param directoryPath ruta del archivo a leer.
     * @return Secret Key si es leida correctamente o null si da error.
     */
    public static SecretKey loadKeyAES(String directoryPath) {
        
        try (FileInputStream fis = new FileInputStream(directoryPath); ObjectInputStream ois = new ObjectInputStream(fis)) {
           
            SecretKey claveAES = (SecretKey) ois.readObject();
            
            Logs.LOGGER_USER.log(Level.INFO, "AES Key Leida \n\tRuta: {0} \n\tClave AES: {1}", new Object[]{directoryPath, claveAES.toString()});
            return claveAES;
            
        } catch (IOException | ClassNotFoundException ex) {
            Logs.LOGGER_ERRORS.log(Level.SEVERE, null, ex);
            return null;
        } 
    }
}
