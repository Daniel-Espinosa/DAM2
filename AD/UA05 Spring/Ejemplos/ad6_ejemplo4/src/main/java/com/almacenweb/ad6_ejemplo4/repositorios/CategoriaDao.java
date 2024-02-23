/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.almacenweb.ad6_ejemplo4.repositorios;

import com.almacenweb.ad6_ejemplo4.entidades.Categoria;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author msola
 */
@Repository
public interface CategoriaDao extends CrudRepository<Categoria, Integer>{
    public Categoria findByNombre(String nombre);
    
    @Query("select max(c.pkcategoria) from Categoria c")
    public Integer maximaPkCategoria();
    
}
