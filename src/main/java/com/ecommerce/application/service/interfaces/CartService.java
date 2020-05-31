package com.ecommerce.application.service.interfaces;

import com.ecommerce.application.domain.dto.CartDto;

import java.util.List;

public interface CartService {

    CartDto get(Long id);
    CartDto add(CartDto cart);
    CartDto update(CartDto cart);
    void delete(Long id);
    List<CartDto> getAll();



}
