package com.codegym.controller;


import com.codegym.model.EmailBox;
import com.codegym.service.EmailService;
import com.codegym.service.EmailServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmailController {
    private  EmailService emailService = new EmailServiceImpl();

//    @GetMapping("/form")
//    public ModelAndView getForm(){
//        EmailBox emailBox = new EmailBox();
//        ModelAndView modelAndView = new ModelAndView("form");
//        modelAndView.addObject(emailBox);
//        return modelAndView;
//    }

    @GetMapping("/form")
    public String getForm(Model model){
        model.addAttribute("emailBox", new EmailBox());
        return "form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("emailBox") EmailBox emailBox, RedirectAttributes redirectAtt) {
        emailService.save(emailBox);
        redirectAtt.addAttribute("language",emailBox.getLanguage());
        return "redirect:/getEmailConfig/{language}";
    }

//    @PostMapping("/save")
//    public String save(@ModelAttribute("emailBox") EmailBox emailBox,Model model) {
//        emailService.save(emailBox);
//        model.addAttribute("language",emailBox);
//        return "result";
//    }
    @GetMapping("/getEmailConfig/{language}")
    public ModelAndView get(@PathVariable String language) {

        EmailBox emailBox = emailService.getEmailConfig(language);
        ModelAndView modelAndView = new ModelAndView("result");
        if(emailBox!=null) {
            modelAndView.addObject("mess","Email's setting successfully saved");
            modelAndView.addObject("emailBox",emailBox);
        }else {
            modelAndView.addObject("mess","Fail to save email's setting");
        }
        return modelAndView;
    }
}
