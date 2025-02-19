package com.Quiz_Application.Dto;

import java.util.List;

public class SubmitTestDto {
    private Long id;
    private Long userId;
    private List<QuestionResponse> responses;
    public SubmitTestDto(Long id, Long userId, List<QuestionResponse> responses) {
        this.id = id;
        this.userId = userId;
        this.responses = responses;
    }

    public SubmitTestDto() {
    }

    @Override
    public String toString() {
        return "SubmitTestDto{" +
                "id=" + id +
                ", userId=" + userId +
                ", responses=" + responses +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
