package com.ecommerce.application.api;

import com.ecommerce.application.domain.dto.CategoryDto;
import com.ecommerce.application.service.interfaces.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/api/categories")
public class CategoryApi {


    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDto> add(@RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok(categoryService.add(categoryDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> get(@PathVariable("id") Long id){
        log.debug("category is getting by id");
        return ResponseEntity.ok(categoryService.get(id));
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAll(){
        return ResponseEntity.ok(categoryService.getAll());
    }

}
