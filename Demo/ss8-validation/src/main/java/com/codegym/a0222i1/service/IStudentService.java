package com.codegym.a0222i1.service;


import com.codegym.a0222i1.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    List<Student> getAll();

    void save(Student student);

    Student getStudentById(int id);

    Page getAll(Pageable pageable);
}
