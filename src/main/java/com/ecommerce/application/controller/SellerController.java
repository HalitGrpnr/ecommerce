package com.ecommerce.application.controller;

import com.ecommerce.application.domain.entity.Seller;
import com.ecommerce.application.service.interfaces.SellerService;
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
@RequestMapping("/sellers")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @GetMapping
    public ResponseEntity<List<Seller>> getAll(){
        return ResponseEntity.ok(sellerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seller> getSeller(@PathVariable("id") Long id){
        return ResponseEntity.ok(sellerService.get(id));
    }

    @PostMapping
    public ResponseEntity<Seller> addSeller(@RequestBody Seller seller){
        return ResponseEntity.ok(sellerService.add(seller));
    }

    //put

    @DeleteMapping("/{id}")
    public void deleteSeller(@PathVariable Long id){
        sellerService.delete(id);
    }

}
