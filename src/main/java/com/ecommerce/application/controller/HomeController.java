package com.ecommerce.application.controller;

import com.ecommerce.application.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = {"/"})
    public ModelAndView getHomePage(){

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("home");

        modelAndView.addObject("products", productService.getAll());

        return modelAndView;
    }

    @GetMapping(value = {"/home2"})
    public ModelAndView getHomePage2(){

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("home2");

        modelAndView.addObject("products", productService.getAll());

        return modelAndView;
    }

}
