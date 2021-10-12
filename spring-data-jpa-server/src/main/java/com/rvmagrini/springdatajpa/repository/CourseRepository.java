package com.rvmagrini.springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rvmagrini.springdatajpa.course.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

	
}
