package com.hlwg.springJDBC.service;

import com.hlwg.springJDBC.model.Student;
import com.hlwg.springJDBC.repo.StudentRepo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

 private StudentRepo studentRepo;

  public StudentRepo getStudentRepo() {
    return studentRepo;
  }

  @Autowired
  public void setStudentRepo(StudentRepo studentRepo) {
    this.studentRepo = studentRepo;
  }

  public void addStudent(Student student) {
   studentRepo.save(student);
  }


  public List<Student> getAllStudents() {

    return studentRepo.findAll();
  }
}
