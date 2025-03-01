package com.Quiz_Application.Controller;

import com.Quiz_Application.Dto.QuestionDto;
import com.Quiz_Application.Dto.SubmitTestDto;
import com.Quiz_Application.Dto.TestDto;
import com.Quiz_Application.Service.Test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/test")
@CrossOrigin("*")
public class TestController {

    @Autowired
    private TestService testService;


    @PostMapping()
    public ResponseEntity<?> createTest(@RequestBody TestDto dto){
        try {
            return new ResponseEntity<>(testService.createTest(dto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/question")
    public ResponseEntity<?> addQuestionInTest(@RequestBody QuestionDto dto){
        try {
            return new ResponseEntity<>(testService.addQuestionInTest(dto),HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping
    public ResponseEntity<?> getAllTest(){
        try {
            return new ResponseEntity<>(testService.getAllTests(),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST );
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getAllQuestions(@PathVariable Long id){
        try {
            return new ResponseEntity<>(testService.getAllQuestionsByTest(id),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/submit-test")
    public ResponseEntity<?> submitTest(@RequestBody SubmitTestDto dto){
        try {
            return new ResponseEntity<>(testService.submitTest(dto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/test-result")
    public ResponseEntity<?> getAllTestResult(){
        try {
            return new ResponseEntity<>(testService.getAllTestResult(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/test-result/{id}")
    public ResponseEntity<?> getAllTestResultOfUser(@PathVariable Long id){
        try {
            return new ResponseEntity<>(testService.getAllResultsOfUser(id),HttpStatus.OK);
        } catch (Exception e) {
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

}
