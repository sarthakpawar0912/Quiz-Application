package com.Quiz_Application.Service.Test;

import com.Quiz_Application.Dto.*;
import com.Quiz_Application.Entities.Question;
import com.Quiz_Application.Entities.Test;
import com.Quiz_Application.Entities.TestResult;
import com.Quiz_Application.Entities.User;
import com.Quiz_Application.Repository.QuestionRepository;
import com.Quiz_Application.Repository.TestRepository;
import com.Quiz_Application.Repository.TestResultRepository;
import com.Quiz_Application.Repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private TestResultRepository testResultRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public TestDto createTest(TestDto dto) {
        Test test = new Test();
        test.setTitle(dto.getTitle());
        test.setDescription(dto.getDescription());
        test.setTime(dto.getTime());
        return testRepository.save(test).getDto();
    }

    @Override
    public QuestionDto addQuestionInTest(QuestionDto dto) {
        Optional<Test> optionalTest = testRepository.findById(dto.getId());
        if (optionalTest.isPresent()) {
            Question question = new Question();
            question.setTest(optionalTest.get());
            question.setQuestionText(dto.getQuestionText());
            question.setOptionA(dto.getOptionA());
            question.setOptionB(dto.getOptionB());
            question.setOptionC(dto.getOptionC());
            question.setOptionD(dto.getOptionD());
            question.setCorrectOption(dto.getCorrectOption());
            return questionRepository.save(question).getDto();
        }
        throw new EntityNotFoundException("Test not Found");
    }

    @Override
    public List<TestDto> getAllTests() {
        List<TestDto> tests = testRepository.findAll().stream()
                .peek(test -> test.setTime(test.getQuestions().size() * test.getTime()))
                .map(Test::getDto)
                .collect(Collectors.toList());
        Collections.reverse(tests);
        return tests;
    }

    @Override
    public TestDetailsDto getAllQuestionsByTest(Long id) {
        Optional<Test> optionalTest = testRepository.findById(id);
        TestDetailsDto testDetailsDto = new TestDetailsDto();
        if (optionalTest.isPresent()) {
            TestDto testDto = optionalTest.get().getDto();
            testDto.setTime(optionalTest.get().getTime() * optionalTest.get().getQuestions().size());
            testDetailsDto.setTestDto(testDto);
            testDetailsDto.setQuestionDto(optionalTest.get().getQuestions().stream().map(Question::getDto).toList());
            return testDetailsDto;
        }
        return testDetailsDto;
    }

    @Override
    public TestResultDto submitTest(SubmitTestDto request) {
        try {
            // Log the incoming request
            System.out.println("📥 Received Request: " + request);

            // Fetch the test and user from the database
            Test test = testRepository.findById(request.getTestId())
                    .orElseThrow(() -> new EntityNotFoundException("Test not Found"));

            User user = userRepository.findById(request.getUserId())
                    .orElseThrow(() -> new EntityNotFoundException("User Not found"));

            int correctAnswer = 0;
            // Process each response
            for (QuestionResponse response : request.getResponses()) {
                System.out.println("🔍 Processing Response: Question ID = " + response.getQuestionId() + ", Selected Option = " + response.getSelectedOption());

                // Fetch the question from the database
                Question question = questionRepository.findById(response.getQuestionId())
                        .orElseThrow(() -> new EntityNotFoundException("Question not Found"));

                // Debugging: Print fetched values
                System.out.println("✅ Question ID: " + question.getId());
                System.out.println("✅ Correct Option: [" + question.getCorrectOption().trim().toLowerCase() + "]");
                System.out.println("✅ User Selected Option: [" + response.getSelectedOption().trim().toLowerCase() + "]");

                // Compare the correct option with the selected option (case-insensitive)
                if (question.getCorrectOption().trim().equalsIgnoreCase(response.getSelectedOption().trim())) {
                    correctAnswer++;
                }
            }

            // Calculate total questions and percentage
            int totalQuestions = test.getQuestions().size();
            double percentage = ((double) correctAnswer / totalQuestions) * 100;

            // Log calculated results
            System.out.println("📊 Correct Answers: " + correctAnswer);
            System.out.println("📊 Total Questions: " + totalQuestions);
            System.out.println("📊 Percentage: " + percentage);

            // Create and save the test result
            TestResult testResult = new TestResult();
            testResult.setTest(test);
            testResult.setUser(user);
            testResult.setTotalQuestions(totalQuestions);
            testResult.setCorrectAnswers(correctAnswer);
            testResult.setPercentage(percentage);

            testResult = testResultRepository.save(testResult);

            // Log the saved result
            System.out.println("💾 Saved TestResult ID: " + testResult.getId());

            return testResult.getDto();
        } catch (Exception e) {
            // Log the exception for debugging
            System.err.println("❌ Error submitting test: " + e.getMessage());
            throw new RuntimeException("Failed to submit test: " + e.getMessage());
        }
    }

    @Override
    public List<TestResultDto> getAllTestResult() {
        return testResultRepository.findAll().stream().map(TestResult::getDto).collect(Collectors.toList());
    }

    @Override
    public List<TestResultDto> getAllResultsOfUser(Long userId) {
        return testResultRepository.findAllByUserId(userId).stream().map(TestResult::getDto).collect(Collectors.toList());
    }

}
