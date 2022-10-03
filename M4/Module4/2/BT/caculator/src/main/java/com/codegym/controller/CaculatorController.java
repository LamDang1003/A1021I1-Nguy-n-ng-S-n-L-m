package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CaculatorController {
    @GetMapping("/caculator")
    public String caculator() {
        return "index";
    }
    @PostMapping("/caculator")
    public ModelAndView caculator(@RequestParam String a, String b, String c) {
        double res = 0;
        switch (c) {
            case "+":
                res=Double.parseDouble(a) + Double.parseDouble(b);
                break;
            case "-":
                res=Double.parseDouble(a) - Double.parseDouble(b);
                break;
            case "*":
                res=Double.parseDouble(a) * Double.parseDouble(b);
                break;
            case "/":
                res=Double.parseDouble(a) / Double.parseDouble(b);
                break;
        }
        return new ModelAndView("index", "res", res);
    }
}
