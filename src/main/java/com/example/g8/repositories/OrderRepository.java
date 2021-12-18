/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.g8.repositories;

import com.example.g8.entities.Order;
import com.example.g8.repositoriesCrud.OrderCrudRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 *
 * @author Esteffany Meneses
 */

@Repository
public class OrderRepository {
    
    @Autowired
    private OrderCrudRepository repository;
    
    public List<Order> getAll(){
        return(List<Order>)repository.findAll();
    }
    public List<Order> getZone(String zone){
        return repository.findByZone(zone);
    }
    
    public Optional<Order> getById(Integer id){
        return repository.findById(id);
    }
    
    public Order createOrder(Order order){
        return repository.save(order);
    }
    
     public List<Order> getBySalesManId(Integer id){
        return repository.findBySalesManId(id);
    }

    public List<Order> getBySalesManIdAndStatus(Integer id, String status){
        return repository.findBySalesManIdAndStatus(id, status);
    }

    public List<Order> getByRegisterDayAndSalesManId(String registerDay, Integer id){
        try {
            return repository.findByRegisterDayAndSalesManId(new SimpleDateFormat("yyyy-MM-dd").parse(registerDay), id);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}

