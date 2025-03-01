package com.Quiz_Application.Repository;
import com.Quiz_Application.Entities.Test;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TestRepository extends JpaRepository<Test,Long>
{

}
