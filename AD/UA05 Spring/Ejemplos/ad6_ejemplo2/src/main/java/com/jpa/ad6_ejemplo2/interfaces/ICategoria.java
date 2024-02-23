/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jpa.ad6_ejemplo2.interfaces;

import com.jpa.ad6_ejemplo2.entidades.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author marina
 */
@Repository
public interface ICategoria extends CrudRepository<Categoria, Integer>{
    
    //encuentra una categoria por su nombre
    public Categoria findByNombre(String nombre);
   
  
}
