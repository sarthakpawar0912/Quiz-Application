package com.Quiz_Application.Dto;

import lombok.Data;

import java.util.List;

@Data
public class TestDetailsDto {


    private TestDto testDto;

    private List<QuestionDto> questionDto;

    public TestDetailsDto(TestDto testDto, List<QuestionDto> questionDto) {
        this.testDto = testDto;
        this.questionDto = questionDto;
    }

    public TestDetailsDto() {
    }

    public TestDto getTestDto() {
        return testDto;
    }

    public void setTestDto(TestDto testDto) {
        this.testDto = testDto;
    }

    public List<QuestionDto> getQuestionDto() {
        return questionDto;
    }

    public void setQuestionDto(List<QuestionDto> questionDto) {
        this.questionDto = questionDto;
    }

    @Override
    public String toString() {
        return "TestDetailsDto{" +
                "testDto=" + testDto +
                ", questionDto=" + questionDto +
                '}';
    }
}
