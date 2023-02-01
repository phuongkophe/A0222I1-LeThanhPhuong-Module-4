package com.example.exam.service;

import com.example.exam.entity.QuestionContent;
import com.example.exam.entity.QuestionType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IServiceQuestionContent {
    Page<QuestionContent> findAllByTitleAndType(String title, QuestionType questionType, Pageable pageable);

    Page<QuestionContent>findAll(Pageable pageable);

    void removeById(Long id);

    void save(QuestionContent questionContent);

    QuestionContent findById(Long id);
}
