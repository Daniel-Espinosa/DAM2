/*
Password:
a. Realiza un programa que solicite a un usuario una cadena.
b. compruebe:
i. - La cadena tiene 8 o más caracteres.
ii. - Contiene al menos una minúscula.
iii. - Contiene al menos una mayúscula.
iv. - Contiene al menos un número.
v. - Contiene al menos un carácter especial (-, _ o $)
c. Tras introducir la cadena mostrará un mensaje donde indicará si la
cadena es correcta, si tiene un número inferior a 8 caracteres o si no
cumple con los 4 últimos requisitos
 */
package psp_ejercicios_repaso.Contraseña;

import java.util.Scanner;

/**
 *
 * @author damt207
 */
public class PSP_Ejercicios_Repaso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ComprobarContraseñaSinREGEX contra = new ComprobarContraseñaSinREGEX();

        //Comprobando contraseña sin Expresiones Regulares
        do {

            System.out.println("Introduce una contraseña");
            contra.setContraseña(sc.nextLine());
        } while (!contra.comprobarContraseñaSinRegex());

        //Comprobando contraseña con Expresiones Regulares
        ComprobarContraseñaConREGEX contra2 = new ComprobarContraseñaConREGEX();

        do {
            System.out.println("Introduce una contraseña");
            contra2.setContraseña(sc.nextLine());
        } while (!contra2.comprobarContraseñaConRegex());

    }

}
