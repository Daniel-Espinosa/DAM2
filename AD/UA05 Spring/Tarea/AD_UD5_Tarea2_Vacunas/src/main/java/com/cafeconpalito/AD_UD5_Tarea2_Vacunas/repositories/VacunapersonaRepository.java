/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.cafeconpalito.AD_UD5_Tarea2_Vacunas.repositories;

import com.cafeconpalito.AD_UD5_Tarea2_Vacunas.entities.Vacunapersona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cafeconpalito
 */
@Repository
public interface VacunapersonaRepository extends JpaRepository<Vacunapersona, Integer> {
    
}
