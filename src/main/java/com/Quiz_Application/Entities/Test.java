package com.Quiz_Application.Entities;

import com.Quiz_Application.Dto.TestDto;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private  String description;

    private Long time;




    @OneToMany(mappedBy = "test",cascade = CascadeType.ALL)
    private List<Question> questions;

    public Test(Long id, String title, String description, Long time, List<Question> questions) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.time = time;
        this.questions = questions;
    }

    public Test() {
    }

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

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", time=" + time +
                ", questions=" + questions +
                '}';
    }

    public TestDto getDto(){
        TestDto testDto=new TestDto();

        testDto.setId(id);
        testDto.setTitle(title);
        testDto.setDescription(description);
        testDto.setTime(time);

        return testDto;
    }

}
