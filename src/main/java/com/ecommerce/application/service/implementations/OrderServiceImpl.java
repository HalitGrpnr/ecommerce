package com.ecommerce.application.service.implementations;

import com.ecommerce.application.domain.entity.Order;
import com.ecommerce.application.repository.OrderRepository;
import com.ecommerce.application.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order get(Long id) {
        return orderRepository.findById(id).orElse(new Order());
    }

    @Override
    public Order add(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order update(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}
