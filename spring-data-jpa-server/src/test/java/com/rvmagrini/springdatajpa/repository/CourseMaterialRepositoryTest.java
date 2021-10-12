package com.rvmagrini.springdatajpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rvmagrini.springdatajpa.course.Course;
import com.rvmagrini.springdatajpa.course.CourseMaterial;

@SpringBootTest
class CourseMaterialRepositoryTest {

	@Autowired
	private CourseMaterialRepository courseMaterialRepository;
	
	@Test
	public void saveCourseMaterial() {
		
		Course course = 
				Course.builder()
				.title("Java")
				.credit(6)
				.build();
		
		CourseMaterial courseMaterial = 
				CourseMaterial.builder()
				.url("www.javacourse.com")
				.course(course)
				.build();
		
		// To be able to save CourseMaterial without saving Course, we should implement Cascading
		courseMaterialRepository.save(courseMaterial);
				
	}
}
