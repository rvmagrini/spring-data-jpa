package com.rvmagrini.springdatajpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rvmagrini.springdatajpa.course.Course;
import com.rvmagrini.springdatajpa.course.CourseMaterial;
import com.rvmagrini.springdatajpa.teacher.Teacher;

@SpringBootTest
class CourseRepositoryTest {
	
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	@Test
	public void printCourses() {
		List<Course> courses = courseRepository.findAll();
		
		System.out.println("===== Courses: " + courses);
	}
	
	
	@Test
	public void saveCourseWithTeacher() {
		
		Teacher tim = 
				Teacher.builder()
				.firstName("Tim")
				.lastName("Buchalka")
				.build();
		
		Course java = 
				Course.builder()
				.title("Java")
				.credit(7)
				.teacher(tim)
				.build();
		
		courseRepository.save(java);
		
		
	}

}
