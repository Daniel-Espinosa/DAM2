/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema1_exament1_parte2;

import java.io.Serializable;

/**
 *
 * @author damt207
 */
public class Juego implements Serializable{
    //clave única, un título y un PEGI. Operaciones
    
    private int clave;
    private String titulo;
    private String pegi;

    public Juego(int clave, String titulo, String pegi) {
        this.clave = clave;
        this.titulo = titulo;
        this.pegi = pegi;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPegi() {
        return pegi;
    }

    public void setPegi(String pegi) {
        this.pegi = pegi;
    }

    @Override
    public String toString() {
        return "Juego{" + "clave=" + clave + ", titulo=" + titulo + ", pegi=" + pegi + '}';
    }
    
}
