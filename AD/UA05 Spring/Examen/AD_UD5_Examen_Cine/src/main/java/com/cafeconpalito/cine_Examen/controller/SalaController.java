/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.cafeconpalito.cine_Examen.controller;

import com.cafeconpalito.cine_Examen.services.SalaService;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author damt207
 */
@RestController
@RequestMapping("/Sala")
public class SalaController {
    
    ApplicationContext context;
    SalaService ss;

    public SalaController(ApplicationContext context) {
        this.context = context;
        this.ss = new SalaService(context);
    }
    
    
    @GetMapping("/numPeliculasSala")
    public ResponseEntity<List<Object[]>> numPeliculasSala() {
        
        List<Object[]> result= ss.numPeliculasSala();
        if (!result.isEmpty()) {
            return ResponseEntity.ok(result);
        }else{
            return ResponseEntity.notFound().build();
        }
        
        
    }
    
}
