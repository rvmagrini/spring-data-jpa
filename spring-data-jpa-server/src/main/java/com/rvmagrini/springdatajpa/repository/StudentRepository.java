package com.rvmagrini.springdatajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rvmagrini.springdatajpa.student.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	List<Student> findByFirstName(String firstName);
	
	List<Student> findByFirstNameContaining(String characters);
	
	List<Student> findByLastNameNotNull();
	
	List<Student> findByGuardianName(String guardianName);
	
	Student findByFirstNameAndLastName(String firstName, String lastName);
	
	
	// Passing JPA Query (JPQL): it is based on the classes we have created,
	// not on the Database table.
	@Query("SELECT s FROM Student s WHERE s.emailId = ?1")
	Student getStudentByEmailAddress(String emailId);
	
	@Query("SELECT s.firstName FROM Student s WHERE s.emailId = ?1")
	String getStudentFirstNameByEmailAddress(String emailId);
	
	
	// Native Query: for complex queries
	@Query(
			value = "SELECT * FROM students s WHERE s.email = ?1",
			nativeQuery = true
			)
	String getStudentByEmailAddressNative(String emailId);
	
	// Native Query using Named Param: best practice when we have to pass multiple parameters
	@Query(
			value = "SELECT * FROM students s WHERE s.email = :emailId",
			nativeQuery = true
			)
	String getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);
	

}