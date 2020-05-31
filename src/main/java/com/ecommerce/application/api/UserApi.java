package com.ecommerce.application.api;

import com.ecommerce.application.domain.entity.User;
import com.ecommerce.application.domain.validator.RegisterValidator;
import com.ecommerce.application.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/users")
public class UserApi {

    @Autowired
    private UserService userService;

    @Autowired
    private RegisterValidator registerValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.addValidators(registerValidator);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id){
        return ResponseEntity.ok(userService.get(id));
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        return ResponseEntity.ok(userService.add(user));
    }

    //put

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.delete(id);
    }



}
