package com.rvmagrini.springdatajpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rvmagrini.springdatajpa.course.Course;

@SpringBootTest
class CourseRepositoryTest {
	
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	@Test
	public void printCourses() {
		List<Course> courses = courseRepository.findAll();
		
		System.out.println("===== Courses: " + courses);
	}

}
