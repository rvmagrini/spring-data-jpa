package com.rvmagrini.springdatajpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rvmagrini.springdatajpa.guardian.Guardian;
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
				// Embedded
				//.guardianName("Jose")
				//.guardianEmail("jose@gmail.com")
				//.guardianMobile("0123456789")
				.build();
		
		studentRepository.save(student);
		
	}
	
	@Test
	public void saveStudentWithGuardian() {
		
		Guardian guardian = Guardian.builder()
				.name("Jose")
				.email("jose@gmail.com")
				.mobilePhone("0123456789")
				.build();
		
		Student student = Student.builder()
				.firstName("Steve")
				.lastName("Johnson")
				.emailId("steve@gmail.com")
				.guardian(guardian)
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
