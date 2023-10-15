/*
4. Utilizando la clase ProcessBuilder, se debe crear un programa en Java que:
    1. Pregunte una app con interfaz gráfica en el Sistema Operativo actual.
    2. Abra la app.
    3. Obtener la información del entorno del proceso.
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
public class Ejercicio4 {

    public static void procesBuildHandler() {

        ProcessBuilder pb = new ProcessBuilder("notepad.exe");

        try {
            Process p = pb.start();

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
            Logger.getLogger(Ejercicio4.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
