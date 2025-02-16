package com.Quiz_Application.Dto;

import lombok.Data;

@Data
public class TestDto {

    private Long id;

    private String title;

    private  String description;

    private Long time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public TestDto(Long id, String title, String description, Long time) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.time = time;
    }

    public TestDto() {
    }

    @Override
    public String toString() {
        return "TestDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", time=" + time +
                '}';
    }


}
