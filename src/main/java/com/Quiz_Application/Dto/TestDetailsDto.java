package com.Quiz_Application.Dto;

import lombok.Data;

import java.util.List;

@Data
public class TestDetailsDto {

    private TestDto testDto;
    private List<QuestionDto> questionDto;


}
