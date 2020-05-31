package com.ecommerce.application.service.implementations;

import com.ecommerce.application.domain.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserServiceImplntegrationTest {

    @Autowired
    UserServiceImpl userService;

    @Test
    public void testAdd(){

        User user = new User();
        user.setName("Test-user");
        user.setSurname("Test-surname");
        user.setEmail("Test@email.com");
        user.setPassword("Test-passwd");
        user.setPhone("Test-phone");

        User result = userService.add(user);
        assertTrue(result.getId() > 0L);

    }

}
