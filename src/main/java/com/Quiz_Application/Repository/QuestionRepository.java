package com.Quiz_Application.Repository;

import com.Quiz_Application.Entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Long> {



}
