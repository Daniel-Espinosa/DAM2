/*
Ejercicios comunicación de datos entre procesos
9. En este ejercicio el estudiante debe realizar un ejercicio que lance el comando:
• Imprime el sistema operativo donde estamos (ver en enlace del ejercicio 2).
• Esperamos 5 segundos.
• Si estamos en Windows, abre ipconfig e imprime su salida por pantalla y en un fichero.
• Si estamos en Linux o Mac OS abrimos ifconfig e imprimimos su salida por pantalla y en un fichero.
• Esperamos tres segundos.
• Imprimimos “Las redes parecen que van bien".
 */
package com.cafeconpalito.psp_tema1_tarea1;



/**
 *
 * @author damt207
 */
public class Main {

    public static void main(String[] args) {

        /*
        9. En este ejercicio el estudiante debe realizar un ejercicio que lance el comando:
        • Imprime el sistema operativo donde estamos (ver en enlace del ejercicio 2).
        • Esperamos 5 segundos.
        • Si estamos en Windows, abre ipconfig e imprime su salida por pantalla y en un fichero.
        • Si estamos en Linux o Mac OS abrimos ifconfig e imprimimos su salida por pantalla y en un fichero.
        • Esperamos tres segundos.
        • Imprimimos “Las redes parecen que van bien".
         */     
        Metodos.ejercicio9();
        
        //ATENCIÓN!!. : Modifica haz otra versión del ejercicio utilizando el bloque “try-with-resources”.
        Metodos.ejercicio9_v2();
        
        //ATENCIÓN2!!: Añade al ejercicio anterior el código necesario para imprimir también la salida de error estándar sterr.
        //ERROR PROVOCADO A PROPOSITO PARA QUE GUARDE LA INFORMACION DEL ERROR EN EL TXT
        Metodos.ejercicio9_v3();
    }

}
