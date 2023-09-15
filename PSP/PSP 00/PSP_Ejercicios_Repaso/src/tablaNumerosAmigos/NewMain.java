/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tablaNumerosAmigos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author produccion
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        HashMap<Integer, Integer> p = new HashMap();
        TreeMap<Integer, Integer> mapaB = new TreeMap();

        for (int i = 10000; i > 1; i--) {

            int sumaA = 1;
            for (int j = i - 1; j > 1; j--) {
                if (i % j == 0) {
                    sumaA += j;
                }
            }
            
            //System.out.println("key: " + i + " valor: " + sumaA);
            if (sumaA !=1 && sumaA != i) {
                p.put(i, sumaA);
                //mapaB.put(sumaA,i);
            }
        }

        for (Map.Entry<Integer, Integer> entry : p.entrySet()) {
            Object key = entry.getKey();
            Object val = entry.getValue();
            //System.out.println("key " + key + " valor: " + val);

            int val2;

            if (p.containsKey(val)) {
                val2 = (Integer) p.get(val);
                if (p.containsKey(val2)) {
                    if (val2 == (Integer) key && !mapaB.containsValue(val2)) {
                        mapaB.put((Integer)key, (Integer)val);
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
        FileWriter fw = null;
        try {
            fw = new FileWriter("tablaamigos.txt");
            fw.write("Numero A  || Numero B"+ "\n");

            for (Map.Entry<Integer, Integer> entry : mapaB.entrySet()) {
            Object key = entry.getKey();
            Object val = entry.getValue();

            fw.write( key + " || " + val + "\n");
            }
            

        } catch (IOException e) {
            System.err.println("IOException");
        } finally {
            try {
                if (fw!=null) {
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
            fw2.write("Numero A,Numero B"+ "\n");

            for (Map.Entry<Integer, Integer> entry : mapaB.entrySet()) {
            Object key = entry.getKey();
            Object val = entry.getValue();

            fw2.write( key + "," + val + "\n");
            }
            

        } catch (IOException e) {
            System.err.println("IOException");
        } finally {
            try {
                if (fw2!=null) {
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

            fw3.write( "{\" numero A\":" + key + ",\n\" numero B\":" + val + "},\n");
            }
            fw3.write("]");

        } catch (IOException e) {
            System.err.println("IOException");
        } finally {
            try {
                if (fw3!=null) {
                    fw3.close();
                }
            } catch (IOException e) {
                System.err.println("IOException cierre flujo");
            }
        }
        
        
    }

}
