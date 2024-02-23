/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jpa.ad6_ejemplo2.interfaces;

import com.jpa.ad6_ejemplo2.entidades.Categoria;
import com.jpa.ad6_ejemplo2.entidades.Producto;
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
public interface IProducto extends CrudRepository<Producto, Integer>{   
       
    @Query("select p from Producto p where p.akcategoria=:cat")
    public List<Producto> findByCategoria (@Param("cat") Categoria categoria);
    
    @Query("select p from Producto p where p.stock<=:cantidad")
    public List<Producto> stockMenorQue (@Param("cantidad") Integer stock);
    
    
}
