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

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TestServiceImpl implements TestService{


    @Autowired
    private TestRepository testRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private TestResultRepository testResultRepository;
    @Autowired
    private UserRepository userRepository;
    public TestDto createTest(TestDto  dto){
        Test test=new Test();
        test.setTitle(dto.getTitle());
        test.setDescription(dto.getDescription());
        test.setTime(dto.getTime());
        return testRepository.save(test).getDto();
    }
    public QuestionDto addQuestionInTest(QuestionDto dto){
        Optional<Test> optionalTest =testRepository.findById(dto.getId());
        if(optionalTest.isPresent()){
            Question question=new Question();
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
    public List<TestDto> getAllTests(){
        return  testRepository.findAll().stream().peek(
                test -> test.setTime(test.getQuestions().size() * test.getTime())).collect(Collectors.toList())
                .stream().map(Test::getDto).collect(Collectors.toList());
    }

    public TestDetailsDto getAllQuestionsByTest(Long id){
        Optional<Test> optionalTest=testRepository.findById(id);
        TestDetailsDto testDetailsDto=new TestDetailsDto();
        if(optionalTest.isPresent()) {
            TestDto testDto=optionalTest.get().getDto();
            testDto.setTime(optionalTest.get().getTime() * optionalTest.get().getQuestions().size());
            testDetailsDto.setTestDto(testDto);
            testDetailsDto.setQuestionDto(optionalTest.get().getQuestions().stream().map(Question::getDto).toList());
            return  testDetailsDto;
        }
        return testDetailsDto;
    }

    public TestResultDto submitTest(SubmitTestDto request){
        Test test=testRepository.findById(request.getId()).orElseThrow(()->new EntityNotFoundException("Test not Found"));
        User user=userRepository.findById(request.getUserId()).orElseThrow(()-> new EntityNotFoundException("User Not found"));
        int correctAnswer=0;
        for(QuestionResponse response: request.getResponses()) {
            Question question = questionRepository.findById(response.getQuestionId()).orElseThrow(() -> new EntityNotFoundException("Question not Found"));
            if (question.getCorrectOption().equals(response.getSelectedOption())) {
                correctAnswer++;
            }
        }
            int totalQuestions=test.getQuestions().size();
            double percentage=((double) correctAnswer/totalQuestions)*100;
            TestResult  testResult=new TestResult();
            testResult.setTest(test);
            testResult.setUser(user);
            testResult.setTotalQuestions(totalQuestions);
            testResult.setCorrectAnswers(correctAnswer);
            testResult.setPercentage(percentage);
            return testResultRepository.save(testResult).getDto() ;

    }
    public List<TestResultDto> getAllTestResult(){
        return testResultRepository.findAll().stream().map(TestResult::getDto).collect(Collectors.toList());
    }
    public List<TestResultDto> getAllResultsOfUser(Long userId){
        return testResultRepository.findAllByUserId(userId).stream().map(TestResult::getDto).collect(Collectors.toList());
    }
}
