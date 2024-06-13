package com.spring_data_jpa;

import com.spring_data_jpa.model.Student;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {


 List<Student> findByName(String name);
 List<Student> findByMarksGreaterThan(int name);
}
