package com.example.exam.service;

import com.example.exam.entity.QuestionType;
import com.example.exam.repository.IQuestionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class QuestionTypeService implements IServiceQuestionType {
    @Autowired
    IQuestionTypeRepository iQuestionTypeRepository;

    @Override
    public List<QuestionType> findAll() {
        return iQuestionTypeRepository.findAll();
    }

    @Override
    public void save(QuestionType questionType) {
        iQuestionTypeRepository.save(questionType);
    }

    @PostConstruct
    public void inputData(){
        save(new QuestionType(1L,"Học tập"));
        save(new QuestionType(2L,"Giáo vụ"));
        save(new QuestionType(3L,"Khác"));
    }
}
