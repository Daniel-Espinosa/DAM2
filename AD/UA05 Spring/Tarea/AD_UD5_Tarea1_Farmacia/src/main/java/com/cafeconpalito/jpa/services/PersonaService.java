/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.jpa.services;

import com.cafeconpalito.jpa.entities.Persona;
import com.cafeconpalito.jpa.repositories.IPersona;
import java.util.List;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author produccion
 */
public class PersonaService {

    ApplicationContext context;
    IPersona perso;

    public PersonaService(ApplicationContext context) {
        this.context = context;
        this.perso = context.getBean(IPersona.class);
    }
    
    /**
     * Mostrar los datos de una persona a partir de su identificador.
     * @param id 
     * @return  
     */
    public Persona findByID(Integer id){
        
        System.out.println("\nPERSONA POR ID:");
        Persona p = perso.findById(id).orElse(null);
        
        if (p!=null) {
            
            System.out.println(
                    "\tID: " + p.getPkpersona() +
                    " | Nombre: " + p.getNombre()+
                    " | Fecha Nacimiento: " + p.getFechanacimiento()
                    );
        }
        
        return p;
        
    }
    
    /**
     * Mostrar todos los datos de las personas que están recibiendo un tratamiento.
     */
    public void findAllWhitTreatment(){
        List<Persona> lista = (List<Persona>) perso.findAll();
        
        System.out.println("\nPERSONAS CON TRATAMIENTO:");
        for (Persona p : lista) {
            
            if (!p.getTratamientoList().isEmpty()) {
                System.out.println(
                    "\tID: " + p.getPkpersona() +
                    " | Nombre: " + p.getNombre()+
                    " | Fecha Nacimiento: " + p.getFechanacimiento()
                    );
            }

        }
    }
    

}
