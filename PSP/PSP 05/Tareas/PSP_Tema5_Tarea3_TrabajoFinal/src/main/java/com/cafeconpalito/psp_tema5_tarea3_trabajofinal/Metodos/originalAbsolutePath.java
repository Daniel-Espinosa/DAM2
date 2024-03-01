/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.psp_tema5_tarea3_trabajofinal.Metodos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt207
 */
public class originalAbsolutePath {

    /**
     * Firma de ficheros y verificación.
     *
     * @return
     */
    /**
     * Metodo que genera un Key Pair de claves algoritmo DSA.
     *
     * @return KeyPair
     */
    public static KeyPair makeKeyPair() {

        KeyPair keyPair = null;

        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("DSA");

            //Otros tipos de firma MD5withRSA, MD5withDSA, SHA1withRSA
            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");

            kpg.initialize(512, sr);
            keyPair = kpg.generateKeyPair();

            Logs.LOGGER_USER.log(Level.INFO, "Digital Signing Key Pair Generado | Seed: {0} \nPrivate Key: {1} \nPublic Key: {2}", new Object[]{sr, keyPair.getPrivate().toString(), keyPair.getPublic().toString()});
            return keyPair;

        } catch (NoSuchAlgorithmException ex) {
            Logs.LOGGER_ERRORS.log(Level.SEVERE, null, ex);
            return null;
        }

    }

    /**
     * Metodo para guardar de un key Pair una clave publica y privada, en la
     * ruta seleccionada.
     *
     * @param directoryPath ruta donde se guardaran las claves.
     * @param keyPair
     * @return True si logra guardar correctamente.
     */
    private static boolean saveKeys(String directoryPath, KeyPair keyPair) {
        try (FileOutputStream fos = new FileOutputStream(directoryPath + "DSA_Public.pudsa"); FileOutputStream fos2 = new FileOutputStream(directoryPath + "DSA_Private.prdsa")) {

            fos.write(keyPair.getPublic().getEncoded());
            fos2.write(keyPair.getPrivate().getEncoded());

            Logs.LOGGER_USER.log(Level.INFO, "DSA pivateKey y publicKey Guardadas | Ruta: {0} \nPrivate Key: {1} \nPublic Key: {2}  ", new Object[]{directoryPath, keyPair.getPrivate().toString(), keyPair.getPublic().toString()});
            return true;

        } catch (FileNotFoundException ex) {
            Logs.LOGGER_ERRORS.log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logs.LOGGER_ERRORS.log(Level.SEVERE, null, ex);
            return false;
        }

    }

    /**
     * Cargar una clave pública o privada de un fichero.
     *
     * @param absolutePath Ruta del archivo
     * @param isPrivate True Private Key, False Public Key
     * @return Objeto Generico, recastear a PrivateKey o PublicKey, Null si no
     * existe o no casa.
     */
    public static Object loadClave(String absolutePath, boolean isPrivate) {

        //Almacenara la clave solicitada.
        KeyFactory kf = null;

        //Array de bytes que almacenara los datos leidos del fichero
        byte[] keyBytes;

        try {

            //File con la ruta del fichero a leer.
            File f = new File(absolutePath);

            if (f.exists()) {
                if (isPrivate) { //Clave privada

                    keyBytes = Files.readAllBytes(f.toPath());

                    //utiliza PKCS8 con el array de bytes para consegior la clave privada
                    PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(keyBytes);
                    kf = KeyFactory.getInstance("DSA");

                    Logs.LOGGER_USER.log(Level.INFO, "Lectura clave DSA Private Key \n\tRuta: {0}", new Object[]{absolutePath});
                    // Devuelve la clave privada 
                    return kf.generatePrivate(privateKeySpec);

                } else { //Clave publica

                    keyBytes = Files.readAllBytes(f.toPath());

                    //Utiliza X509 con el array de bytes para consegir la clave Publica
                    X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(keyBytes);
                    kf = KeyFactory.getInstance("DSA");

                    Logs.LOGGER_USER.log(Level.INFO, "Lectura clave DSA Public Key \n\tRuta: {0}", new Object[]{absolutePath});
                    // Devuelve la clave publica
                    return kf.generatePublic(publicKeySpec);
                }

            }

        } catch (IOException | InvalidKeySpecException | NoSuchAlgorithmException ex) {
            Logs.LOGGER_ERRORS.log(Level.SEVERE, null, ex);
            return null;
        }

        return null;
    }

    /**
     * Firma y guarda un fichero .txt
     *
     * @param privateKey
     * @param absolutePath ruta del fichero a firmar.
     * @return devuele la ruta del fichero firmado, null si no se puede.
     */
    public static String firmarFichero(PrivateKey privateKey, String absolutePath) {

        try {
            String encripPath = null;
            Path p = null;
            String operancion = "SIGNED_";

            Signature firma = Signature.getInstance("SHA1withDSA");

            firma.initSign(privateKey);

            firma.update(Files.readAllBytes(Paths.get(absolutePath)));

            //Almaceno el fichero en un buffer para escribirlo firmado
            byte[] bufferFirma = firma.sign(); //Obtengo la firma digital

            //Desde la ruta absoluta del archivo original creo un nuevo Path para el nuevo fichero desencriptado
            try {
                p = Paths.get(absolutePath);
                String encripName = p.getFileName().toString().replaceFirst("." + com.google.common.io.Files.getFileExtension(p.getFileName().toString()), ".sdsa");
                encripPath = p.getParent() + FileSystems.getDefault().getSeparator() + operancion + encripName;
                p = Paths.get(encripPath);
            } catch (Exception ex) {
                Logs.LOGGER_ERRORS.log(Level.SEVERE, null, ex);
                return null;
            }

            try (OutputStream os = Files.newOutputStream(p)) {
                os.write(bufferFirma);

            } catch (FileNotFoundException ex) {
                Logs.LOGGER_ERRORS.log(Level.SEVERE, null, ex);
                return null;
            } catch (IOException ex) {
                Logs.LOGGER_ERRORS.log(Level.SEVERE, null, ex);
                return null;
            }

        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException | IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
            Logs.LOGGER_ERRORS.log(Level.SEVERE, null, ex);
        }
        return null;

    }

    /**
     * Metodo que comprueba mediante la clave publica si el fichero Original y
     * El firmado son correctos
     *
     * @param originalAbsolutePath
     * @param firmadoAbsolutePath
     * @param publicKey
     * @return True si la verificacion es correcta
     */
    public static boolean verificarFirma(String originalAbsolutePath, String firmadoAbsolutePath, PublicKey publicKey) {
        try {
            
            Signature sign = Signature.getInstance("SHA1withDSA");
            sign.initVerify(publicKey);
            sign.update(Files.readAllBytes(Paths.get(originalAbsolutePath)));

            return sign.verify(Files.readAllBytes(Paths.get(firmadoAbsolutePath)));

        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException | IOException ex) {
            Logs.LOGGER_ERRORS.log(Level.SEVERE, null, ex);
            return false;
        }

    }

}
