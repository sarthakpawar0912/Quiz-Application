package com.Quiz_Application.Dto;

import lombok.Data;
@Data
public class TestResultDto {

    private  int id;
    private int totalQuestions;
    private int correctAnswers;
    private double percentage;
    private String testName;
    private String userName;

}
