package com.ecommerce.application.controller;

import com.ecommerce.application.domain.entity.Cart;
import com.ecommerce.application.service.interfaces.CartService;
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
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public ResponseEntity<List<Cart>> getAll(){
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCart(@PathVariable("id") Long id){
        return null;
    }

    @PostMapping
    public ResponseEntity<Cart> addCart(@RequestBody Cart cart){
        return null;
    }

    //put

    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable Long id){
        cartService.delete(id);
    }

}
