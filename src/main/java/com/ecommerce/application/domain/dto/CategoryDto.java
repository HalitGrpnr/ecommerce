package com.ecommerce.application.domain.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    private Long id;
    private Long parentId;
    private String name;
    private Date createdDate;
    private List<ProductDto> products;
}
