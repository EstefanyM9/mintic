/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.g8.controller;

import com.example.g8.entities.Order;
import com.example.g8.services.OrderService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/order")
@CrossOrigin(origins = "*")
public class OrderController {
    
    @Autowired
    private OrderService service;
    
    @GetMapping("/all")
    public List<Order> getAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Order> getZone(@PathVariable("id")Integer id){
        return service.getId(id);
    }
    @GetMapping("/zona/{zone}")
    public List<Order> getZone(@PathVariable("zone") String zona){
        return service.getZone(zona);
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order OrderNew(@RequestBody Order OrderNew){
        return service.createOrder(OrderNew);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order editOrder(@RequestBody Order order){
        return service.update(order);
    }
    
    
}
