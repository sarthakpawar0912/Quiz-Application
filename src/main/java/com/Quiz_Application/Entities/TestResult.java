package com.Quiz_Application.Entities;

import com.Quiz_Application.Dto.TestResultDto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TestResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private int totalQuestions;
    private int correctAnswers;
    private double percentage;
    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public TestResultDto getDto(){
        TestResultDto dto=new TestResultDto();
        dto.setId(id);
        dto.setTotalQuestions(totalQuestions);
        dto.setCorrectAnswers(correctAnswers);
        dto.setPercentage(percentage);
        dto.setTestName(test.getTitle());
        dto.setUserName(user.getName());
        return dto;
    }

}
