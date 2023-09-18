/*
Vamos a trabajar con la clase Persona.

1. Crea un método para serializar un objeto de la clase Persona. Se trata de escribir en un
fichero los datos de un objeto de tipo Producto.
2. Crea un método para leer un objeto de tipo Persona del fichero creado anteriormente.
3. Crea un método que escriba en un fichero binario un ArrayList de objetos de tipo Persona.
4. Crea un método que vuelque en un ArrayList los objetos almacenados en el fichero anterior
*/
package ad_ua1_tarea2;

import java.util.ArrayList;

/**
 *
 * @author damt207
 */
public class AD_UA1_Tarea2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Persona p1 = new Persona("Daniel", "Espinosa" , 40);
        String nombreFichero = "pruebaA";
        String nombreFichero2 = "pruebaB";
        
        System.out.println("Creando objeto de tipo persona y cargando en el fichero " + nombreFichero + ".dat los datos de:\n" +  p1.toString());
        MetodosPersona.serializarPersona(nombreFichero, p1);
        
        System.out.println("\nLectura de los datos del fichero " + nombreFichero+".dat");
        MetodosPersona.deserializarPersona(nombreFichero);
        
        
        
        // generando Array list para añadir Personas y guardarlo en un .dat
        
        Persona p2 = new Persona("Albano", "Diez" , 26);
        Persona p3 = new Persona("Ramiro", "Gutierrez" , 35);
        
        ArrayList<Persona> personas = new ArrayList<>();
        
        personas.add(p1);
        personas.add(p2);
        personas.add(p3);
        
        System.out.println("");
        System.out.println("Creando objetos de tipo persona en un array list y cargando en el fichero " + nombreFichero2 + ".dat los datos de:\n" 
                +  p1.toString()
                +"\n" + p2.toString()
                +"\n" + p3.toString()
        );
        MetodosPersona.grabarColeccionFichero(nombreFichero2, personas);
        
        
        System.out.println("");
        System.out.println("\nLectura de los datos del fichero " + nombreFichero+".dat" + "con la informacion del Array list de Personas");
        MetodosPersona.leerColeccionFichero(nombreFichero2);
        
        
        
    }
    
}
