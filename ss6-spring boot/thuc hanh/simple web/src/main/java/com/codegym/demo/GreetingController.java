package com.codegym.demo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetingController {
    @GetMapping("/greeting")
    public ModelAndView greeting(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("greeting");
        return modelAndView;
    }
}
