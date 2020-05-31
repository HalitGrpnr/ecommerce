package com.ecommerce.application.api;

import com.ecommerce.application.domain.dto.CategoryDto;
import com.ecommerce.application.service.interfaces.CategoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryApiTest {

    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private CategoryApi categoryApi;

    @Test
    void add() {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName("food");

        CategoryDto categoryMock = mock(CategoryDto.class);

        when(categoryMock.getId()).thenReturn(1L);
        when(categoryService.add(any(CategoryDto.class))).thenReturn(categoryMock);

        ResponseEntity<CategoryDto> response = categoryApi.add(categoryDto);

        assertEquals(HttpServletResponse.SC_OK, response.getStatusCodeValue());
        assertEquals(categoryDto.getName(), response.getBody().getName());
    }

    @Test
    void get() {
    }

    @Test
    void getAll() {
    }
}