/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.web.ad6_ejemplo3.repositorios;

import com.web.ad6_ejemplo3.entidades.Categoria;
import com.web.ad6_ejemplo3.entidades.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author marina
 */
@Repository
public interface ProductoDao extends CrudRepository <Producto, Integer>{
       
    @Query("select p from Producto p where p.akcategoria=:cat")
    public List<Producto> findByCategoria (@Param("cat") Categoria categoria);   
        
}

