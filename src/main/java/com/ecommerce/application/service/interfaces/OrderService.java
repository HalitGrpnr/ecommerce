package com.ecommerce.application.service.interfaces;

import com.ecommerce.application.domain.entity.Order;

import java.util.List;

public interface OrderService {
    Order get(Long id);
    Order add(Order Order);
    Order update(Order Order);
    void delete(Long id);
    List<Order> getAll();
}
