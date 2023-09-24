/*
2. En este ejercicio el estudiante ha de crear un programa en java que:
• Dependiendo del sistema operativo:
o Abre la calculadora de Windows.
o Abre el navegador Firefox en Ubuntu Linux.
• Usa ProcessHandle para obtener:
1. El nombre del comando
2. Los argumentos usados
3. Tiempo de comienzo.
4. Tiempo de CPU.
5. Propietario.
6. Número de hijos. 

 */
package com.cafeconpalito.psp_tema1_ejercicios;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author produccion
 */
public class Ejercicio2 {

    public static void propiedadesDelSistema() {

        String operatingSystem = System.getProperty("os.name").toLowerCase();

        if (operatingSystem.contains("win")) {
            sistemaWindows();
        }

        if (operatingSystem.contains("nux")) {
            sistemaLinux();
        }

    }

    /*
    1. El nombre del comando
    2. Los argumentos usados
    3. Tiempo de comienzo.
    4. Tiempo de CPU.
    5. Propietario.
    6. Número de hijos. 
     */
    private static void sistemaWindows() {

        Runtime rt = Runtime.getRuntime();
        String[] comando = {"calc.exe"};
        try {
            Process p = rt.exec(comando);
            ProcessHandle ph = p.toHandle();

            System.out.println("1. El nombre del comando");
            System.out.println(ph.info().command().get());

            System.out.println("\n2. Los argumentos usados");
            System.out.println(Arrays.toString(ph.info().arguments().orElse(new String[0])));

            System.out.println("\n3. Tiempo de comienzo");
            System.out.println(ph.info().startInstant().get());

            System.out.println("\n4. Tiempo de CPU");
            System.out.println(ph.info().totalCpuDuration().get());

            System.out.println("\n5. Propietario");
            System.out.println(ph.info().user().get());

            System.out.println("\n6. Número de hijos");
            System.out.println(ph.children().count());

        } catch (IOException ex) {
            Logger.getLogger(Ejercicio2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void sistemaLinux() {

        Runtime rt = Runtime.getRuntime();
        String[] comando = {"firefox"};
        try {
            Process p = rt.exec(comando);
            ProcessHandle ph = p.toHandle();

            System.out.println("1. El nombre del comando");
            System.out.println(ph.info().command().get());

            System.out.println("\n2. Los argumentos usados");
            System.out.println(Arrays.toString(ph.info().arguments().orElse(new String[0])));

            System.out.println("\n3. Tiempo de comienzo");
            System.out.println(ph.info().startInstant().get());

            System.out.println("\n4. Tiempo de CPU");
            System.out.println(ph.info().totalCpuDuration().get());

            System.out.println("\n5. Propietario");
            System.out.println(ph.info().user().get());

            System.out.println("\n6. Número de hijos");
            System.out.println(ph.children().count());

        } catch (IOException ex) {
            Logger.getLogger(Ejercicio2.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
    }

}
