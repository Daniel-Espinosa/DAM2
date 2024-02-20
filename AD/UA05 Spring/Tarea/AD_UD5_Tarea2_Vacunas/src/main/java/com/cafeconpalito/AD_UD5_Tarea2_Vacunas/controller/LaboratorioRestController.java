/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.cafeconpalito.AD_UD5_Tarea2_Vacunas.controller;

import com.cafeconpalito.AD_UD5_Tarea2_Vacunas.entities.Laboratorio;
import com.cafeconpalito.AD_UD5_Tarea2_Vacunas.services.LaboratorioService;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author cafeconpalito
 */
@RestController
@RequestMapping("/laboratorio")
public class LaboratorioRestController {
    
    ApplicationContext context;
    LaboratorioService ls;
    
    public LaboratorioRestController(ApplicationContext context) {
        this.context = context;
        this.ls = new LaboratorioService(context);
    }
    
    
    @GetMapping("/findbyname/{name}")
    public ResponseEntity<Laboratorio> getLaboratorioByName(@PathVariable String name) {
        
        Laboratorio result= ls.findByName(name);
        if (result != null) {
            return ResponseEntity.ok(result);
        }else{
            return ResponseEntity.notFound().build();
        }
        
        
    }
    
    @GetMapping("/listaLabs")
    public  ResponseEntity<List<Laboratorio>>  getAllLab(){
        
        List<Laboratorio> result= ls.findAll();
        if (!result.isEmpty()) {
            return ResponseEntity.ok(result);
        }else{
            return ResponseEntity.notFound().build();
        }
        
    }
    
    @GetMapping("/inverion")
    public ResponseEntity<List<Object[]>> getInversion(){
        
        List<Object[]> result= ls.inversionPorLaboratorio();
        
        if (!result.isEmpty()) {
            return ResponseEntity.ok(result);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError() {
    }
    
    
    
}
