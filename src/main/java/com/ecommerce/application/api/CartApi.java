package com.ecommerce.application.api;

import com.ecommerce.application.domain.dto.CartDto;
import com.ecommerce.application.service.interfaces.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/carts")
public class CartApi {

    @Autowired
    private CartService cartService;

    @GetMapping
    public ResponseEntity<List<CartDto>> getAll(){
        return ResponseEntity.ok(cartService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartDto> getCart(@PathVariable("id") Long id){
        return ResponseEntity.ok(cartService.get(id));
    }

    @PostMapping
    public ResponseEntity<CartDto> addCart(@RequestBody CartDto cartDto){
        return ResponseEntity.ok(cartService.add(cartDto));
    }

    //put

    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable Long id){
        cartService.delete(id);
    }

}
