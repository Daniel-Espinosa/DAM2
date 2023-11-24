
import java.util.Scanner; 

public class SumaPares {


    public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            
            int num, suma = 0;
                        
            System.out.print("Ingrese un número entero positivo: ");
            
            num = sc.nextInt();
            
            for (int i = 2; i <= num ;i += 2){ //esta es la línea 8
                
                suma +=i;
            }
            
            System.out.println("La suma de los números pares comprendidos entre 1 y " + num +  " es: " + suma); 

    }
}