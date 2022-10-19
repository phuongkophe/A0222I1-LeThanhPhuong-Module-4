package com.codegym.a0222i1.model;

import com.codegym.a0222i1.utils.validate.NameValidate;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity(name = "student")
public class Student implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_student")
    private Integer codeStudent;
    @Column(name = "name_student", columnDefinition = "VARCHAR(50)")
//    @NotBlank(message = "Tên không được để trống")
//    @Size(min = 3, message = "Tên ít nhất 3 kí tự")
    @NameValidate
    private String nameStudent;
    @Min(value = 0, message = "Điểm không được nhỏ hơn 0")
    @Max(value = 10, message = "Điểm không được lớn hơn 10")
    private Double point;
    private Integer gender;

    @ManyToOne
    @JoinColumn(name = "id_class")
    private ClassRoom classRoom;

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public Student() {
    }

    public Student(Integer codeStudent, String nameStudent, Double point, Integer gender) {
        this.codeStudent = codeStudent;
        this.nameStudent = nameStudent;
        this.point = point;
        this.gender = gender;
    }

    public Integer getCodeStudent() {
        return codeStudent;
    }

    public void setCodeStudent(Integer codeStudent) {
        this.codeStudent = codeStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Student student = (Student) target;
        if (!student.nameStudent.matches("^[A-Za-z ]{4,}$")) {
            errors.rejectValue("nameStudent", "nameStudent.invalidFormat", "Tên không được có kí tự số và có ít nhất 4 kí tự.");
        }
    }
}
