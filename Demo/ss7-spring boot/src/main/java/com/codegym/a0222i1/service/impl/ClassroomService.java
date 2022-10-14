package com.codegym.a0222i1.service.impl;

import com.codegym.a0222i1.model.ClassRoom;
import com.codegym.a0222i1.repository.IClassroomRepository;
import com.codegym.a0222i1.service.IClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService implements IClassroomService {
    @Autowired
    private IClassroomRepository iClassroomRepository;
    @Override
    public List<ClassRoom> findAll() {
        return iClassroomRepository.findAll();
    }
}
