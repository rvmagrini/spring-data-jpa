package com.rvmagrini.springdatajpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rvmagrini.springdatajpa.course.Course;
import com.rvmagrini.springdatajpa.teacher.Teacher;

@SpringBootTest
class TeacherRepositoryTest {

	@Autowired
	private TeacherRepository teacherRepository;
	
	@Test
	public void saveTeacher() {
		
		// Jonas
		Course javaScriptCourse = 
				Course.builder()
				.title("JavaScript")
				.credit(5)
				.build();
		
		Course cssCourse = 
				Course.builder()
				.title("CSS")
				.credit(4)
				.build(); 
		
		Teacher jonas = 
				Teacher.builder()
				.firstName("Jonas")
				.lastName("Schmedtmann")
				.courses(List.of(javaScriptCourse, cssCourse))
				.build();
		
		teacherRepository.save(jonas);

		
		
		// Max
		Course reactCourse = 
				Course.builder()
				.title("React")
				.credit(6)
				.build();
		
		Course nodejsCourse = 
				Course.builder()
				.title("NodeJS")
				.credit(4)
				.build(); 
		
		Teacher max = 
				Teacher.builder()
				.firstName("Max")
				.lastName("Schwarzmüller")
				.courses(List.of(reactCourse, nodejsCourse))
				.build();
		
		teacherRepository.save(max);
		
	}

	

}
