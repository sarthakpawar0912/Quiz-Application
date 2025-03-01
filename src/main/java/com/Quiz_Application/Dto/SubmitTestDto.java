package com.Quiz_Application.Dto;

import lombok.Data;
import java.util.List;
@Data
public class SubmitTestDto {

    private Long testId;
    private Long userId;
    private List<QuestionResponse> responses;

    public SubmitTestDto(Long testId, Long userId, List<QuestionResponse> responses) {
        this.testId = testId;
        this.userId = userId;
        this.responses = responses;
    }

    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<QuestionResponse> getResponses() {
        return responses;
    }

    public void setResponses(List<QuestionResponse> responses) {
        this.responses = responses;
    }

    public SubmitTestDto() {
    }

}
