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
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Scanner;
import java.util.logging.Level;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author damt207
 */
public class SecretKeyManagerAES {
  
    /**
     * Se generará la clave secreta AES a partir de una contraseña introducida
     * por el usuario convertida en un array de bytes. Para hacerlo, mirar la
     * clase SecretKeySpec.
     */
    public static SecretKeySpec generateKeyAES(String pass){
        
        SecretKeySpec claveAES = new SecretKeySpec(pass.getBytes(), "AES");

        Logs.LOGGER_USER.log(Level.INFO, "AES Key Generada | Password: {0}", new Object[]{pass});

        return claveAES;
    }
    
    public static boolean saveKeyAES(String directoryPath, SecretKeySpec claveAES) {

        try (FileOutputStream fos = new FileOutputStream(directoryPath + FileSystems.getDefault().getSeparator() + "AES_Key.akey")) {

            fos.write(claveAES.getEncoded());
            
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
    
    public static boolean loadKeyAES(String directoryPath, SecretKeySpec claveAES) {

        
        return true;

    }
    
    
    //ALBANO
    
    private static SecretKey key;
 
    private static Scanner scstring = new Scanner(System.in);
 
    public static SecretKey getKey() {
        return key;
    }
 
    /**
     * Metodo para generar una clave AES
     *
     * @param pwd
     */
    public static void generateKey(String pwd) {
 
        if (PasswordValidator.validate(pwd)) {
            try {
                SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
                secureRandom.setSeed(pwd.getBytes());
                KeyGenerator keyGen = KeyGenerator.getInstance("AES");
                keyGen.init(256, secureRandom);
                key = keyGen.generateKey();
                System.out.println("KEY");
                System.out.println(HashTool.enHexadecimal(key.getEncoded()));
                System.out.println("You want to save?(Y/N)");
                if (scstring.nextLine().equalsIgnoreCase("Y")) {
                    System.out.println("File names:");
                    saveKey(scstring.nextLine());
                    System.out.println("Saved");
                }
                //LogConfig.LOG_ALL.log(Level.INFO, "one AES key has been generated");
            } catch (NoSuchAlgorithmException ex) {
                //Logger.getLogger(SecretKeyManagerAES.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("The password does not meet the security requirements.");
            //LogConfig.LOG_ERROR.log(Level.WARNING, "Second or third parameter missing <-rsaencryption>");
        }
 
    }
 
    /**
     * Metodo para guardar una clave AES
     *
     * @param nameFile nombre para ficheros generados
     */
    private static void saveKey(String nameFile) {
        try (FileOutputStream fos = new FileOutputStream(nameFile + "_aes.agl"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(key);
            //LogConfig.LOG_ALL.log(Level.INFO, "one AES key has been saved");
 
        } catch (FileNotFoundException ex) {
            //LogConfig.LOG_ERROR.log(Level.WARNING, "an error occurred while saving the key aes");
        } catch (IOException ex) {
            //LogConfig.LOG_ERROR.log(Level.WARNING, "an error occurred while saving the key aes");
        }
 
    }
 
    /**
     * Metodo para cargar desde un fichero la clave
     * @param pathkey
     * @return boolean True si ha conseguido hacerlo correctamente
     */
    public static boolean loadKey(String pathkey) {
        try (FileInputStream fis = new FileInputStream(pathkey); ObjectInputStream ois = new ObjectInputStream(fis)) {
            // Leer el objeto SecretKeySpec del archivo
            key = (SecretKeySpec) ois.readObject();
            //LogConfig.LOG_ALL.log(Level.INFO, "one AES key has been load");
            return true;
        } catch (Exception e) {
            //LogConfig.LOG_ERROR.log(Level.WARNING, "Second parameter have a error <-aese>");
            System.out.println("Second parameter have a error <-aese> " + e.getMessage());
            return false;
 
        }
    }
    
    
}
