/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.cafeconpalito.JDBC.repository;

import com.cafeconpalito.JDBC.entity.Empleado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cafeconpalito
 * 
 */
@Repository
public interface IEmpleado extends CrudRepository<Empleado, Integer> {
        //public Empleado findByName(String nombre);
}
