package com.ecommerce.application.controller;

import com.ecommerce.application.domain.entity.Order;
import com.ecommerce.application.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getAll(){
        return ResponseEntity.ok(orderService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable("id") Long id){
        return ResponseEntity.ok(orderService.get(id));
    }

    @PostMapping
    public ResponseEntity<Order> addOrder(@RequestBody Order order){
        return ResponseEntity.ok(orderService.add(order));
    }

    //put

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderService.delete(id);
    }

}
