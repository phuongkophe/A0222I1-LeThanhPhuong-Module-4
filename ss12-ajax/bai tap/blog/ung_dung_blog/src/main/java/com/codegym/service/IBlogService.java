package com.codegym.service;

import com.codegym.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    void create(Blog blog);

    void update(Blog blog);

    void delete(Integer id);

    Page<Blog> findAll(Pageable pageable);

    Blog findById(Integer id);

    Page<Blog> search(String name, Pageable pageable);

    Page<Blog> findAllByCategory(Integer id, Pageable pageable);

    List<Blog> findAllLimit(Integer limit);
}
