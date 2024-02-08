/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.psp_tema5_tarea1_messagedigest;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Provider.Service;
import java.security.Security;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt207
 */
public class HashThing {

    /**
     * Devuelve un String con todos los algoritmos permi)dos de hash.
     *
     * @return
     */
    public static String getAlgorithms() {

        String algorithms = "";

        for (Provider e : Security.getProviders()) {
            for (Provider.Service s : e.getServices()) {
                //System.out.println(s.getType());
                if (s.getType().contains("MessageDigest")) {
                    //System.out.println(s.getAlgorithm());
                    algorithms += s.getAlgorithm() + "\n";
                }
            }
        }

        //System.out.println(algorithms);
        return algorithms;
    }

    /**
     * Devuelve el resumen del texto plano como String en formato hexadecimal.
     *
     * @param algorithm
     * @param plaintext
     * @return
     */
    public static String getStringHash(String algorithm, String plaintext) {

        String textHexa = null;

        try {

            MessageDigest mensajedigest;
            mensajedigest = MessageDigest.getInstance(algorithm);
            byte datos[] = plaintext.getBytes();
            mensajedigest.update(datos);
            byte resumen[] = mensajedigest.digest();

            textHexa = enHexadecimal(resumen);

        } catch (NoSuchAlgorithmException ex) {
            System.err.println("Error no encuentra algoritmo. " + ex.toString());
            return null;
        }

        return textHexa;
    }

    /**
     *
     * @param algorithm
     * @param f
     */
    public static String getFilehash(String algorithm, File f) {

        String textHexa = null;
        
        BufferedInputStream bis = null;

        try {

            MessageDigest mensajedigest;
            mensajedigest = MessageDigest.getInstance(algorithm);

            //Creo el Bufer para leer el File
            bis = new BufferedInputStream(new FileInputStream(f));

            //Creo una Buffer para leer el archivo con un tamaño de 1024 bytes            
            byte[] bufferSalida = new byte[1024];

            //Leo el archivo a enviar y almaceno el valor de Bytes leidos
            int numBytesLeidos = 0;
            numBytesLeidos = bis.read(bufferSalida);

            //Mientras el numero de Bytes sea distito de -1 continua la lectura.
            while (numBytesLeidos != -1) {
                mensajedigest.update(bufferSalida);
                //Leo el archivo y lo almaceno en el buffer
                numBytesLeidos = bis.read(bufferSalida);
            }
            
            byte resumen[] = mensajedigest.digest();
            
            
            textHexa = enHexadecimal(resumen);
            
            System.out.println(textHexa);
            
        } catch (NoSuchAlgorithmException ex) {
            System.err.println("Error no encuentra algoritmo. " + ex.toString());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HashThing.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HashThing.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            //Cierro las conexiones
            try {
                if (bis != null) {
                    bis.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(HashThing.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return textHexa;


    }

    private static String enHexadecimal(byte[] inf) {
        String hexadecimal = "";
        for (int i = 0; i < inf.length; i++) {
            String hx = Integer.toHexString(inf[i] & 0xFF);
            if (hx.length() == 1) {
                hexadecimal += "0";
            }
            hexadecimal += hx;
        }
        return hexadecimal.toUpperCase(); //lo devuelvo en mayus
    }

    

}
