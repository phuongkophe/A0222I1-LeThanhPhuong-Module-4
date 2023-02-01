package com.example.exam.service;

import com.example.exam.entity.QuestionContent;
import com.example.exam.entity.QuestionType;

import java.util.List;

public interface IServiceQuestionType {
    List<QuestionType> findAll();
    void save(QuestionType questionType);
}
