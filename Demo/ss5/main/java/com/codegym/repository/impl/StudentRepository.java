package com.codegym.repository.impl;

import com.codegym.model.Student;
import com.codegym.repository.IStudentRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {
    static List<Student> students = new ArrayList<>();

    static {

    }

    @Override
    public List<Student> getAll() {
//       NativeQuery
        List<Student> students = BaseRepository.entityManager.createQuery("select s from student s", Student.class).getResultList();
        return students;
    }

    @Override
    public void save(Student student) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(student);
        entityTransaction.commit();
    }

    @Override
    public Student getStudentById(int id) {
        //Hàm find để tìm kiếm theo id.
        for (Student student : students) {
            if (student.getCodeStudent() == id) {
                return student;
            }
        }
        return null;
    }
}
