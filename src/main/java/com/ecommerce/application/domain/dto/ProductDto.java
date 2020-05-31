package com.ecommerce.application.domain.dto;

import java.util.Date;
import java.util.List;

public class ProductDto {

    private Long id;
    private String name;
    private String information;
    private double price;
    private Date createdDate;
    private Date LastModifiedDate;
    private int leadTime;
    private double averageRate;

    private StoreDto storeDto;
    private List<CommentDto> comments;
    private List<RatingDto> ratings;
    private List<CategoryDto> categories;
    private List<CartDto> carts;
}
