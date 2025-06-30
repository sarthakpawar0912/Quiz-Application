package com.Quiz_Application.Entities;

import com.Quiz_Application.Dto.QuestionDto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String questionText;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String correctOption;
    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;

    public QuestionDto getDto() {
        QuestionDto dto = new QuestionDto();
        dto.setId(id);
        dto.setQuestionText(questionText);
        dto.setOptionA(optionA);
        dto.setOptionB(optionB);
        dto.setOptionC(optionC);
        dto.setOptionD(optionD);
        dto.setCorrectOption(correctOption);
        return dto;
    }

}
