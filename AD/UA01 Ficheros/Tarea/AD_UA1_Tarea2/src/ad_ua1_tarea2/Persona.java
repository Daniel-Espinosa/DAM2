/*
1. Crea un método para serializar un objeto de la clase Persona. Se trata de escribir en un
fichero los datos de un objeto de tipo Producto.
2. Crea un método para leer un objeto de tipo Persona del fichero creado anteriormente.
3. Crea un método que escriba en un fichero binario un ArrayList de objetos de tipo Persona.
4. Crea un método que vuelque en un ArrayList los objetos almacenados en el fichero anterior
*/
package ad_ua1_tarea2;

import java.io.Serializable;

/**
 *
 * @author damt207
 */
public class Persona implements Serializable{
    
    private String nombre;
    private String apellido;
    private int edad;

    public Persona() {
    }

    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + '}';
    }
    
    
    
    
}
