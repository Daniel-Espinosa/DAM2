/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.cafeconpalito.AD_UD5_Tarea2_Vacunas.services;

import com.cafeconpalito.AD_UD5_Tarea2_Vacunas.entities.Laboratorio;
import com.cafeconpalito.AD_UD5_Tarea2_Vacunas.entities.Persona;
import com.cafeconpalito.AD_UD5_Tarea2_Vacunas.repositories.PersonaRepository;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 *
 * @author produccion
 */
@Service
public class PersonaService {

    ApplicationContext context;
    PersonaRepository pr;

    public PersonaService(ApplicationContext context) {
        this.context = context;
        this.pr = context.getBean(PersonaRepository.class);
    }

    /**
     * Lista con los datos de personas que han recibido un número determinado de
     * dosis
     *
     * @param ndosis
     * @return
     */
    public List<Persona> personasConNdosis(int ndosis) {

        if (pr.findByNdosis(ndosis).isEmpty()) {
            return null;
        }

        return pr.findByNdosis(ndosis);

    }

    /**
     * Lista de personas que han sido vacunadas con dosis de un laboratorio
     * determinado
     *
     * Este metodo de end point no tiene mucho sentido es mucho mas eficas
     * utilizar como parametro el nombre del laboratorios
     *
     * @param laboratorio laboratorio
     * @return
     */
    public List<Persona> findByVacunaLaboratorio(Laboratorio laboratorio) {

        if (pr.findByVacunaLaboratorio(laboratorio).isEmpty()) {
            return null;
        }

        return pr.findByVacunaLaboratorio(laboratorio);

    }

    /**
     * Lista de personas que han sido vacunadas con dosis de un laboratorio
     * determinado
     *
     * Metodo Arreglado
     *
     * @param name
     * @return
     */
    public List<Persona> findByVacunaLabName(String name) {

        if (pr.findByVacunaLabName(name).isEmpty()) {
            return null;
        }
        return pr.findByVacunaLabName(name);

    }

    /**
     * Añadir una persona
     *
     * @param persona
     * @return la persona recién incorporada a la base de datos
     */
    public Persona addPersona(Persona persona){
        
        return pr.save(persona);
        
    }

}
