/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.psp_tema5_tarea3_trabajofinal.Metodos;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.security.KeyPair;
import java.util.logging.Level;
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
    
}
