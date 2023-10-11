/*
2. EJERCICIO 
2. Realiza un programa en java que realice estas dos operaciones sobre un fichero binario que almacena objetos de tipo JUEGO, 
donde cada juego está identificado por una clave única, un título y un PEGI. Operaciones:

1)     Método que recibe el nombre del fichero y un objeto para añadir al fichero. El método comprueba que no exista el objeto que se quiere añadir, 
       es decir, que no esté almacenado otro objeto con la misma clave.  Siempre se añade contenido al fichero.
2)     Método que borra un JUEGO del fichero anterior, localizado a partir del identificador.
3)     Documenta bien el código y genera el javadoc.

Criterios de evaluación:

·        Se han probado y documentado las aplicaciones (2 puntos)
·        Se han previsto y gestionado las excepciones (2 puntos)
·        Se han gestionado los diferentes tipos de error (2 puntos)
*/
package tema1_exament1_parte2;

import java.io.File;

/**
 *
 * @author damt207
 */
public class Tema1_Exament1_Parte2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        //fichero con el que se quiere trabajar
        File archivo = new File("juego.dat");
        
        
        
        System.out.println("Lectura del fichero inicial");
        ControladorJuego.leerFichero(archivo);
        
        System.out.println("\nlisntando juegos del fichero");
        ControladorJuego.listarJuegos();
                
        System.out.println("\nañadiendo juegos");
        ControladorJuego.añadirJuego(archivo, 1, "GTA1", "PEGI16");
        ControladorJuego.añadirJuego(archivo, 2, "GTA2", "PEGI16");
        ControladorJuego.añadirJuego(archivo, 3, "GTA3", "PEGI16");
        ControladorJuego.añadirJuego(archivo, 4, "GTA4", "PEGI16");
        ControladorJuego.añadirJuego(archivo, 5, "GTA5", "PEGI16");
        ControladorJuego.añadirJuego(archivo, 6, "Zelda", "PEGI12");
        
        System.out.println("\nlistando juegos despues de añadir");
        ControladorJuego.listarJuegos();
        
        
        System.out.println("\nBorrando juego 5");
        ControladorJuego.borrarJuego(archivo, 5);
        
        System.out.println("\nlistando juegos despues del borrado");
        ControladorJuego.listarJuegos();
    }
    
}
