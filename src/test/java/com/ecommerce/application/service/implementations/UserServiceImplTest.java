package com.ecommerce.application.service.implementations;

import com.ecommerce.application.domain.entity.User;
import com.ecommerce.application.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    public void testAdd(){

        User user = new User();
        user.setName("Test-user");
        user.setSurname("Test-surname");
        user.setEmail("Test@email.com");
        user.setPassword("Test-passwd");
        user.setPhone("Test-phone");

        User mockUser = mock(User.class);

        when(mockUser.getId()).thenReturn(1L);
        when(mockUser.getName()).thenReturn("Test-user");
        when(userRepository.save(any(User.class))).thenReturn(mockUser);

        User result = userService.add(user);

        assertEquals(result.getName(), user.getName());
        assertEquals(result.getId(), 1L);

    }

    @Test
    public void testAddException() {

        User user = new User();
        user.setName("Test-user");
        user.setSurname("Test-surname");
        user.setEmail("Test@email.com");

        assertThrows(IllegalArgumentException.class, () -> userService.add(user));

    }

    @Test
    public void testGetAll(){
        User user = new User();
        user.setName("Test-user");
        user.setSurname("Test-surname");
        user.setEmail("Test@email.com");
        user.setPassword("Test-passwd");
        user.setPhone("Test-phone");

        when(userRepository.findAll()).thenReturn(Collections.singletonList(user));
        List<User> userList = userService.getAll();

        assertEquals(userList.size(), 1);
    }

}
