/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.psp_tema5_tarea3_trabajofinal.Metodos;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.logging.Level;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author damt207
 */
public class RSAEncryption {

    /**
     * Cifrado de ficheros utilizando el algoritmo de criptografía asimétrica
     * RSA.
     *
     * @param absolutePath absolute absolutePath del archivo a encriptar
     * @param key PrivateKey o PublicKey
     * @param isPrivate True para PrivateKey, False para PublicKey
     * @return Absolute Path del archivo cifrado
     */
    public static String cifrar(String absolutePath, Object key, boolean isPrivate) {

        String encripPath = null;

        PrivateKey privKey;
        PublicKey pubKey;
        Cipher c;
        Path p = null;
        String encripKey = "encripted";

        if (isPrivate) {
            encripKey += "PrivateKey_";
        } else {
            encripKey += "PublicKey_";
        }

        //Desde la ruta absoluta del archivo original creo un nuevo Path para el nuevo fichero encriptado
        try {
            p = Paths.get(absolutePath);
            String encripName = p.getFileName().toString().replaceFirst("." + com.google.common.io.Files.getFileExtension(p.getFileName().toString()), ".rsa");
            encripPath = p.getParent() + FileSystems.getDefault().getSeparator() + encripKey + encripName;
            p = Paths.get(encripPath);
        } catch (Exception ex) {
            Logs.LOGGER_ERRORS.log(Level.SEVERE, null, ex);
            return null;
        }

        try (InputStream is = Files.newInputStream(new File(absolutePath).toPath()); OutputStream os = Files.newOutputStream(p)) {

            //Evaluo si es privada o publica
            if (isPrivate) { //Clave Privada

                //recasteo la clave que recibo
                privKey = (PrivateKey) key;

                //Instancio el Objeto a encriptar con la Key
                c = Cipher.getInstance(privKey.getAlgorithm());
                c.init(Cipher.ENCRYPT_MODE, privKey);

            } else {

                //Recastelo la clave que recibo
                pubKey = (PublicKey) key;

                //Instancio el Objeto a encriptar con la Key
                c = Cipher.getInstance(pubKey.getAlgorithm());
                c.init(Cipher.ENCRYPT_MODE, pubKey);

            }

            //Lectura y escritura de ficheros por bloques de Bytes de 512
            byte[] bufferLecura = new byte[512];
            int bytesLeidos = is.read(bufferLecura);

            //Escritura de los bloques
            while (bytesLeidos != -1) {
                byte[] bufferEncriptado = c.update(bufferLecura, 0, bytesLeidos);
                os.write(bufferEncriptado);
                bytesLeidos = is.read(bufferLecura);

            }
            //Bloque final
            byte[] bufferFinal = c.doFinal();
            os.write(bufferFinal);

            Logs.LOGGER_USER.log(Level.INFO, "Encriptado RSA de archivo \n\tInformacion: {0}\n\tArchivo:{1}", new Object[]{c.toString(), p});
            return encripPath;

        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IOException | IllegalBlockSizeException | BadPaddingException ex) {
            Logs.LOGGER_ERRORS.log(Level.SEVERE, null, ex);
            return null;
        }

    }

    /**
     * Descifrado de ficheros utilizando el algoritmo de criptografía asimétrica
     * RSA.
     *
     * @param absolutePath
     * @param key
     * @param isPrivate
     * @return Absolute Path del archivo descifrado
     */
    public static String descifrar(String absolutePath, Object key, boolean isPrivate) {

        String encripPath = null;

        PrivateKey privKey;
        PublicKey pubKey;
        Cipher c;
        Path p = null;
        String encripKey = "DECRIPTED_";

        //Desde la ruta absoluta del archivo original creo un nuevo Path para el nuevo fichero encriptado
        try {
            p = Paths.get(absolutePath);
            String encripName = p.getFileName().toString().replaceFirst("." + com.google.common.io.Files.getFileExtension(p.getFileName().toString()), ".txt");
            encripPath = p.getParent() + FileSystems.getDefault().getSeparator() + encripKey + encripName;
            p = Paths.get(encripPath);
        } catch (Exception ex) {
            Logs.LOGGER_ERRORS.log(Level.SEVERE, null, ex);
            return null;
        }

        try (InputStream is = Files.newInputStream(new File(absolutePath).toPath()); OutputStream os = Files.newOutputStream(p)) {

            //Evaluo si es privada o publica
            if (isPrivate) { //Clave Privada

                //recasteo la clave que recibo
                privKey = (PrivateKey) key;

                //Instancio el Objeto a encriptar con la Key
                c = Cipher.getInstance(privKey.getAlgorithm());
                c.init(Cipher.DECRYPT_MODE, privKey);

            } else {

                //Recastelo la clave que recibo
                pubKey = (PublicKey) key;

                //Instancio el Objeto a encriptar con la Key
                c = Cipher.getInstance(pubKey.getAlgorithm());
                c.init(Cipher.DECRYPT_MODE, pubKey);

            }

            //Lectura y escritura de ficheros por bloques de Bytes de 512
            byte[] bufferLecura = new byte[512];
            int bytesLeidos = is.read(bufferLecura);

            //Escritura de los bloques
            while (bytesLeidos != -1) {
                byte[] bufferEncriptado = c.update(bufferLecura, 0, bytesLeidos);
                os.write(bufferEncriptado);
                bytesLeidos = is.read(bufferLecura);

            }
            //Bloque final
            byte[] bufferFinal = c.doFinal();
            os.write(bufferFinal);

            Logs.LOGGER_USER.log(Level.INFO, "Desencriptado RSA de archivo \n\tInformacion: {0}\n\tArchivo:{1}", new Object[]{c.toString(), p});
            return encripPath;

        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IOException | IllegalBlockSizeException | BadPaddingException ex) {
            Logs.LOGGER_ERRORS.log(Level.SEVERE, null, ex);
            return null;
        }

    }

}
