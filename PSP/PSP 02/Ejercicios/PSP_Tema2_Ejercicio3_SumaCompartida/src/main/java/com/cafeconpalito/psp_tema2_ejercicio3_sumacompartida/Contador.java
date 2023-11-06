/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.psp_tema2_ejercicio3_sumacompartida;

/**
 *
 * @author damt207
 */
public class Contador {
    
    private int numero;

    public Contador() {
        numero=100;
    }
    
    /*
    //Synchronized Methods
    public synchronized void sumaContador(int valor){
        numero=numero+valor;
    }
    
    //Synchronized Methods
    public synchronized void restaContador(int valor){
        numero=numero-valor;
    }
    */
    
    /*
    //Synchronized Segmento de Codigo
    public  void sumaContador(int valor){
        synchronized(this){
        numero=numero+valor;
        }
    }
    
    //Synchronized Segmento de Codigo
    public  void restaContador(int valor){
        synchronized (this) {
        numero=numero-valor;    
        }  
    }
    */
    
    //Sincronizando en segmento de Codigo en HiloSuma
    public  void sumaContador(int valor){
        numero=numero+valor;
    }
    
    //Synchronized en segmento de Codigo en HiloResta
    public  void restaContador(int valor){
        numero=numero-valor;    
    }

    public int getNumero() {
        return numero;
    }
    
}
