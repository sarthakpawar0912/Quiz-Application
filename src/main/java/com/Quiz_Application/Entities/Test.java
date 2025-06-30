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


    public TestDto getDto(){
        TestDto testDto=new TestDto();
        testDto.setId(id);
        testDto.setTitle(title);
        testDto.setDescription(description);
        testDto.setTime(time);
        return testDto;
    }

}
