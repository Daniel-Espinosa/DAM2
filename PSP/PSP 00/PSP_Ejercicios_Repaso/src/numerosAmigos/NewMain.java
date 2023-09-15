/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package numerosAmigos;

/**
 *
 * @author produccion
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        MetodosAmigos prueba = new MetodosAmigos();
        
        prueba.setNumeroA(1184);
        prueba.setNumeroB(1210);
        
        System.out.println(prueba.sonAmigos());
        
    }
    
}
