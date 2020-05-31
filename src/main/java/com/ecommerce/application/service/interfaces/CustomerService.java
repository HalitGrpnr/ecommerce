package com.ecommerce.application.service.interfaces;

import com.ecommerce.application.domain.entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer get(Long id);
    Customer add(Customer customer);
    Customer update(Customer customer);
    void delete(Long id);
    List<Customer> getAll();



}
