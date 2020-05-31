package com.ecommerce.application.service.interfaces;

import com.ecommerce.application.domain.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto get(Long id);
    CategoryDto add(CategoryDto categoryDto);
    CategoryDto update(CategoryDto categoryDto);
    void delete(Long id);
    List<CategoryDto> getAll();
}
