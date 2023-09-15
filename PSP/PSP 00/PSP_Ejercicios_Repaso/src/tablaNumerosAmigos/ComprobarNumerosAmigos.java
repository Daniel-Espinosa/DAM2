/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablaNumerosAmigos;

/**
 *
 * @author produccion
 */
public class ComprobarNumerosAmigos {
    
 
    
    private static boolean sonAmigos(int numeroA, int numeroB){
        return valorA(numeroA, numeroB);
    }
    
       
    private static boolean valorA(int numeroA, int numeroB){
        int sumaA = 1;
        for (int i = numeroA -1 ; i > 1; i--) {
            if (numeroA%i == 0) {
                sumaA += i;
            }
        } 
        
        if (sumaA==numeroB) {
            //System.out.println(sumaA + " sumaA = numeroB " +numeroB);
            return valorB(numeroA,numeroB);
        }
        
        
        return false;
    }
    
    private static boolean valorB(int numeroA,int numeroB){
        int sumaB = 1;
        for (int i = numeroB -1 ; i > 1; i--) {
            if (numeroB%i == 0) {
                sumaB += i;
            }
        } 
        
        if (sumaB==numeroA) {
           //System.out.println(sumaB + " sumaB = numeroA " +numeroA);
            return true;
        }
        
        //System.out.println("NumeroA: " + numeroA + " numeroB: " + numeroB);
        return false;
        
    }
    
    public static void comprobarNumeros(){
        
        for (int i = 10000; i > 1; i--) {
            for (int j = i-1; j > 1; j --) {
                
                if (sonAmigos(i, j)) {
                    System.out.println( i + " " + j + " : son amigos");
                }
                
            }
        }
        
    }

    
  
}
