/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.cafeconpalito.cine_Examen.controller;

import com.cafeconpalito.cine_Examen.entities.Pelicula;
import com.cafeconpalito.cine_Examen.services.PeliculaService;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author damt207
 */
@RestController
@RequestMapping("/Pelicula")
public class PeliculaController {
    
    
    ApplicationContext context;
    PeliculaService ps;

    public PeliculaController(ApplicationContext context) {
        this.context = context;
        this.ps = new PeliculaService(context);
    }
    
    
    @GetMapping("/peliculasEnSala/{sala}")
    public ResponseEntity<List<Pelicula>> peliculasEnSala(@PathVariable int sala) {
        
        List<Pelicula> result= ps.peliculasEnSala(sala);
        if (!result.isEmpty()) {
            return ResponseEntity.ok(result);
        }else{
            return ResponseEntity.notFound().build();
        }
        
        
    }
    
}
