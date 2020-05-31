package com.ecommerce.application.domain;

import com.ecommerce.application.domain.entity.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetailsImpl {


    private Long id;
    private String username;
    private String password;
    private String email;

}
