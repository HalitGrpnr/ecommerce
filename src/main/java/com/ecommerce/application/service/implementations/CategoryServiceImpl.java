package com.ecommerce.application.service.implementations;

import com.ecommerce.application.domain.dto.CategoryDto;
import com.ecommerce.application.domain.entity.Category;
import com.ecommerce.application.repository.CategoryRepository;
import com.ecommerce.application.service.interfaces.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto get(Long id) {
        Category category = categoryRepository.findById(id).orElse(new Category());
        CategoryDto categoryDto = modelMapper.map(category, CategoryDto.class);
        return categoryDto;
    }

    @Override
    public CategoryDto add(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);
        category = categoryRepository.save(category);

        return modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto) {
        return null;
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<CategoryDto> getAll() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> categoryDtos = categories.stream().
                map(c -> modelMapper.map(c, CategoryDto.class)).collect(Collectors.toList());
        return categoryDtos;
    }
}
