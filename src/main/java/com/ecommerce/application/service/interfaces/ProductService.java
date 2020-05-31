package com.ecommerce.application.service.interfaces;

import com.ecommerce.application.domain.entity.Product;

import java.util.List;

public interface ProductService {
    Product get(Long id);
    Product add(Product Product);
    Product update(Product Product);
    void delete(Long id);
    List<Product> getAll();
}
