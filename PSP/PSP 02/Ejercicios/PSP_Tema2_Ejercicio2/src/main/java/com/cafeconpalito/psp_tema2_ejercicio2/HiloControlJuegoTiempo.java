/*
El segundo hilo llama a ejecutar al primero y se duerme un segundo durante 10 veces.
Cada segundo, accede a la variable booleana del del primer hilo para comprobar si ha “acertado” o no.
Si el valor es acertado, termina la ejecución del hilo.
Si no se acierta el número después del tiempo fijado, muestra el mensaje “Fin del tiempo de juego. Perdiste”.*/
package com.cafeconpalito.psp_tema2_ejercicio2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author produccion
 */
public class HiloControlJuegoTiempo extends Thread {

    @Override
    public void run() {

        HiloNumeroAleatorio hna = new HiloNumeroAleatorio();

        hna.start();

        for (int i = 0; i < 10; i++) {

            try {

                //Hilo duerme 1 segundo;
                Thread.sleep(1000);
                //System.out.println("tiempo trasncurrido: " + i + " segundos");

            } catch (InterruptedException ex) {
                Logger.getLogger(HiloControlJuegoTiempo.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (hna.isAcertar()) {
                hna.stop();
                break;
            }
        }

        System.out.println("Fin del tiempo de juego. Perdiste");
        hna.stop();

    }

}
