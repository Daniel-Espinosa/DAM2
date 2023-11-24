/* 
 * DemoTelegrama.java 
 */ 
package pruebas; 
import objetosNegocio.Telegrama; 
/** 
 * Esta clase permite probar la clase Telegrama
 * @author mdomitsu 
 */ 
public class DemoTelegrama { 
 /** 
 * Esta funcion prueba los metodos de la clase Telegrama 
 * @param args Argumentos en la linea de comando 
 */ 
 public static void main(String[] args) { 
 Telegrama telegrama1 = new Telegrama("Ordinario", 8); 
 telegrama1.calculaCosto(); 
 System.out.println(telegrama1); 
 telegrama1.setNumPalabras(12); 
 telegrama1.calculaCosto(); 
 System.out.println(telegrama1); 
 Telegrama telegrama2 = new Telegrama("Urgente", 8); 
 telegrama2.calculaCosto(); 
 System.out.println(telegrama2); 
 telegrama2.setNumPalabras(12); 
 telegrama2.calculaCosto(); 
 System.out.println(telegrama2); 
 } 
} 
