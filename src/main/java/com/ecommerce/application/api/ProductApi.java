package com.ecommerce.application.api;

import com.ecommerce.application.domain.entity.Product;
import com.ecommerce.application.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/api/products")
public class ProductApi {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id){
        return ResponseEntity.ok(productService.get(id));
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@ModelAttribute Product product){
        return ResponseEntity.ok(productService.add(product));
    }

    @GetMapping("/add")
    public ModelAndView register() {
        return new ModelAndView("addProduct", "product", new Product());
    }


    //put

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.delete(id);
    }
}
