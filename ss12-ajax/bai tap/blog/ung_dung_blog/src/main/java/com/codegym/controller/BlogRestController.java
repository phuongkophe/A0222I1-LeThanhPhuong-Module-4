package com.codegym.controller;

import com.codegym.entity.Blog;
import com.codegym.entity.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@RestController
@RequestMapping("/api/blogs")
public class BlogRestController {
    @Autowired
    ICategoryService categoryService;

    @Autowired
    IBlogService blogService;

    @GetMapping
    public ResponseEntity<Page<Blog>> findAllBlog(@PageableDefault(
//            direction = Sort.Direction.ASC, sort = {"id"},
            value = 4) Pageable pageable) {
        Page<Blog> blogPage = blogService.findAll(pageable);
        if (blogPage == null) {
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

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public Page<Blog> searchBlog(@PageableDefault(value = 100) Pageable pageable, @RequestParam("blogName") Optional<String> name) {
        if (name.isPresent()) {
            return blogService.search(name.get(), pageable);
        } else {
            return blogService.findAll(pageable);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Blog>> findAllLimit(@RequestParam("limit") Integer limit) {
        limit += 2;
        List<Blog> blogList = blogService.findAllLimit(limit);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
}
