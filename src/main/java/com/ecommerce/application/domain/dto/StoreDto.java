package com.ecommerce.application.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class StoreDto {

    private Long id;
    private String name;
    private Date createDate;
    private double averageRate;
}
