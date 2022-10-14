package com.codegym.a0222i1.service.impl;


import com.codegym.a0222i1.model.Student;
import com.codegym.a0222i1.repository.IStudentRepository;
import com.codegym.a0222i1.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("studentService")
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository iStudentRepository;
    @Override
    public List<Student> getAll() {
        return iStudentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        this.iStudentRepository.save(student);
    }

    @Override
    public Student getStudentById(int id) {
//        Optional<Student> student = iStudentRepository.findById(id);
//        if(student.isPresent()) {
//            return student.get();
//        } else {
//            return null;
//        }
        return iStudentRepository.findById(id).orElse(null);
    }

    @Override
    public Page getAll(Pageable pageable) {
        return iStudentRepository.findAll(pageable);
    }
}
