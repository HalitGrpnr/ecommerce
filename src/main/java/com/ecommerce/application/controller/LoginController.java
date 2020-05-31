package com.ecommerce.application.controller;

import com.ecommerce.application.domain.dto.UserDto;
import com.ecommerce.application.domain.entity.*;
import com.ecommerce.application.service.ConfirmationTokenService;
import com.ecommerce.application.service.interfaces.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    UserService userService;
    @Autowired
    private ConfirmationTokenService confirmationTokenService;

    @PreAuthorize("isAnonymous()")
    @GetMapping("/login")
    public ModelAndView getLoginPage(@RequestParam Optional<String> error,
                                     @RequestParam Optional<String> logout){
        ModelAndView model = new ModelAndView();

        if(error.isPresent()) {
            model.addObject("error", "Invalid UserCredential");
        }

        if(logout.isPresent()) {
            model.addObject("logout", "Logout successfully");
        }

        model.setViewName("login");
        return model;
    }

    @PreAuthorize("isAnonymous()")
    @GetMapping("/seller/login")
    public ModelAndView getSellerLoginPage(@RequestParam Optional<String> error,
                                     @RequestParam Optional<String> logout){
        ModelAndView model = new ModelAndView();

        if(error.isPresent()) {
            model.addObject("error", "Invalid UserCredential");
        }

        if(logout.isPresent()) {
            model.addObject("logout", "Logout successfully");
        }

        model.setViewName("login");
        return model;
    }

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("register", "userDto", new UserDto());
    }

    @GetMapping("/seller/register")
    public ModelAndView sellerRegister() {
        return new ModelAndView("addSeller", "userDto", new UserDto());
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute UserDto userDto, BindingResult bindingResult, HttpServletRequest httpServletRequest) {

        if (bindingResult.hasErrors()) {
            return "register";
        }

        userDto.setUserRole(UserRole.USER.toString());
        userService.signUpUser(convertCustomerDtoToUserEntity(userDto));

        try {
            httpServletRequest.login(userDto.getEmail(), userDto.getPassword());
        } catch (ServletException e) {
            e.printStackTrace();
        }

        return "redirect:/";
    }

    @PostMapping("/seller/register")
    public String registerSeller(@Valid @ModelAttribute UserDto userDto, BindingResult bindingResult, HttpServletRequest httpServletRequest) {

        if (bindingResult.hasErrors()) {
            return "register";
        }

        userDto.setUserRole(UserRole.SELLER.toString());
        userService.signUpUser(convertSellerDtoToUserEntity(userDto));

        try {
            httpServletRequest.login(userDto.getEmail(), userDto.getPassword());
        } catch (ServletException e) {
            e.printStackTrace();
        }


        return "redirect:/";
    }

    private User convertSellerDtoToUserEntity(UserDto userDto) {

        User user = new User();
        Seller seller = new Seller();
        Store store = new Store();

        BeanUtils.copyProperties(userDto.getSellerDto().getStoreDto(), store);
        BeanUtils.copyProperties(userDto.getSellerDto(), seller);
        BeanUtils.copyProperties(userDto, user);

        seller.setStore(store);
        user.setSeller(seller);

        return user;
    }

    private User convertCustomerDtoToUserEntity(UserDto userDto) {

        User user = new User();
        Customer customer = new Customer();

        BeanUtils.copyProperties(userDto, user);

        user.setCustomer(customer);

        return user;
    }


    @PostMapping("/seller/register124")
    public String registerSeller(@Valid @ModelAttribute User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "addSeller";
        }

        user.setUserRole(UserRole.SELLER.toString());
        userService.signUpUser(user);

        return "redirect:/login";
    }

    @GetMapping("/confirm")
    public String confirmMail(@RequestParam("token") String token) {

        Optional<ConfirmationToken> optionalConfirmationToken = confirmationTokenService.findConfirmationTokenByToken(token);

        optionalConfirmationToken.ifPresent(userService::confirmUser);

        return "/sign-in";
    }

}
