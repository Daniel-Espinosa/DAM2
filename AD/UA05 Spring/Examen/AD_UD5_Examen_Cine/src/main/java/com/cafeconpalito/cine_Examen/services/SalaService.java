/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.cafeconpalito.cine_Examen.services;

import com.cafeconpalito.cine_Examen.entities.Proyeccion;
import com.cafeconpalito.cine_Examen.entities.Sala;
import com.cafeconpalito.cine_Examen.repositories.SalaRepository;
import java.util.LinkedList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 *
 * @author damt207
 */
@Service
public class SalaService {
    
    ApplicationContext context;
    SalaRepository sr;

    public SalaService(ApplicationContext context) {
        this.context = context;
        this.sr = context.getBean( SalaRepository.class);
    }
    
    public List<Object[]> numPeliculasSala(){
        
        List<Object[]> l = new LinkedList<>();
        
        
        for (Sala s : sr.findAll()) {
            int NumPeliculas = 0;
            for (Proyeccion p : s.getProyeccionList()) {
                NumPeliculas ++;
            }
            l.add(new Object[]{s,"Numero de Peliculas: " +NumPeliculas});
            
        }
        
        return l;
    }
    
}
