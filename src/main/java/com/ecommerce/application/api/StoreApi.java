package com.ecommerce.application.api;

import com.ecommerce.application.domain.entity.Store;
import com.ecommerce.application.service.interfaces.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/stores")
public class StoreApi {

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
