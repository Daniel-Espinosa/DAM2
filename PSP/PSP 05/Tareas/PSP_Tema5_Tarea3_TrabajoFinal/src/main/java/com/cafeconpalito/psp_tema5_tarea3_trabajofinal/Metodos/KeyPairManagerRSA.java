/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.psp_tema5_tarea3_trabajofinal.Metodos;

import java.io.File;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.logging.Level;

/**
 *
 * @author damt207
 */
public class KeyPairManagerRSA {

    private String privateKeyStr;
    private String publicKeyStr;
    
    private static PrivateKey clavePrivada;
    private static PublicKey clavePublica;
    
    public String getPrivateKeyStr() {
        return privateKeyStr;
    }

    public String getPublicKeyStr() {
        return publicKeyStr;
    }
    
    /**
     * Creación de pares de claves utilizando el algoritmo RSA.
     *
     * @param seed
     * @param keySize
     * @return 
     */
    public void makeKeyPair(String seed, int keySize){
        
        try {
        
            KeyPairGenerator keyGen=KeyPairGenerator.getInstance("RSA");
            
            SecureRandom secure= SecureRandom.getInstance("SHA1PRNG");
            secure.setSeed(seed.getBytes());
            keyGen.initialize(keySize, secure);
            KeyPair clavesRSA=keyGen.generateKeyPair();
            
            clavePrivada=clavesRSA.getPrivate();
            clavePublica=clavesRSA.getPublic();
            
            //System.out.println(clavePrivada.toString());
            //System.out.println(clavePublica.toString());
            
            privateKeyStr = HashTool.enHexadecimal(clavePrivada.getEncoded());
            publicKeyStr = HashTool.enHexadecimal(clavePublica.getEncoded());
            
            if (seed.isBlank()) {
                seed=null;
            }
            
            Logs.LOGGER_USER.log(Level.INFO, "Algoritmo RSA | Key Size: {0} | Seed: {1} \nPrivate Key: {2} \nPublic Key: {3}", new Object[]{keySize, seed,clavePrivada.toString(),clavePublica.toString()});
            
        } catch (NoSuchAlgorithmException ex) {
            Logs.LOGGER_ERRORS.log(Level.SEVERE, null, ex);
        }
               
    }
    
    /**
     * Salvar una clave pública o privada en un fichero.
     *
     * @param name
     * @return 
     */
    public static boolean saveClave(String name){
       
        return false;
    }
    
    /**
     *  Cargar una clave pública o privada de un fichero.
     * 
     * @param f
     * @return 
     */
    public static boolean loadClave(File f){
        
        
        return false;
    }
    
    
}
