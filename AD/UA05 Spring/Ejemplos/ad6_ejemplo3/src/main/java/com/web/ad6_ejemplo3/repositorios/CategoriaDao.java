/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.web.ad6_ejemplo3.repositorios;

import com.web.ad6_ejemplo3.entidades.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author marina
 */
@Repository
public interface CategoriaDao extends CrudRepository <Categoria, Integer> {
    public Categoria findByNombre(String nombre);
}
