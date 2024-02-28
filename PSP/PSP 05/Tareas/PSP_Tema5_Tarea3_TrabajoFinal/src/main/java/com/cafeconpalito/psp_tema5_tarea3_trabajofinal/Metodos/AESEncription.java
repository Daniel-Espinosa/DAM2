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
import javax.crypto.SecretKey;

/**
 *
 * @author damt207
 */
public class AESEncription {

    /**
     * Metodo de Cifrado de ficheros utilizando el algoritmo de criptografía
     * simétrica AES
     *
     * @return
     */
    public static String cifrar(String absolutePath, SecretKey claveAES) {

        Cipher c;
        Path p = null;
        String encripPath;
        String encripted = "encripted";

        try {
            p = Paths.get(absolutePath);
            String encripName = p.getFileName().toString().replaceFirst("." + com.google.common.io.Files.getFileExtension(p.getFileName().toString()), ".aes");
            encripPath = p.getParent() + FileSystems.getDefault().getSeparator() + encripted + encripName;
            p = Paths.get(encripPath);
        } catch (Exception ex) {
            Logs.LOGGER_ERRORS.log(Level.SEVERE, null, ex);
            return null;
        }

        try (InputStream is = Files.newInputStream(new File(absolutePath).toPath()); OutputStream os = Files.newOutputStream(p)) {

            //Instancio el Objeto a encriptar con la Key
            c = Cipher.getInstance(claveAES.getAlgorithm());
            c.init(Cipher.ENCRYPT_MODE, claveAES);

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

            Logs.LOGGER_USER.log(Level.INFO, "Encriptado de archivo \n\tInformacion: {0}\n\tArchivo:{1}", new Object[]{c.toString(), p});
            return encripPath;

        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IOException | IllegalBlockSizeException | BadPaddingException ex) {
            Logs.LOGGER_ERRORS.log(Level.SEVERE, null, ex);
            return null;
        }

    }

    /**
     * Metodo de Descifrado de ficheros utilizando el algoritmo de criptografía
     *
     * @param absolutePath
     * @param claveAES
     * @return
     */
    public static boolean descifrar(String absolutePath, SecretKey claveAES) {

        return false;

    }

}
