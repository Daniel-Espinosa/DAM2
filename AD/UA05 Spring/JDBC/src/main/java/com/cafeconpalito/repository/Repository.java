/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.cafeconpalito.repository;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author damt207
 */
public interface Repository extends CrudRepository<Entity, Id> {
    
}
