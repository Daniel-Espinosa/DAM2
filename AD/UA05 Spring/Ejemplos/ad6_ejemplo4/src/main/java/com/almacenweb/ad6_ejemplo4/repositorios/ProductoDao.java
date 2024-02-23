/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.almacenweb.ad6_ejemplo4.repositorios;

import com.almacenweb.ad6_ejemplo4.entidades.Categoria;
import com.almacenweb.ad6_ejemplo4.entidades.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author msola
 */
@Repository
public interface ProductoDao extends CrudRepository<Producto, Integer> {

    @Query("select p from Producto p where p.akcategoria=:cat")
    public List<Producto> findByCategoria(@Param("cat") Categoria categoria);
}
