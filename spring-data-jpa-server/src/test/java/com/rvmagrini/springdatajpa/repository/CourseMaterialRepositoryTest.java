package com.rvmagrini.springdatajpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rvmagrini.springdatajpa.course.Course;
import com.rvmagrini.springdatajpa.course.CourseMaterial;

@SpringBootTest
class CourseMaterialRepositoryTest {

	@Autowired
	private CourseMaterialRepository courseMaterialRepository;
	
	
	// Testing Cascade
	// Optionally Course x Material
	@Test
	public void saveCourseMaterial() {
		
		Course course = 
				Course.builder()
				.title("Java")
				.credit(6)
				.build();
		
		CourseMaterial courseMaterial = 
				CourseMaterial.builder()
				.url("www.java.com")
				.course(course)
				.build();
		
		// To be able to save a yet non created Course when saving a CourseMaterial, we have to use cascade
		// in CourseMaterial Class, where we defined the JPA Relationship (OneToOne)
		courseMaterialRepository.save(courseMaterial);
				
	}
	
	
	// Testing Fetch Type
	@Test
	public void printAllCoursesMaterials() {
		List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
		
		System.out.println("===== CourseMaterials: " + courseMaterials);
	}
}
