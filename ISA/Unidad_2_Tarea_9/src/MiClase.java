
import java.util.Scanner;

public class MiClase {
//Iniciamos el método principal de la clase

    public static void main(String[] args) {
//Iniciamos -con try- la estructura try-catch envolviendo el código que puede generar excepción
        try {
//Creamos el objeto 
            Scanner teclado = new Scanner(System.in);
//declaramos las variables 
            int numerol;
            int numero2;
            int resultado;
//Inicializamos las variables
            System.out.println("Introduzca el primer nnmero");
            numerol = teclado.nextInt();
            System.out.println("Introduzca el segundo nnmero");
            numero2 = teclado.nextInt();
//controlamos el error que puede producirse al dividir por cero
            if (numerol != 0 && numero2 != 0) {
//aplicamos el método
                resultado = suma_enteros(numerol, numero2);
                System.out.println("El resultado es " + resultado);
            }
//capturamos el error genérico que pudiera producirse
        } catch (Exception e) {
            System.out.println("se ha producido un error");
        }
//Aquí termina la estructura try-catch
    }
//creamos un método dentro de la clase, que usamos en el método principal
/*El método suma_enteros devuelve (con return un número entero que declaramos e inicializamos
*dentro del mismo método; 
*para la asignación de valor recibe dos números enteros y los suma*/
    private static int suma_enteros(int a, int b) {
        int resultado = a + b;
        return resultado;
    }
}
