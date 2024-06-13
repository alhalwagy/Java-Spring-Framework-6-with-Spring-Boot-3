package com.spring_data_jpa;

import com.spring_data_jpa.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(SpringDataJpaApplication.class, args);

		Student student0 = ctx.getBean( Student.class);
		Student student1 = ctx.getBean( Student.class);
		Student student2 = ctx.getBean( Student.class);
		Student student3 = ctx.getBean(Student.class);

		StudentRepo repo  = ctx.getBean("studentRepo", StudentRepo.class);

		student0.setName("ahmed");
		student0.setMarks(100);
		student0.setRollNo(4);

		student1.setName("mohamed");
		student1.setMarks(200);
		student1.setRollNo(5);

		student2.setName("ahmed");
		student2.setMarks(100);
		student2.setRollNo(4);

		student3.setName("mohamed");
		student3.setMarks(200);
		student3.setRollNo(5);

		repo.save(student0);
		repo.save(student1);
		repo.save(student2);
		repo.save(student3);

		System.out.println(repo.findByMarksGreaterThan(70));
	}

}
