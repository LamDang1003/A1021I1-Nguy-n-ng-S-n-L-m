package com.example.demo.controller;

import com.example.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/products")
    public ModelAndView listProduct() {
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }
}