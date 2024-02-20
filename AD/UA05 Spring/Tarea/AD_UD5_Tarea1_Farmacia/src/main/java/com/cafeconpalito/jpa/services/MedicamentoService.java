/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.jpa.services;

import com.cafeconpalito.jpa.entities.Medicamento;
import com.cafeconpalito.jpa.entities.Persona;
import com.cafeconpalito.jpa.entities.Tratamiento;
import com.cafeconpalito.jpa.repositories.IMedicamento;
import com.cafeconpalito.jpa.repositories.IPersona;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 *
 * @author cafeconpalito
 */
@Service
public class MedicamentoService {

    ApplicationContext context;
    IMedicamento medic;
    IPersona perso;

    public MedicamentoService(ApplicationContext context) {
        this.context = context;
        this.medic = context.getBean(IMedicamento.class);
        this.perso = context.getBean(IPersona.class);
    }

    /**
     * Mostrar los datos de todos los medicamentos.
     */
    public void allMedicamento() {
        List<Medicamento> lista = (List<Medicamento>) medic.findAll();

        System.out.println("\nTODOS LOS MEDICAMENTOS:");
        for (Medicamento medicamento : lista) {
            System.out.println(
                    "\tID Medicamento: " + medicamento.getPkmedicamento()
                    + " | Formato: " + medicamento.getFormato()
                    + " | PVP: " + medicamento.getPvp()
                    + " | Stock: " + medicamento.getStock()
                    + " | ID Laboratorio: " + medicamento.getAklaboratorio().getNombre()
            );
        }

    }

    /**
     * Mostrar los datos de los medicamentos con los que se está tratando a una
     * persona determinada.
     *
     * @param idPersona
     */
    public void findByPersonID(int idPersona) {

        System.out.println("\nMEDICAMENTO DEL PASIENTE:");
        PersonaService ps = new PersonaService(context);
        Persona p = ps.findByID(idPersona);

        if (p != null) {
            List<Tratamiento> lista = p.getTratamientoList();

            if (lista.isEmpty()) {
                System.out.println("La persona no tiene tratamientos");
            } else {

                for (Tratamiento t : lista) {

                    Medicamento medicamento = t.getAkmedicina();

                    System.out.println(
                            "\tID Medicamento: " + medicamento.getPkmedicamento()
                            + " | Formato: " + medicamento.getFormato()
                            + " | PVP: " + medicamento.getPvp()
                            + " | Stock: " + medicamento.getStock()
                            + " | ID Laboratorio: " + medicamento.getAklaboratorio().getNombre()
                            + " | Fecha Tratamiento: " + t.getFecha()
                    );
                }
            }
        }
    }

    public Medicamento findByID(int id) {
        return medic.findById(id).orElse(null);
    }

}
