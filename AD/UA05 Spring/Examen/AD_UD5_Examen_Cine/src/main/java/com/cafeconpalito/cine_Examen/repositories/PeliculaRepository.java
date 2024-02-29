/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.cafeconpalito.cine_Examen.repositories;

import com.cafeconpalito.cine_Examen.entities.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author damt207
 */
public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {
    
}
