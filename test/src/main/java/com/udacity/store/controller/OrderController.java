package com.udacity.store.controller;

import java.net.URI;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.udacity.store.model.Order;
import com.udacity.store.model.Product;
import com.udacity.store.repository.OrderRepository;

@RestController
@RequestMapping("orders/")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/orders")
    @Transactional
    public ResponseEntity<?> products(){
        return ResponseEntity.ok().body(orderRepository.findAll());
    }

    @GetMapping("/order/{id}")
    @Transactional
    public ResponseEntity<?> productId(@RequestParam Long id){
       return ResponseEntity.ok().body(orderRepository.findById(id));
    }

    @PostMapping("/order")
    @Transactional
    public ResponseEntity<?> saveOrder(@RequestBody Product product, UriComponentsBuilder builder){
        Order order = new Order();
        order.setProduct(product);

        orderRepository.save(order);
        URI uri = builder.path("/api/order/{id}").buildAndExpand(order.getId()).toUri();
        return ResponseEntity.created(uri).body(order);
    }
}
