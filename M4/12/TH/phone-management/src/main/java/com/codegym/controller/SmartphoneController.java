package com.codegym.controller;

import com.codegym.model.SmartPhone;
import com.codegym.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/smartphones")
public class SmartphoneController {
    @Autowired
    private ISmartPhoneService smartPhoneService;

    @PostMapping
    public ResponseEntity<SmartPhone> createSmartPhone(@RequestBody SmartPhone smartPhone) {
        return new ResponseEntity<>(smartPhoneService.save(smartPhone), HttpStatus.CREATED);

    }

    @GetMapping("/list")
    public ModelAndView getAllSmartPhonePage() {
        ModelAndView modelAndView = new ModelAndView("/phone/list");
        modelAndView.addObject("smartphones", smartPhoneService.findAll());
        return modelAndView;
    }


}
