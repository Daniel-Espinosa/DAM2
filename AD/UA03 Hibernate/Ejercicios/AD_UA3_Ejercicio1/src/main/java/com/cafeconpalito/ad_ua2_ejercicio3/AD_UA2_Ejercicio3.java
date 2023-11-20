/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cafeconpalito.ad_ua2_ejercicio3;

import java.util.ArrayList;
import javax.persistence.*;



/**
 *
 * @author damt207
 */
public class AD_UA2_Ejercicio3 {

    public static void main(String[] args) {
        
        //Creo la conexion
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("com.cafeconpalito_AD_UA2_Ejercicio3_jar_1.0-SNAPSHOTPU");
        EntityManager em =emf.createEntityManager();
        
        /*
        //Busqueda
        Query c1 = em.createNamedQuery("Cliente.findAll");
        ArrayList<Cliente> listaClientes = (ArrayList<Cliente>) c1.getResultList();
        
        for (Cliente c : listaClientes) {
            System.out.println(c.getNombre());
        }
        */
        
        
        //Cierro la conexion
        em.close();
        emf.close();
        
    }
}
