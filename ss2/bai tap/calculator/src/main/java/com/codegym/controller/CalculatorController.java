package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/calculator")
    public String showCalculator() {
        return "index";
    }

    @PostMapping("/calculator")
    public String showResult(@RequestParam("operation") String operation, Model model, @RequestParam("number1") double number1, @RequestParam("number2") double number2) {
        double result = 0;
        switch (operation) {
            case "Addition":
                result = number1 + number2;
                break;
            case "Subtraction":
                result = number1 - number2;
                break;
            case "Multiplication":
                result = number1 * number2;
                break;
            case "Division":
                try{
                    result = number1/number2;
                }catch (ArithmeticException e) {
                    e.printStackTrace();
                }
                break;
        }
        model.addAttribute("result", result);
        return "index";
    }
}
