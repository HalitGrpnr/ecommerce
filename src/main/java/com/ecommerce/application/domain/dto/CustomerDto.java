package com.ecommerce.application.domain.dto;

import com.ecommerce.application.domain.entity.User;

import java.util.List;

public class CustomerDto {
    private Long id;
    private User user;
    private CartDto cartDto;
    private List<CommentDto> comments;
    private List<RatingDto> ratings;
    private List<OrderDto> orders;
}
