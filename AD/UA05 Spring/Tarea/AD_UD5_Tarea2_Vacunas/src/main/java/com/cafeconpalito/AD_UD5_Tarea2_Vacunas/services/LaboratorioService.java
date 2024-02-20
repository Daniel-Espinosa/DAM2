/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.cafeconpalito.AD_UD5_Tarea2_Vacunas.services;

import com.cafeconpalito.AD_UD5_Tarea2_Vacunas.entities.Laboratorio;
import com.cafeconpalito.AD_UD5_Tarea2_Vacunas.entities.Vacuna;
import com.cafeconpalito.AD_UD5_Tarea2_Vacunas.repositories.LaboratorioRepository;
import java.util.LinkedList;
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

    LaboratorioRepository lr;

    public LaboratorioService(ApplicationContext context) {
        this.context = context;
        this.lr = context.getBean(LaboratorioRepository.class);
    }

    /**
     * Devuelve la lista de los laboratorios
     *
     * @return
     */
    public List<Laboratorio> findAll() {

        //Esto es el metodo largo, se puede comentar todo menos el return.
//        List<Laboratorio> lista = lr.findAll();
//        
//        for (Laboratorio l : lista) {
//            System.out.println(l.getNombre());
//        }
        return lr.findAll();
    }

    /**
     * Obtener los datos de un laboratorio buscado por su nombre.
     *
     * @param name nombre del Laboratorio
     * @return
     */
    public Laboratorio findByName(String name) {

        for (Laboratorio l : lr.findAll()) {
            if (l.getNombre().equalsIgnoreCase(name)) {
                return l;
            }
        }

        return null;
    }

    /**
     * Inversión realizada por laboratorio
     *
     * @return
     */
    public List<Object[]> inversionPorLaboratorio() {

        List<Object[]> lista = new LinkedList<>();

        for (Laboratorio l : lr.findAll()) {

            double invAux = 0;
            for (Vacuna v : l.getVacunaList()) {
                invAux += v.getStock() * l.getPvpdosis();
            }
            
            lista.add(new Object[]{l, invAux});
        }

        return lista;
    }

}
