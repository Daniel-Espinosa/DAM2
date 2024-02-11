/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/ReactRepository.java to edit this template
 */
package com.cafeconpalito.jpa.repositories;

import com.cafeconpalito.jpa.entities.Tratamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author produccion
 */
@Repository
public interface ITratamiento extends JpaRepository<Tratamiento, Integer> {
    
}
