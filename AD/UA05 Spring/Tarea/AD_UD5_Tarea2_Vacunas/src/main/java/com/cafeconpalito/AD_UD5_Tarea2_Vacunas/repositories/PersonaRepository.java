/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.cafeconpalito.AD_UD5_Tarea2_Vacunas.repositories;

import com.cafeconpalito.AD_UD5_Tarea2_Vacunas.entities.Laboratorio;
import com.cafeconpalito.AD_UD5_Tarea2_Vacunas.entities.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cafeconpalito
 */
@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    
    @Query("SELECT p FROM Persona p WHERE p.ndosis = :ndosis")
    public List<Persona> findByNdosis(int ndosis);
    
    @Query("SELECT p FROM Vacunapersona vp inner join vp.akpersona p inner join vp.akvacuna v WHERE v.aklaboratorio = :laboratorio")
    public List<Persona> findByVacunaLaboratorio(Laboratorio laboratorio);
    
    @Query("SELECT p FROM Vacunapersona vp inner join vp.akpersona p inner join vp.akvacuna v inner join v.aklaboratorio l where l.nombre = :name")
    public List<Persona> findByVacunaLabName(String name);
    
    
    
    
}
