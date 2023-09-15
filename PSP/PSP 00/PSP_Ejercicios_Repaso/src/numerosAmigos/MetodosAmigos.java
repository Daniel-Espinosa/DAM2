/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package numerosAmigos;

/**
 *
 * @author produccion
 */
public class MetodosAmigos {
    
    private int numeroA;
    private int numeroB;
    private int sumaA = 1;
    private int sumaB = 1;
    
    
    public boolean sonAmigos(){
        return valorA();

    }
    
       
    private boolean valorA(){
        for (int i = numeroA -1 ; i > 1; i--) {
            if (numeroA%i == 0) {
                sumaA += i;
            }
        } 
        
        if (sumaA==numeroB) {
            return valorB();
        }
                
        return false;
    }
    
    private boolean valorB(){
        for (int i = numeroB -1 ; i > 1; i--) {
            if (numeroB%i == 0) {
                sumaB += i;
            }
        } 
        
        if (sumaB==numeroA) {
            return true;
        }
                
        return false;
        
    }

    public void setNumeroA(int numeroA) {
        this.numeroA = numeroA;
    }

    public void setNumeroB(int numeroB) {
        this.numeroB = numeroB;
    }
    
    
    
}
