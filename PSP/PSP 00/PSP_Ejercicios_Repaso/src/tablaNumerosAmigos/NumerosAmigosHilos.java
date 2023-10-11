/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablaNumerosAmigos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author damt207
 */
public class NumerosAmigosHilos extends Thread{
    
    public HashMap<Integer, Integer> p = new HashMap();
    public TreeMap<Integer, Integer> mapaB = new TreeMap();
    public int valorInicial;
    public int valorFinal;

    public NumerosAmigosHilos(int valorInicial, int valorFinal) {
        this.valorInicial = valorInicial;
        this.valorFinal = valorFinal;
    }
    
    
    
    @Override
    public void run() {
    
        numerosAmigos();
        
    }
        
    public void numerosAmigos(){
        
        for (int i = 20000000; i > 1; i--) {

            int division = i / 2;
            int sumaA = 1;
            //String cadena = "1";
            //System.out.println("numero comprobar " + i);
            if (i % 2 == 0 || i % 3 == 0 || i % 5 == 0 || i % 7 == 0 || i % 11 == 0) {
                for (int j = 2; j < division; j++) {
                    division = i / j;
                    if (i % j == 0) {
                        sumaA += j + (division);
                        //cadena += " + "+ j ;
                    }
                }
            }
            
            //System.out.println("key: " + i + " valor: " + sumaA);
            if (sumaA != 1 && sumaA != i) {
                p.put(i, sumaA);
                //mapaB.put(sumaA,i);
            }
        }

        System.out.println("");
        //System.out.println("contador : " +cont);
        for (Map.Entry<Integer, Integer> entry : p.entrySet()) {
            Object key = entry.getKey();
            Object val = entry.getValue();
            //System.out.println("key " + key + " valor: " + val);

            int val2;

            if (p.containsKey(val)) {
                val2 = (Integer) p.get(val);
                if (p.containsKey(val2)) {
                    if (val2 == (Integer) key && !mapaB.containsValue(val2)) {
                        mapaB.put((Integer) key, (Integer) val);
                    }
                }
            }
        }

        // imprime por pantalla el TreeMap
        /*
        for (Map.Entry<Integer, Integer> entry : mapaB.entrySet()) {
            Object key = entry.getKey();
            Object val = entry.getValue();
            
            System.out.println("key " + key + " valor: " + val);
            
        }
         */
        // ESCRIBIR EN UN TXT
        
    }
    
    public void escribirFichero(){
        
        FileWriter fw = null;
        try {
            fw = new FileWriter("tablaamigos.txt");
            fw.write("Numero A  || Numero B" + "\n");

            for (Map.Entry<Integer, Integer> entry : mapaB.entrySet()) {
                Object key = entry.getKey();
                Object val = entry.getValue();

                fw.write(key + " || " + val + "\n");
            }

        } catch (IOException e) {
            System.err.println("IOException");
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                System.err.println("IOException cierre flujo");
            }
        }

        // ESCRIBIR EN UN CSV EN DOS COLUMNAS SEPARADAS POR COMAS
        FileWriter fw2 = null;
        try {
            fw2 = new FileWriter("tablaamigos.csv");
            fw2.write("Numero A,Numero B" + "\n");

            for (Map.Entry<Integer, Integer> entry : mapaB.entrySet()) {
                Object key = entry.getKey();
                Object val = entry.getValue();

                fw2.write(key + "," + val + "\n");
            }

        } catch (IOException e) {
            System.err.println("IOException");
        } finally {
            try {
                if (fw2 != null) {
                    fw2.close();
                }
            } catch (IOException e) {
                System.err.println("IOException cierre flujo");
            }
        }

        // ESCRIBIR EN UN JSON EN DOS COLUMNAS SEPARADAS POR COMAS
        FileWriter fw3 = null;
        try {
            fw3 = new FileWriter("tablaamigos.json");
            fw3.write("[\n");

            for (Map.Entry<Integer, Integer> entry : mapaB.entrySet()) {
                Object key = entry.getKey();
                Object val = entry.getValue();

                fw3.write("{\" numero A\":" + key + ",\n\" numero B\":" + val + "},\n");
            }
            fw3.write("]");

        } catch (IOException e) {
            System.err.println("IOException");
        } finally {
            try {
                if (fw3 != null) {
                    fw3.close();
                }
            } catch (IOException e) {
                System.err.println("IOException cierre flujo");
            }
        }

    }
        
        
    }
    
    

