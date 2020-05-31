package com.ecommerce.application.controller;

import com.ecommerce.application.domain.entity.Store;
import com.ecommerce.application.service.interfaces.StoreService;
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
@RequestMapping("/stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping
    public ResponseEntity<List<Store>> getAll(){
        return ResponseEntity.ok(storeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Store> getStore(@PathVariable("id") Long id){
        return ResponseEntity.ok(storeService.get(id));
    }

    @PostMapping
    public ResponseEntity<Store> addStore(@RequestBody Store store){
        return ResponseEntity.ok(storeService.add(store));
    }

    //put

    @DeleteMapping("/{id}")
    public void deleteStore(@PathVariable Long id){
        storeService.delete(id);
    }

}
