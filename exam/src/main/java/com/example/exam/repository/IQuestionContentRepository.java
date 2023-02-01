package com.example.exam.repository;

import com.example.exam.entity.QuestionContent;
import com.example.exam.entity.QuestionType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionContentRepository extends JpaRepository<QuestionContent, Long> {
    @Query(value = "select i from QuestionContent i where i.title like concat('%',:title,'%')", nativeQuery = false,
            countQuery ="select count(i) from QuestionContent i where i in (select i from QuestionContent i where i.title like concat('%',:title,'%'))")
    Page<QuestionContent>findAllByTitle(@Param("title") String title, Pageable pageable);
}
