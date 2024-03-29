package com.codegym.controller;

import com.codegym.entity.Blog;
import com.codegym.entity.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;
    @Autowired
    IBlogService blogService;

//    @GetMapping("/blog-list-category/{id}")
//    public String viewBlogList(@PathVariable("id") Integer id, Model model, @PageableDefault(value = 4) Pageable pageable) {
//        Page<Blog> blogList = blogService.findAllByCategory(id, pageable);
//        List<Category> categoryList = categoryService.findAll();
//        model.addAttribute("blogList",blogList);
//        model.addAttribute("categoryList", categoryList);
//        model.addAttribute("id", id);
//        return "category/list";
//    }

    @GetMapping("/blog-list-category/{id}")
    public String viewBlogList(@PathVariable("id") Integer id, Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(4);
        Page<Blog> blogList = blogService.findAllByCategory(id, PageRequest.of(currentPage - 1, pageSize));
        List<Category> categoryList = categoryService.findAll();

        int totalPages = blogList.getTotalPages();
        if(totalPages > 1) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1 , totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        model.addAttribute("blogList",blogList);
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("id", id);
        return "category/list";
    }



    @ModelAttribute("category")
    public Category init() {
        return new Category();
    }

    @GetMapping("/list")
    public String display(Model model) {
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        return "category/list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Integer id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "category/view";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        categoryService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Xoá Category thành công");
        return "redirect:/blog/list";
    }

    @GetMapping("/create")
    public String viewCreate() {
        return "category/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
        categoryService.create(category);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới Category thành công");
        return "redirect:/blog/list";
    }

    @GetMapping("/edit/{id}")
    public String viewEdit(@PathVariable("id") Integer id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "category/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
        categoryService.update(category);
        redirectAttributes.addFlashAttribute("mess", "Edit Category thành công");
        return "redirect:/blog/list";
    }
}
