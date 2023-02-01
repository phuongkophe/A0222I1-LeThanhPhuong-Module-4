package com.example.exam.service;

import com.example.exam.entity.QuestionContent;
import com.example.exam.entity.QuestionType;
import com.example.exam.repository.IQuestionContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class QuestionContentService implements IServiceQuestionContent{
    @Autowired
    IQuestionContentRepository iQuestionContentRepository;

    @Override
    public Page<QuestionContent> findAllByTitleAndType(String title, QuestionType questionType, Pageable pageable) {
        return null;
    }

    @Override
    public Page<QuestionContent> findAll(Pageable pageable) {
        return iQuestionContentRepository.findAll(pageable);
    }

    @Override
    public void removeById(Long id) {
        iQuestionContentRepository.deleteById(id);
    }

    @Override
    public void save(QuestionContent questionContent) {
        iQuestionContentRepository.save(questionContent);
    }

    @Override
    public QuestionContent findById(Long id) {
        return iQuestionContentRepository.findById(id).orElse(null);
    }

}
