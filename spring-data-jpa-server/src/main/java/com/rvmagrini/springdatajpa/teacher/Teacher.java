package com.rvmagrini.springdatajpa.teacher;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.rvmagrini.springdatajpa.course.Course;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {
	
	@Id
	@SequenceGenerator(
			name = "teacher_sequence",
			sequenceName = "teacher_sequence",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "teacher_sequence"
			)
	private Long teacherId;
	private String firstName;
	private String lastName;
	
	
	
	// JPA Specification Guidance: go for MANY TO ONE if possible
	// Rather than defining that one teacher could lecture a list of courses, we should go for setting
	// many courses available that could be set to any one of the teachers: 
	// We should implement the reverse (MANY TO ONE) inside Course Class.
	/* 
	// Defining OneToMany relationship between Teacher and Course:
	// A teacher can lecture many courses
	@OneToMany(cascade = CascadeType.ALL)
	// Create an extra column in Course Table indicating the Teacher who is lecturing it
	@JoinColumn(
			name = "teacher_id",
			referencedColumnName = "teacherId")
	private List<Course> courses;
	*/

}
