package com.ecommerce.application.api;

import com.ecommerce.application.domain.entity.Order;
import com.ecommerce.application.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/orders")
public class OrderApi {

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
