/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.psp_tema5_tarea3_trabajofinal.Metodos;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 *
 * @author damt207
 */
public class HashTool {

    /**
     * Devuelve un String con todos los algoritmos permi)dos de hash.
     *
     * @return
     */
    public static ArrayList<String> getAlgorithms() {
        
        ArrayList<String> lista = new ArrayList();

        //String algorithms = "";

        for (Provider e : Security.getProviders()) {
            for (Provider.Service s : e.getServices()) {
                //System.out.println(s.getType());
                if (s.getType().contains("MessageDigest")) {
                    //System.out.println(s.getAlgorithm());
                    //algorithms += s.getAlgorithm() + "\n";
                    lista.add(s.getAlgorithm());
                }
            }
        }

        //System.out.println(algorithms);
        return lista;

    }

    /**
     * Calcular la función resumen (hash) de un fichero.
     *
     * @param algorithm algoritmo de encriptacion
     * @param file archivo a encriptar
     * @return devuelve el texto en Hexadecimal
     */
    public static String getFilehash(String algorithm, File file) {

        String textHexa = null;

        BufferedInputStream bis = null;

        try {

            MessageDigest mensajedigest;
            mensajedigest = MessageDigest.getInstance(algorithm);

            //Creo el Bufer para leer el File
            bis = new BufferedInputStream(new FileInputStream(file));

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

            //System.out.println(textHexa);
        } catch (NoSuchAlgorithmException | IOException ex) {
            Logs.LOGGER_ERRORS.log(Level.SEVERE, null, ex);
        } finally {
            //Cierro las conexiones
            try {
                if (bis != null) {
                    bis.close();
                }
            } catch (IOException ex) {
                Logs.LOGGER_ERRORS.log(Level.SEVERE, null, ex);
            }
        }


        Logs.LOGGER_USER.log(Level.INFO, "Algoritmo de encriptaci\u00f3n File | Algoritmo: {0} | File: {1} | Resultado: {2} ", new Object[]{algorithm, file.getName(),textHexa});

        return textHexa;

    }

    /**
     * Calcular la función resumen de una cadena de texto
     */
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

            Logs.LOGGER_ERRORS.log(Level.SEVERE, null, ex);
            return null;
        }
        
        Logs.LOGGER_USER.log(Level.INFO, "Algoritmo de encriptaci\u00f3n String | Algoritmo: {0} | String: {1} | Resultado: {2}", new Object[]{algorithm, plaintext,textHexa});

        return textHexa;
    }

    /**
     * Trasnforma un Array de Bytes a y lo devuelve en Hexadecimal.
     *
     * @param inf
     * @return
     */
    public static String enHexadecimal(byte[] inf) {
        String hexadecimal = "";
        for (int i = 0; i < inf.length; i++) {
            String hx = Integer.toHexString(inf[i] & 0xFF);
            if (hx.length() == 1) {
                hexadecimal += "0";
            }
            hexadecimal += hx;
        }

        return hexadecimal;

    }

}
