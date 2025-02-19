package com.Quiz_Application.Repository;

import com.Quiz_Application.Entities.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestResultRepository extends JpaRepository<TestResult,Long> {

    List<TestResult> findAllByUserId(Long userId);
}
