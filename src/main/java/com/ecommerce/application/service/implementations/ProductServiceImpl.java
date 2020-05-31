package com.ecommerce.application.service.implementations;

import com.ecommerce.application.domain.entity.Product;
import com.ecommerce.application.domain.entity.Store;
import com.ecommerce.application.repository.ProductRepository;
import com.ecommerce.application.service.interfaces.ProductService;
import com.ecommerce.application.service.interfaces.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StoreService storeService;

    @Override
    public Product get(Long id) {
        return productRepository.findById(id).orElse(new Product());
    }

    @Override
    public Product add(Product product) {
        product.setStore(storeService.get(1L));
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
