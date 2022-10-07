package com.codegym.controller;

import com.codegym.model.Student;
import com.codegym.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class StudentController {

    @Autowired
    @Qualifier("studentService")
    private IStudentService iStudentService;

//    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @GetMapping(value = "/list")
    public String showList(Model model) {
        model.addAttribute("listStudent", iStudentService.getAll());
        return "list";
    }

    @GetMapping(value = "detail/{id}")
    public String showDetail(@PathVariable(value = "id") int id, Model model) {
       model.addAttribute("student", iStudentService.getStudentById(id));
        return "detail";
    }
    @GetMapping(value = "detail")
    public String showDetailByRequestParam(@RequestParam(defaultValue = "2") int id, Model model) {
        model.addAttribute("student", iStudentService.getStudentById(id));
        return "detail";
    }

    @GetMapping("/create")
    public String showCreatePage(Model model) {
        model.addAttribute("student", new Student(0, "",0.0,0));
        model.addAttribute("listGender", new String[] {"1","0"});
        return "/create";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute("student")Student student,
                                Model model,
                                RedirectAttributes redirectAttributes) {
        iStudentService.save(student);
//        List<Student> list = iStudentService.getAll();
//        model.addAttribute("listStudent", list);
        redirectAttributes.addFlashAttribute("msg","Thêm mới thành công");
        return "redirect:/list";
    }



}
