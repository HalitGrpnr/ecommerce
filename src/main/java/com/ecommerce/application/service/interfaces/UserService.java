package com.ecommerce.application.service.interfaces;

import com.ecommerce.application.domain.entity.ConfirmationToken;
import com.ecommerce.application.domain.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {

    User get(Long id);
    User add(User User);
    User update(User User);
    void delete(Long id);
    List<User> getAll();

    void signUpUser(User user);
    void sendConfirmationMail(String email, String token);
    void confirmUser(ConfirmationToken confirmationToken);

}
