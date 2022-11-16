package com.codegym.service;

import com.codegym.entity.Blog;
import com.codegym.entity.Category;

import java.util.List;

public interface ICategoryService {
    void create(Category category);
    void update(Category category);
    void delete(Integer id);
    List<Category> findAll();
    Category findById(Integer id);
}
