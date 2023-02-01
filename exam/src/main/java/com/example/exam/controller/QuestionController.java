package com.example.exam.controller;

import com.example.exam.entity.QuestionContent;
import com.example.exam.service.IServiceQuestionContent;
import com.example.exam.service.IServiceQuestionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.Binding;
import javax.validation.Valid;

@Controller
public class QuestionController {
    @Autowired
    IServiceQuestionContent iServiceQuestionContent;

    @Autowired
    IServiceQuestionType iServiceQuestionType;

    @GetMapping("")
    public String getList(@RequestParam(value = "title", defaultValue = "") String title,
            @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.ASC) Pageable pageable, Model model){
        model.addAttribute("listQuestionType", iServiceQuestionType.findAll());
        model.addAttribute("title", title);
        model.addAttribute("list", iServiceQuestionContent.findAll(pageable));
        return "home";
    }
    @GetMapping("/delete")
    public String deleteById(@RequestParam("id") Long id, RedirectAttributes attributes){
        iServiceQuestionContent.removeById(id);
        attributes.addFlashAttribute("message","delete success");
        return "redirect:/";
    }
    @GetMapping("/create")
    public String createQuestion(Model model){
        model.addAttribute("target", new QuestionContent());
        model.addAttribute("listQuestionType", iServiceQuestionType.findAll());
        return "update";
    }
    @GetMapping("/edit/{id}")
    public String editQuestion(Model model, @PathVariable Long id){
        model.addAttribute("target",iServiceQuestionContent.findById(id));
        model.addAttribute("listQuestionType",iServiceQuestionType.findAll());
        return "update";
    }
    @PostMapping("/update")
    public String updateTarget(@Valid @ModelAttribute("Target") QuestionContent questionContent,
                               BindingResult result, RedirectAttributes attributes, Model model){
        if (result.hasErrors()){
            model.addAttribute("ListQuestionType", iServiceQuestionType.findAll());
            return "update";
        }
        if(questionContent.getId() == null){
            attributes.addFlashAttribute("message","create success");
        }
        else{
            attributes.addFlashAttribute("message","edit success");
        }
        iServiceQuestionContent.save(questionContent);

        return "redirect:/";
    }

}
