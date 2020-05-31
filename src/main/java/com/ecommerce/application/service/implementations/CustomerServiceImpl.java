package com.ecommerce.application.service.implementations;

import com.ecommerce.application.domain.entity.Customer;
import com.ecommerce.application.repository.CustomerRepository;
import com.ecommerce.application.service.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer get(Long id) {
        return customerRepository.findById(id).orElse(new Customer());
    }

    @Override
    public Customer add(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();

    }
}
