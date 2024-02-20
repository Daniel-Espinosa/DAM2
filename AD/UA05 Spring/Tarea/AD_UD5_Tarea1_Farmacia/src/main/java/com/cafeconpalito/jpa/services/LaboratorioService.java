/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.jpa.services;

import com.cafeconpalito.jpa.entities.Laboratorio;
import com.cafeconpalito.jpa.entities.Medicamento;
import com.cafeconpalito.jpa.repositories.ILaboratorio;
import java.util.List;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author cafeconpalito
 */
public class LaboratorioService {

    ApplicationContext context;
    ILaboratorio labor;

    public LaboratorioService(ApplicationContext context) {
        this.context = context;
        this.labor = context.getBean(ILaboratorio.class);

    }

    /**
     * Mostrar el nombre del laboratorio y la inversión realizada para el total
     * de medicamentos que hay en stock por cada laboratorio, ordenadas por
     * precio de menor a mayor.
     *
     * la inversion = Stock * Precio
     */
    public void laboratoriesWhitStock() {

        System.out.println("\nLABORATORIOS E INVERSION:");
        List<Laboratorio> lista = (List<Laboratorio>) labor.laboratoriesWhitStock();

        for (Laboratorio l : lista) {
            double aux = 0;
            for (Medicamento m : l.getMedicamentoList()) {
                aux += m.getStock() * m.getPvp();
            }
            System.out.println(
                    "\tNombre Lab: " + l.getNombre()
                    + " | Inversion: " + aux
            );
        }

    }

}
