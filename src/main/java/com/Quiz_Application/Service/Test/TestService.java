package com.Quiz_Application.Service.Test;
import com.Quiz_Application.Dto.*;
import java.util.List;
public interface TestService
{
    TestDto createTest(TestDto  dto);

    QuestionDto addQuestionInTest(QuestionDto dto);

    List<TestResultDto> getAllTestResult();

    List<TestDto> getAllTests();

    TestDetailsDto getAllQuestionsByTest(Long id);

    TestResultDto submitTest(SubmitTestDto request);

    List<TestResultDto> getAllResultsOfUser(Long userId);
}
