package com.ecommerce.application.api;

import com.ecommerce.application.domain.entity.Seller;
import com.ecommerce.application.service.interfaces.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/sellers")
public class SellerApi {

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
