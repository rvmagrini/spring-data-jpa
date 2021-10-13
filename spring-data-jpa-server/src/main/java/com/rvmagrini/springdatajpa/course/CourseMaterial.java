package com.rvmagrini.springdatajpa.course;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// If using FetchType LAZY, add: 
@ToString(exclude = "course")
public class CourseMaterial {
	
	@Id
	@SequenceGenerator(
			name = "course_material_sequence",
			sequenceName = "course_material_sequence",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "course_material_sequence"
			)
	private Long courseMaterialId;
	private String url;
	
	// JoinColumn: Adding one extra column to CourseMaterial table that refers to the course to which the
	// material belongs: adding the Primary Key of Course as a Foreign Key in CourseMaterial
	@JoinColumn(
			name = "course_id",
			referencedColumnName = "courseId"
			)
	// Cascade: allows CourseMaterialRepository to directly save a Course.
	// Fetch Type: defines if it should also retrieve data from the table related (Course) 
	// when the CourseMaterial is fetched. EAGER retrieve both; LAZY retrieve will retrieve Course 
	// only if you specify.
	@OneToOne(
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY
			)
	private Course course;

}
