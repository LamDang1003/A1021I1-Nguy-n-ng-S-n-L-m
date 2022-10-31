package com.codegym.controller;


import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public String home(Model model, @RequestParam(required = false) String q) {
        List<Product> products = q != null ? productService.search(q) : productService.findAll();
        model.addAttribute("products", products);

        return "home";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "form";
    }

    @GetMapping("edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id) {
        Optional<Product> opProduct = productService.getById(id);
        if (opProduct.isPresent()) {
            model.addAttribute("product", opProduct.get());
        }

        return "form";
    }

    @PostMapping("save")
    public String save(Product product) {
        productService.save(product);
        return "redirect:/product";
    }

    @PostMapping("delete")
    public String delete(@RequestParam int id) {
        productService.delete(id);

        return "redirect:/product";
    }
}