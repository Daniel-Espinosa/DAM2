/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.cafeconpalito.cine_Examen.controller;

import com.cafeconpalito.cine_Examen.entities.Entrada;
import com.cafeconpalito.cine_Examen.services.EntradaService;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author damt207
 */
@RestController
@RequestMapping("/Entrada")
public class EntradaController {
    
    ApplicationContext context;
    EntradaService es;

    public EntradaController(ApplicationContext context) {
        this.context = context;
        this.es = new EntradaService(context);
    }
    
    
    @PutMapping("/nuevaEntrada")
    public ResponseEntity<Entrada> nuevaEntrada(int socio, int proyeccion, int numeroEntradas) {
        
        Entrada result= es.nuevaEntrada(socio, proyeccion, numeroEntradas);
        if (result != null) {
            return ResponseEntity.ok(result);
        }else{
            return ResponseEntity.notFound().build();
        }
        
        
    }
}
