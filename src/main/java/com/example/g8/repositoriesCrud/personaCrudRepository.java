/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.g8.repositoriesCrud;

import com.example.g8.entities.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author bmao9
 */
public interface personaCrudRepository extends MongoRepository<Persona, Integer>{
    
}
