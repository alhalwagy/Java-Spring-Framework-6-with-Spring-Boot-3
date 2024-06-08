package com.hlwg.springJDBC.repo;

import com.hlwg.springJDBC.model.Student;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepo {

  private JdbcTemplate jdbcTemplate;

  public JdbcTemplate getJdbcTemplate() {
    return jdbcTemplate;
  }

  @Autowired
  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public void save(Student student) {

    String sql = "insert into student (rollno, name, marks) values(?,?,?)";
    int rows = jdbcTemplate.update(sql, student.getRollNo(), student.getName(), student.getMarks());

    System.out.println(rows);
  }

  public List<Student> findAll() {

    String sql = "select * from student";

    return jdbcTemplate.query(
        sql,
        (ResultSet rs, int rowNum) -> {
          Student student = new Student();
          student.setRollNo(rs.getInt("rollno"));
          student.setName(rs.getString("name"));
          student.setMarks(rs.getInt("marks"));
          return student;
        });
  }
}
