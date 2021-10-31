package com.rvmagrini.springdatajpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.rvmagrini.springdatajpa.course.Course;
import com.rvmagrini.springdatajpa.teacher.Teacher;

@SpringBootTest
class CourseRepositoryTest {

	@Autowired
	private CourseRepository courseRepository;
	

	Teacher tim = Teacher.builder().firstName("Tim").lastName("Buchalka").build();

	Teacher jonas = Teacher.builder().firstName("Jonas").lastName("Schmedtmann").build();

	Teacher nelson = Teacher.builder().firstName("Nelson").lastName("Jamal").build();

	Teacher max = Teacher.builder().firstName("Max").lastName("Schwarzmüller").build();

	
	// Testing ManyToOne Course x Teacher
	@Test
	public void saveJavaCourseWithTeacher() {
		Course java = Course.builder().title("Java").credit(7).teacher(tim).build();
		courseRepository.save(java);
	}

	@Test
	public void saveTDDCourseWithTeacher() {
		Course tdd = Course.builder().title("TDD").credit(7).teacher(tim).build();
		courseRepository.save(tdd);
	}
	
	@Test
	public void saveJSCourseWithTeacher() {
		Course javaScriptCourse = Course.builder().title("JavaScript").credit(7).teacher(jonas).build();
		courseRepository.save(javaScriptCourse);
	}
	
	@Test
	public void saveCSSCourseWithTeacher() {
		Course cssCourse = Course.builder().title("CSS").credit(3).teacher(jonas).build();
		courseRepository.save(cssCourse);
	}
	
	@Test
	public void saveReactCourseWithTeacher() {
		Course react = Course.builder().title("React").credit(5).teacher(max).build();
		courseRepository.save(react);
	}
	
	@Test
	public void saveAngularCourseWithTeacher() {
		Course angular = Course.builder().title("Angular").credit(3).teacher(max).build();
		courseRepository.save(angular);
	}
	
	@Test
	public void saveSpringCourseWithTeacher() {
		Course springData = Course.builder().title("Spring Data").credit(5).teacher(nelson).build();
		courseRepository.save(springData);
	}
		
	@Test
	public void saveGitCourseWithTeacher() {
		Course git = Course.builder().title("Git").credit(3).teacher(nelson).build();
		courseRepository.save(git);
	}

	@Test
	public void saveTermCourseWithTeacher() {
		Course terminal = Course.builder().title("Terminal").credit(3).teacher(nelson).build();
		courseRepository.save(terminal);
	}


	@Test
	public void printCourses() {
		List<Course> courses = courseRepository.findAll();
		System.out.println("===== Courses: " + courses);
	}
	

	// Paging and Sorting
	@Test
	public void firstPageWithThreeRecords() {
		Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);

		List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();

		long totalElements = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();

		int totalPages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();

		System.out.println("===== Pagination firstPageWithThreeRecords: " + courses);
		System.out.println("===== Pagination Elements: " + totalElements);
		System.out.println("===== Pagination Pages: " + totalPages);
	}
	
	@Test
	public void secondPageWithTwoRecords() {
		Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);

		List<Course> courses = courseRepository.findAll(secondPageWithTwoRecords).getContent();
		long totalElements = courseRepository.findAll(secondPageWithTwoRecords).getTotalElements();
		int totalPages = courseRepository.findAll(secondPageWithTwoRecords).getTotalPages();

		System.out.println("===== Pagination secondPageWithTwoRecords: " + courses);
		System.out.println("===== Pagination Elements: " + totalElements);
		System.out.println("===== Pagination Pages: " + totalPages);
	}
	
	@Test
	public void findAndSortByTitle() {
		Pageable sortByTitle = 
				PageRequest.of(0, 5, Sort.by("title"));
		
		List<Course> courses = 
				courseRepository.findAll(sortByTitle).getContent();
		System.out.println("===== findAndSortByTitle: " + courses);
	}
	
	@Test
	public void findAndSortByCreditDesc() {
		
		Pageable sortByCreditDesc = 
				PageRequest.of(0, 5, Sort.by("credit").descending());
		
		List<Course> courses = 
				courseRepository.findAll(sortByCreditDesc).getContent();
		System.out.println("===== findAndSortByCreditDesc: " + courses);
	}
	
	@Test
	public void findAndSortByTitleAndCreditDesc() {
		
		Pageable sortByTitleAndCreditDesc = 
				PageRequest.of(0, 5, Sort.by("title")
						.and(Sort.by("credit")));
		
		List<Course> courses = 
				courseRepository.findAll(sortByTitleAndCreditDesc).getContent();
		System.out.println("===== findAndSortByTitleAndCreditDesc: " + courses);
	}
	
	
	@Test
	public void printPageFindByTitleContaining() {
		Pageable firstPageTenRecords = 
				PageRequest.of(0, 10);
		
		List<Course> courses = 
				courseRepository.findByTitleContaining("t", firstPageTenRecords).getContent();
		
		System.out.println("===== printPageFindByTitleContaining: " + courses);
	}

}
