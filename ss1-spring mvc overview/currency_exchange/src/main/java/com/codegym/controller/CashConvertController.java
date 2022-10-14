package com.codegym.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CashConvertController {
    @GetMapping("/form")
    public String redirectIndexPage() {
        return "convert";
    }

//    @PostMapping("/convert")
//    public ModelAndView Result (@RequestParam String usd, String exchangeRate){
//        ModelAndView modelAndView = new ModelAndView("convert");
//        double dollar = Double.parseDouble(usd);
//        double rate = Double.parseDouble(exchangeRate);
//        double vnd = dollar*rate;
//        modelAndView.addObject("vnd", vnd);
//        return modelAndView;
//    }
@PostMapping("/convert")
public String Result (@RequestParam String usd, String exchangeRate, Model model){
    double dollar = Double.parseDouble(usd);
    double rate = Double.parseDouble(exchangeRate);
    double vnd = dollar*rate;
    model.addAttribute("vnd",vnd);
    model.addAttribute("usd",usd);

    return "convert";
}
}
