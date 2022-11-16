package com.codegym.controller;

import com.codegym.entity.Blog;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/blogs")
public class BlogRestController {
    @Autowired
    ICategoryService categoryService;

    @Autowired
    IBlogService blogService;

    @GetMapping
    public ResponseEntity<Page<Blog>> findAllBlog(@PageableDefault(direction = Sort.Direction.ASC, sort = {"id"},value = 5) Pageable pageable) {
        Page<Blog> blogPage = blogService.findAll(pageable);
        if(blogPage == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(blogPage, HttpStatus.OK);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Blog> viewBlog(@PathVariable("id") Integer id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(blog, HttpStatus.OK);
        }
    }
}
