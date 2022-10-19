package com.codegym.a0222i1.controller;

import com.codegym.a0222i1.model.Student;
import com.codegym.a0222i1.service.IClassroomService;
import com.codegym.a0222i1.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
public class StudentController {

    @Autowired
    @Qualifier("studentService")
    private IStudentService iStudentService;

    @Autowired
    private IClassroomService iClassroomService;

    //    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @GetMapping(value = "/list")
    public String showList(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        Sort sort = Sort.by("point").descending().and(Sort.by("nameStudent").descending());
        model.addAttribute("listStudent", iStudentService.getAll(PageRequest.of(page, 1, sort)));
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
        model.addAttribute("student", new Student());
        model.addAttribute("listClass", iClassroomService.findAll());
        model.addAttribute("listGender", new String[]{"1", "0"});
        return "/create";
    }

    @PostMapping("/create")
    public String createStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult,
                                Model model,
                                RedirectAttributes redirectAttributes) {

//        new Student().validate(student, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("listClass", iClassroomService.findAll());
            return "/create";
        }
        iStudentService.save(student);
//        List<Student> list = iStudentService.getAll();
//        model.addAttribute("listStudent", list);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:/list";
    }


}
