package com.codegym.a0222i1.repository;


import com.codegym.a0222i1.model.Student;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IStudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAllByNameStudentContaining(String name);
    //    @Query(value = "select s from student s where s.nameStudent like :name")
//    List<Student> searchName(@Param("name") String name);

    //Các truy vấn mà thay đổi dữ liệu thì cần dùng 2 annotation bên dưới
//    @Modifying

    @Query(value = "select * from student where name_student like :name", nativeQuery = true)
    List<Student> searchName(@Param("name") String name);

}
