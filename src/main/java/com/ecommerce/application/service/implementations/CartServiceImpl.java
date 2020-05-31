package com.ecommerce.application.service.implementations;

import com.ecommerce.application.domain.dto.CartDto;
import com.ecommerce.application.domain.entity.Cart;
import com.ecommerce.application.repository.CartRepository;
import com.ecommerce.application.service.interfaces.CartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CartDto get(Long id) {
        Cart cart = cartRepository.findById(id).orElse(new Cart());
        CartDto cartDto = modelMapper.map(cart, CartDto.class);
        return cartDto;
    }

    @Override
    public CartDto add(CartDto cartDto) {
        Cart cart = modelMapper.map(cartDto, Cart.class);
        cart = cartRepository.save(cart);

        return modelMapper.map(cart, CartDto.class);
    }

    @Override
    public CartDto update(CartDto cartDto) {
        //return cartRepository.save(cart);
        return null;
    }

    @Override
    public void delete(Long id) {
        cartRepository.deleteById(id);
    }

    @Override
    public List<CartDto> getAll() {
        List<Cart> carts = cartRepository.findAll();

        List<CartDto> cartDtos = carts.stream().map(c -> modelMapper.map(c, CartDto.class)).collect(Collectors.toList());

        return cartDtos;
    }
}
