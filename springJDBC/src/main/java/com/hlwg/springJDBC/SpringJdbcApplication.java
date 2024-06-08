package com.hlwg.springJDBC;

import com.hlwg.springJDBC.model.Student;
import com.hlwg.springJDBC.service.StudentService;
import java.security.Provider.Service;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);

		Student s = context.getBean(Student.class);

		s.setName("ahmed");
		s.setMarks(100);
		s.setRollNo(4);

		StudentService service = context.getBean(StudentService.class);

		service.addStudent(s);

		List<Student> students = service.getAllStudents();

    System.out.println(students);
	}

}
