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

    public TestResultDto(int id, int totalQuestions, int correctAnswers, double percentage, String testName, String userName) {
        this.id = id;
        this.totalQuestions = totalQuestions;
        this.correctAnswers = correctAnswers;
        this.percentage = percentage;
        this.testName = testName;
        this.userName = userName;
    }

    public TestResultDto() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
