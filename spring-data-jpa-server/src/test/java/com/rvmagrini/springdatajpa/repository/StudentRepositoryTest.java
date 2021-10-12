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
		List<Student> studentsList = 
				studentRepository.findAll();
		
		System.out.println("===== Students: " + studentsList);
	}
	
	
	@Test
	public void printStudentsByFirstName() {
		List<Student> studentsByFirstName = studentRepository.findByFirstName("rob");
		
		System.out.println("===== Only first name Rob: " + studentsByFirstName);
		
	}
	
	
	@Test
	public void printStudentsByFirstNameContaining() {
		List<Student> studentsByFirstNameContaining = studentRepository.findByFirstNameContaining("st");
		
		System.out.println("===== First name containing 'st': " + studentsByFirstNameContaining);
	}
	
	
	@Test
	public void printStudentsByLastNameNotNull() {
		List<Student> studentsByLastNameNotNull = studentRepository.findByLastNameNotNull();
		
		System.out.println("===== Students with valid last name: " + studentsByLastNameNotNull);
	}
	
	
	@Test
	public void printStudentsByGuardianName() {
		List<Student> studentsByGuardianName = studentRepository.findByGuardianName("jose");
		
		System.out.println("===== Students by guardian jose: " + studentsByGuardianName);
	}
	
	
	@Test
	public void findByFirstAndLastName() {
		Student student = studentRepository.findByFirstNameAndLastName("rob", "nesta");
		
		System.out.println("===== Student rob + nesta: " + student);
	}
	
	
	// Passing Query (JPQL)
	@Test
	public void printStudentByEmailAddress() {
		Student student = studentRepository.getStudentByEmailAddress("rob@gmail.com");
		
		System.out.println("===== Get student by email address rob@gmail.com: " + student);
	}
	
	@Test
	public void printFirstNameByEmailAddress() {
		String studentFirstNameByEmailAddress = studentRepository.getStudentFirstNameByEmailAddress("steve@gmail.com");
		
		System.out.println("===== Print first name by email address steve@gmail.com: " + studentFirstNameByEmailAddress);
	}


}
