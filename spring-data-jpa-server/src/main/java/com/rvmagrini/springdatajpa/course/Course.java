package com.rvmagrini.springdatajpa.course;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.rvmagrini.springdatajpa.teacher.Teacher;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {
	
	@Id
	@SequenceGenerator(
			name = "course_sequence",
			sequenceName = "course_sequence",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "course_sequence"
			)
	private Long courseId;
	private String title;
	private Integer credit;
	
	// Bi-Directional: mapping the join column created in CourseMaterial
	//'mapped by' tells that the OmysqneToOne relationship is already defined in CourseMaterial Class.
	@OneToOne(
			mappedBy = "course"
			)
	private CourseMaterial courseMaterial;
	
	// Many courses available that could be set to any one of the teachers
	@ManyToOne(
			cascade = CascadeType.ALL
			)
	@JoinColumn(
			name = "teacher_id",
			referencedColumnName = "teacherId"
			)
	private Teacher teacher;

}
