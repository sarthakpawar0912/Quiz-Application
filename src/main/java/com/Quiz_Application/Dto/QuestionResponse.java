package com.Quiz_Application.Dto;

import lombok.Data;

@Data
public class QuestionResponse {
      private Long questionId;
      private  String selectedOption;
    public QuestionResponse(Long questionId, String selectedOption) {
        this.questionId = questionId;
        this.selectedOption = selectedOption;
    }
    public QuestionResponse() {
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(String selectedOption) {
        this.selectedOption = selectedOption;
    }
    @Override
    public String toString() {
        return "QuestionResponse{" +
                "questionId=" + questionId +
                ", selectedOption='" + selectedOption + '\'' +
                '}';
    }
}
