/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.cafeconpalito.cine_Examen.services;

import com.cafeconpalito.cine_Examen.entities.Entrada;
import com.cafeconpalito.cine_Examen.entities.Proyeccion;
import com.cafeconpalito.cine_Examen.entities.Socio;
import com.cafeconpalito.cine_Examen.repositories.EntradaRepository;
import com.cafeconpalito.cine_Examen.repositories.ProyeccionRepository;
import com.cafeconpalito.cine_Examen.repositories.SalaRepository;
import com.cafeconpalito.cine_Examen.repositories.SocioRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 *
 * @author damt207
 */
@Service
public class EntradaService {
    
    ApplicationContext context;
    EntradaRepository er;
    ProyeccionRepository pr;
    SocioRepository sr;
    SalaRepository ss;

    public EntradaService(ApplicationContext context) {
        this.context = context;
        this.er = context.getBean(EntradaRepository.class);
        this.pr = context.getBean(ProyeccionRepository.class);
        this.sr = context.getBean(SocioRepository.class);
    }
    
    /**
     * En caso de error por Socio, Proyeccion o numero de entradas Retorna Null!
     * @param socio
     * @param proyeccion
     * @param numeroEntradas
     * @return 
     */
    public Entrada nuevaEntrada(int socio, int proyeccion, int numeroEntradas){
        
        Proyeccion p = pr.findById(proyeccion).orElse(null);
        Socio s = sr.findById(socio).orElse(null);
        
        if (p == null) { // si la proyeccion no existe retorna null;
            return null;
        }
        
        if(s == null){ //Si el socio no existe retorna null;
            return null;
        }
        
        //Recorro la lista de entradas vendidas para esa pelicula si el socio ya tiene entrada retorna null;
        for (Entrada entrada : p.getEntradaList()) {
            if (entrada.getFksocio().equals(s)) {
                return null;
            }
        }
        
        
        //COMPRUEBO EL AFORO
        
        //Capturo el aforo de la sala
        int aforo = p.getFksala().getAforo();
        //Capturo el numero de entradas vendidas;
        int entradasVendidas = p.getNumentradas();
        //Sumo las entradas vendidas a las que quiere comprar para comparar con el tamaño del aforo
        int comprobarEntradas = entradasVendidas + numeroEntradas;
        
        //SI supera el aforo retorna Null
        if (comprobarEntradas>aforo) {
            return null;
        }
        
        Entrada e = new Entrada();
        e.setFkproyeccion(p);
        e.setFksocio(s);
        
        return er.save(e);
        
    }
    
    
}
