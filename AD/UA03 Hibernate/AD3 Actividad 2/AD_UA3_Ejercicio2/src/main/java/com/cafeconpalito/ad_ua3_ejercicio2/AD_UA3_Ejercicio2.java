/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.cafeconpalito.ad_ua3_ejercicio2;

import com.cafeconpalito.ad_ua3_ejercicio2.Entity.Cliente;
import com.cafeconpalito.ad_ua3_ejercicio2.Entity.Producto;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.persistence.*;

/**
 *
 * @author damt207
 */
public class AD_UA3_Ejercicio2 {

    public static void main(String[] args) {

        //Creo la conexion
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.cafeconpalito_AD_UA3_Ejercicio2_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

        System.out.println("");
        productos(em);
        System.out.println("");
        todoProducto(em);
        System.out.println("");
        porNombreProducto(em);
        System.out.println("");
        consultaPersonalizada(em);
        System.out.println("");
        //insertarDato(em);
        System.out.println("");

        //Cierro la conexion
        em.close();
        emf.close();

    }

    /*
    5. Realiza los siguientes métodos, utilizando las NamedQuery generadas: 
    a. Método que muestra por pantalla el listado de productos: pkproducto, nombre, precio, nombre de la categoría. 
    b. Método que muestra por pantalla todos los datos de un producto a partir de su pkproducto. 

    
     */
    /**
     * a.Método que muestra por pantalla el listado de productos: pkproducto,
     * nombre, precio, nombre de la categoría.
     *
     * @param em
     */
    public static void productos(EntityManager em) {

        //Busqueda
        Query q = em.createNamedQuery("Producto.findAll");
        ArrayList<Producto> lista = (ArrayList<Producto>) q.getResultList();

        for (Producto i : lista) {
            System.out.println("ID Producto: " + i.getPkproducto() + " Nombre Producto: " + i.getNombre() + " Precio: " + i.getPvp() + " Categoria: " + i.getFkcategoria().getNombre());
        }

    }

    /**
     * b.Método que muestra por pantalla todos los datos de un producto a partir
     * de su pkproducto.
     *
     * @param em
     */
    public static void todoProducto(EntityManager em) {

        //Busqueda
        Query q = em.createNamedQuery("Producto.findByPkproducto");
        q.setParameter("pkproducto", 1);
        ArrayList<Producto> lista = (ArrayList<Producto>) q.getResultList();

        for (Producto i : lista) {
            System.out.println("ID Producto: " + i.getPkproducto() + " Nombre Producto: " + i.getNombre() + " Precio: " + i.getPvp() + " Categoria: " + i.getFkcategoria().getNombre());
        }

    }

    public static void porNombreProducto(EntityManager em) {

        //Busqueda
        Query q = em.createNamedQuery("Producto.findByNombre");
        //String n = "Camiseta Nike";
        q.setParameter("nombre", "Camiseta Nike");

        ArrayList<Producto> lista = (ArrayList<Producto>) q.getResultList();

        for (Producto i : lista) {
            System.out.println("ID Producto: " + i.getPkproducto() + " Nombre Producto: " + i.getNombre() + " Precio: " + i.getPvp() + " Categoria: " + i.getFkcategoria().getNombre());
        }

    }

    public static void consultaPersonalizada(EntityManager em) {
        //Busqueda
        Query q = em.createNamedQuery("Producto.findByPvpStock");
        //String n = "Camiseta Nike";
        BigDecimal bd = new BigDecimal(10);
        q.setParameter("pvp", bd);
        q.setParameter("stock", 5);

        ArrayList<Producto> lista = (ArrayList<Producto>) q.getResultList();

        for (Producto i : lista) {
            System.out.println("ID Producto: " + i.getPkproducto() + " Nombre Producto: " + i.getNombre() + " Precio: " + i.getPvp() + " Stock: " + i.getStock() + " Categoria: " + i.getFkcategoria().getNombre());
        }
    }
    
    public static void insertarDato(EntityManager em){
        
        Query insercion = em.createNativeQuery("INSERT INTO Cliente (nombre, password) VALUES (:nombre , :password);");
        em.getTransaction().begin();
        insercion.setParameter("nombre", "Daniel");
        insercion.setParameter("password", "1234");
        insercion.executeUpdate();
        em.getTransaction().commit();
        
    }
    
    
    
}
