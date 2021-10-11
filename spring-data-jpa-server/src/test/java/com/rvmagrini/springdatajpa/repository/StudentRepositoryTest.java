package com.rvmagrini.springdatajpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rvmagrini.springdatajpa.student.Student;

@SpringBootTest
class StudentRepositoryTest {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	public void saveStudent() {
		Student student = Student.builder()
				.emailId("rob@gmail.com")
				.firstName("Rob")
				.lastName("Nesta")
				.guardianName("Jose")
				.guardianEmail("jose@gmail.com")
				.guardianMobile("0123456789")
				.build();
		
		studentRepository.save(student);
		
	}
	
	@Test
	public void printAllStudents() {
		List<Student> studentList = 
				studentRepository.findAll();
		
		System.out.println("Students: " + studentList);
	}


}
