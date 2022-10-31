package com.example.form.controller;

import com.example.form.model.User;
import com.example.form.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller

public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/create")
    public ModelAndView formCreate() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//        new User().validate(user, bindingResult);
        userService.save(user);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("user", new User());
        modelAndView.addObject("message", "New User created successfully");
        return modelAndView;
    }

    @GetMapping("/users")
    public ModelAndView listUser() {
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("users", userService.findAll());
        return modelAndView;
    }

    @GetMapping("/edit{id}")
    public ModelAndView formEdit(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);
        if(user.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/edit");
            modelAndView.addObject("user", user.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error");
        }
    }

    @PostMapping("/edit{id}")
    public ModelAndView updateUser(@ModelAttribute("user") User user) {
        userService.save(user);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("user", user);
        modelAndView.addObject("user", "User updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete{id}")
    public ModelAndView deleteForm(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);
        if(user.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("delete");
            modelAndView.addObject("user", user.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error");
        }
    }

    @PostMapping("/delete{id}")
    public String deleteUser(@ModelAttribute("user") User user) {
        userService.remove(user.getId());
        return "redirect:users";
    }
}
