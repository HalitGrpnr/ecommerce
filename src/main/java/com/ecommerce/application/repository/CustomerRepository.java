package com.ecommerce.application.repository;

import com.ecommerce.application.domain.entity.Customer;
import com.ecommerce.application.domain.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
