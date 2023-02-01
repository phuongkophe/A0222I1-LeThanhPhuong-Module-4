package com.example.exam.entity;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
public class QuestionContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Min(5)
    @Max(100)
    private String title;
    @NotNull
    @Min(10)
    @Max(500)
    private String content;
    @NotNull
    private String answer;
    @NotNull
    private Date dateCreates;
    @NotNull
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "id_question_type", nullable = false, referencedColumnName = "id")
    QuestionType questionType;

    public QuestionContent() {
    }

    public QuestionContent(Long id, String title, String content, String answer, Date dateCreates, boolean status, QuestionType questionType) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.answer = answer;
        this.dateCreates = dateCreates;
        this.status = status;
        this.questionType = questionType;
    }

    public QuestionContent(String title, String content, String answer, Date dateCreates, boolean status, QuestionType questionType) {
        this.title = title;
        this.content = content;
        this.answer = answer;
        this.dateCreates = dateCreates;
        this.status = status;
        this.questionType = questionType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Date getDateCreates() {
        return dateCreates;
    }

    public void setDateCreates(Date dateCreates) {
        this.dateCreates = dateCreates;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }
}
