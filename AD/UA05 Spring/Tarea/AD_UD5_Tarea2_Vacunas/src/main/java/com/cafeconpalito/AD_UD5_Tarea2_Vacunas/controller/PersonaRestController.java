/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.cafeconpalito.AD_UD5_Tarea2_Vacunas.controller;

import com.cafeconpalito.AD_UD5_Tarea2_Vacunas.entities.Laboratorio;
import com.cafeconpalito.AD_UD5_Tarea2_Vacunas.entities.Persona;
import com.cafeconpalito.AD_UD5_Tarea2_Vacunas.services.PersonaService;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author cafeconpalito
 */
@RestController
@RequestMapping("/persona")
public class PersonaRestController {

    PersonaService ps;

    public PersonaRestController(ApplicationContext context) {
        ps = new PersonaService(context);
    }

    @GetMapping("/findByNdosis/{ndosis}")
    public ResponseEntity<List<Persona>> findByNdosis(int ndosis) {
        
        List<Persona> result = ps.personasConNdosis(ndosis);
        
        if (result != null) {
            return ResponseEntity.ok(result);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    
    /**
     * Este metodo de end point no tiene mucho sentido es mucho mas eficas utilizar como parametro el nombre del laboratorios
     * @param laboratorio
     * @return 
     */
    @PostMapping("/findByVacLaboratorio")
    public ResponseEntity<List<Persona>> findByVacunaLaboratorio(@RequestBody Laboratorio laboratorio) {
        
        List<Persona> result = ps.findByVacunaLaboratorio(laboratorio);
        
        if (result != null) {
            return ResponseEntity.ok(result);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    
    /**
     * Metodo Arreglado
     * @param name
     * @return 
     */
    @GetMapping("/findByVacLabName/{name}")
    public ResponseEntity<List<Persona>> findByVacunaLabName(String name) {
        
        List<Persona> result = ps.findByVacunaLabName(name);
        
        if (result != null) {
            return ResponseEntity.ok(result);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("/addPersona")
    public ResponseEntity<Persona> addPersona(@RequestBody Persona persona){
        
        return ResponseEntity.ok(ps.addPersona(persona));
        
    }
    
    

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError() {
    }

}
