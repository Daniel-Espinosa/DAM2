/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.cafeconpalito.cine_Examen.services;

import com.cafeconpalito.cine_Examen.entities.Pelicula;
import com.cafeconpalito.cine_Examen.entities.Proyeccion;
import com.cafeconpalito.cine_Examen.repositories.PeliculaRepository;
import java.util.LinkedList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 *
 * @author damt207
 */
@Service
public class PeliculaService {
    
    ApplicationContext context;
    PeliculaRepository pr;

    public PeliculaService(ApplicationContext context) {
        this.context = context;
        this.pr = context.getBean(PeliculaRepository.class);
    }
    
    public List<Pelicula> peliculasEnSala(int sala){
        
        List<Pelicula> l = new LinkedList<>();
        
        for (Pelicula p : pr.findAll()) {
            for (Proyeccion proyec : p.getProyeccionList()) {
                if (proyec.getFksala().getPksala() == sala) {
                    l.add(p);
                }
            }
        }
        
        return l;
    }
    
    

    
}
