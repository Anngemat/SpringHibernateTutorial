package com.example.HibernateTut.HibernateEx;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.HibernateTut.HibernateEx.Crud.Student;
import com.example.HibernateTut.HibernateEx.dao.StudentDAO;

@SpringBootApplication
public class HibernateExApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateExApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentdao) {
		return runner ->{
			createStudent(studentdao);
			findStudent(studentdao);
			getMultipleStudents(studentdao);
			findByLastName(studentdao);
		};
	}

	private void findByLastName(StudentDAO studentdao) {
		String lastName = "Kenger";
		List<Student> received =studentdao.findByLastName(lastName);
		for (Student student : received) {
			System.out.println("Student Found " + student.getLastName());
		}
	}

	private List<Student> getMultipleStudents(StudentDAO studentdao) {
		
		List<Student> students =studentdao.retrieveStudents();
		for (Student student : students) {
			System.out.println("Student Found " + student.getLastName());
		}
		return students;
		
	}

	private void findStudent(StudentDAO studentdao) {
		int id = 1;
		Student aStudent = studentdao.find(id);
		System.out.println("Student Found " + aStudent.getFirstName());
		
	}

	private void createStudent(StudentDAO studentdao) {
		//Student tempStudent = new Student("Hasan","Kenger","hskenger@gmail.com");
		//studentdao.save(tempStudent);
		
	}
	

}
