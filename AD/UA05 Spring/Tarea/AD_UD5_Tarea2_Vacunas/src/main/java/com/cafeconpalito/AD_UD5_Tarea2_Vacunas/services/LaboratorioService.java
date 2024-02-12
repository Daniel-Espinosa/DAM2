/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.cafeconpalito.AD_UD5_Tarea2_Vacunas.services;

import com.cafeconpalito.AD_UD5_Tarea2_Vacunas.entities.Laboratorio;
import com.cafeconpalito.AD_UD5_Tarea2_Vacunas.repositories.LaboratorioRepository;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 *
 * @author produccion
 */
@Service
public class LaboratorioService {
    
    ApplicationContext context;
    
    LaboratorioRepository lab;

    public LaboratorioService(ApplicationContext context) {
        this.context = context;
        this.lab = context.getBean(LaboratorioRepository.class);
    }
    
    /**
     * Devuelve la lista de los laboratorios
     * @return 
     */
    public List<Laboratorio> allLaboratorio(){
        
        //Esto es el metodo largo, se puede comentar todo menos el return.
        List<Laboratorio> lista = lab.findAll();
        
        for (Laboratorio l : lista) {
            System.out.println(l.getNombre());
        }
        
        return lab.findAll();
    }
    
}
