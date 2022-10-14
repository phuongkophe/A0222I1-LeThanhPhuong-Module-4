package com.codegym.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping("/sandwich")
    public String showCondiment() {
        return "index";
    }

    @PostMapping("/sandwich")
    public String showChoiceList(@RequestParam("condiment") String condiment, Model model) {
        model.addAttribute("listChoice",condiment);
        return "index";
    }
}
