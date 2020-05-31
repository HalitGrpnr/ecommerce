package com.ecommerce.application.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserDto {

    private Long id;
    private String name;
    private String surname;
    private String password;
    private String email;
    private String phone;
    private Date registeredDate;
    private String address;
    private String userRole;
    private Boolean locked = false;
    private Boolean enabled = true;

    private SellerDto sellerDto;
}
