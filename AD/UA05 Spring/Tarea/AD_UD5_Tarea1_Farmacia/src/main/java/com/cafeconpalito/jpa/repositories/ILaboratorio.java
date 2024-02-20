/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/ReactRepository.java to edit this template
 */
package com.cafeconpalito.jpa.repositories;

import com.cafeconpalito.jpa.entities.Laboratorio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cafeconpalito
 */
@Repository
public interface ILaboratorio extends JpaRepository<Laboratorio, Integer> {
    
    //@Query("Select l from Laboratorio l inner join Medicamento m ON l.pklaboratorio = m.aklaboratorio order by m.pvp asc") // NO FUNCIONA
    @Query("select l from Medicamento m inner join m.aklaboratorio l order by m.pvp asc")
    public List<Laboratorio> laboratoriesWhitStock();
    
}
