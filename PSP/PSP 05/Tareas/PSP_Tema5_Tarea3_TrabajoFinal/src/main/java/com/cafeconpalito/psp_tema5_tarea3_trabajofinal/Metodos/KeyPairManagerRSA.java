/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.psp_tema5_tarea3_trabajofinal.Metodos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.logging.Level;

/**
 *
 * @author damt207
 */
public class KeyPairManagerRSA {

    /**
     * Creación de pares de claves utilizando el algoritmo RSA.
     *
     * @param seed
     * @param keySize
     * @return
     */
    public static KeyPair makeKeyPair(String seed, int keySize) {

        try {

            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");

            SecureRandom secure = SecureRandom.getInstance("SHA1PRNG");
            secure.setSeed(seed.getBytes());
            keyGen.initialize(keySize, secure);
            KeyPair clavesRSA = keyGen.generateKeyPair();

            if (seed.isBlank()) {
                seed = null;
            }

            Logs.LOGGER_USER.log(Level.INFO, "Algoritmo RSA | Key Size: {0} | Seed: {1} \nPrivate Key: {2} \nPublic Key: {3}", new Object[]{keySize, seed, clavesRSA.getPrivate().toString(), clavesRSA.getPublic().toString()});
            return clavesRSA;

        } catch (NoSuchAlgorithmException ex) {
            Logs.LOGGER_ERRORS.log(Level.SEVERE, null, ex);

            return null;
        }

    }

    /**
     * Salvar una clave pública o privada en un fichero.
     *
     * @param name
     * @return
     */
    public static boolean saveClave(String directoryPath, KeyPair clavesRSA) {

        try (FileOutputStream fosPri = new FileOutputStream(directoryPath + FileSystems.getDefault().getSeparator() + "privateKey.rkey"); FileOutputStream fosPub = new FileOutputStream(directoryPath + FileSystems.getDefault().getSeparator() + "publicKey.rkey")) {

            fosPri.write(clavesRSA.getPrivate().getEncoded());
            fosPub.write(clavesRSA.getPublic().getEncoded());
        } catch (FileNotFoundException ex) {
            Logs.LOGGER_ERRORS.log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logs.LOGGER_ERRORS.log(Level.SEVERE, null, ex);
            return false;
        }

        Logs.LOGGER_USER.log(Level.INFO, "RSA pivateKey y publicKey Guardadas | Ruta: {0} \nPrivate Key: {1} \nPublic Key: {2}  ", new Object[]{directoryPath, clavesRSA.getPrivate().toString(), clavesRSA.getPublic().toString()});

        return true;

    }

    /**
     * Cargar una clave pública o privada de un fichero.
     *
     * @param path Ruta del archivo
     * @param isPrivate True Private Key, False Public Key
     * @return Objeto Generico, recastear a PrivateKey o PublicKey
     */
    public static Object loadClave(String path, boolean isPrivate) {

        //Almacenara la clave solicitada.
        KeyFactory kf = null;
        
        //Array de bytes que almacenara los datos leidos del fichero
        byte[] keyBytes;

        try {
            
            //File con la ruta del fichero a leer.
            File f = new File(path);
            
            if (f.exists()) {
                if (isPrivate) { //Clave privada

                    keyBytes = Files.readAllBytes(f.toPath());
                    
                    //utiliza PKCS8 con el array de bytes para consegior la clave privada
                    PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(keyBytes);
                    kf = KeyFactory.getInstance("RSA");
                                        
                    Logs.LOGGER_USER.log(Level.INFO, "Lectura de RSA Private Key \n\tRuta: {0}", new Object[]{path});
                    // Devuelve la clave privada 
                    return kf.generatePrivate(privateKeySpec);
                    
                } else { //Clave publica

                    keyBytes = Files.readAllBytes(f.toPath());
                    
                    //Utiliza X509 con el array de bytes para consegir la clave Publica
                    X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(keyBytes);
                    kf = KeyFactory.getInstance("RSA");

                    Logs.LOGGER_USER.log(Level.INFO, "Lectura de RSA Public Key \n\tRuta: {0}", new Object[]{path});
                    // Devuelve la clave publica
                    return kf.generatePublic(publicKeySpec);
                }

            }

        } catch (IOException ex) {
            Logs.LOGGER_ERRORS.log(Level.SEVERE, null, ex);
            return null;
        } catch (InvalidKeySpecException ex) {
            Logs.LOGGER_ERRORS.log(Level.SEVERE, null, ex);
            return null;
        } catch (NoSuchAlgorithmException ex) {
            Logs.LOGGER_ERRORS.log(Level.SEVERE, null, ex);
            return null;
        }

        return null;
    }

}
