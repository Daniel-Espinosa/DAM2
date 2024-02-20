/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.jpa.services;

import com.cafeconpalito.jpa.entities.Tratamiento;
import com.cafeconpalito.jpa.repositories.ITratamiento;
import java.time.Instant;
import java.util.Date;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author cafeconpalito
 */
public class TratamientoService {

    ApplicationContext context;
    ITratamiento trata;

    public TratamientoService(ApplicationContext context) {
        this.context = context;
        this.trata = context.getBean(ITratamiento.class);
    }

    /**
     * Asignar un medicamento a una persona, es decir, guardar un registro nuevo
     * en tratamiento.
     *
     * @param idPersona
     * @param idMedicamento
     */
    public void addTratamiento(int idPersona, int idMedicamento) {

        System.out.println("\nINSERTANDO TRATAMIENTO A LA PERSONA:");
        Date fecha = Date.from(Instant.now());
        
        PersonaService ps = new PersonaService(context);
        MedicamentoService ms = new MedicamentoService(context);
        
        int idmax=0;
        for (Tratamiento tb : trata.findAll()) {
            if (idmax< tb.getPktratamiento()) {
                idmax = tb.getPktratamiento();
            }
        }
        idmax+=1;
        
        Tratamiento t = new Tratamiento(idmax, fecha,ms.findByID(idMedicamento), ps.findByID(idPersona));
        System.out.println("\tMedicamento ID: " +t.getAkmedicina().getPkmedicamento() + " | PVP: " + t.getAkmedicina().getPvp());
        
        
        System.out.println("\nINSERCION REALIZADA EN TRATAMIENTO CON ID: " + idmax + " CON FECHA: " + fecha + "\n");
        
        trata.save(t);
    }

}
