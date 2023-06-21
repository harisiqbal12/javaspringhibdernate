package com.learn.springhibernate;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.learn.springhibernate.dao.StudentDAO;
import com.learn.springhibernate.entity.Student;

@SpringBootApplication
public class SpringhibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringhibernateApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// deleteStudent(studentDAO);
			createStudent(studentDAO);
		};
	}

	private void deleteStudent(StudentDAO studentDAO) {
		long startTime = System.currentTimeMillis();

		studentDAO.deleteStudent(4);

		long stopTime = System.currentTimeMillis();

		System.out.println("total time take: " + (stopTime - startTime) + "ms");
	}

	private void updateStudent(StudentDAO studentDAO) {
		long startTime = System.currentTimeMillis();

		studentDAO.updateStudent(1, "haris", "iqbal");

		long stopTime = System.currentTimeMillis();

		System.out.println("total time take: " + (stopTime - startTime) + "ms");
	}

	private void findStudents(StudentDAO studentDAO) {
		long startTime = System.currentTimeMillis();

		List<Student> result = studentDAO.findAll();

		result.forEach(el -> {
			System.out.println(el.getEmail());
		});

		long stopTime = System.currentTimeMillis();

		System.out.println("total time take: " + (stopTime - startTime) + "ms");
	}

	// private void findStudent(StudentDAO studentDAO) {

	// long startTime = System.currentTimeMillis();

	// Student student = studentDAO.findById(1);
	// System.out.println("Student name: " + student.getFirstName() +
	// student.getLastName());

	// long stopTime = System.currentTimeMillis();

	// System.out.println("total time take: " + (stopTime - startTime) + "ms");

	// }

	// Multi threading
	// class StudentWrapper implements Runnable {
	// StudentDAO studentDAO;

	// public StudentWrapper(StudentDAO studentDAO) {
	// this.studentDAO = studentDAO;
	// }

	// private void findAndLogStudent(StudentDAO studentDAO) {
	// Student student = studentDAO.findById(1);
	// System.out.println("Student name: " + student.getFirstName() +
	// student.getLastName());
	// }

	// @Override
	// public void run() {
	// findAndLogStudent(studentDAO);
	// }
	// }

	private void createStudent(StudentDAO studentDAO) {
		long startTime = System.currentTimeMillis();

		Student student = new Student("Haris", "Ansari", "harisansari@gmail.com");
		studentDAO.save(student);

		

		long stopTime = System.currentTimeMillis();

		System.out.println("added to database");
		System.out.println("total time take: " + (stopTime - startTime) + "ms");
	}

}
