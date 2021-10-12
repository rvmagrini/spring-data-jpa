package com.rvmagrini.springdatajpa.course;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
	
	// Adding one extra column to CourseMaterial table that refers to the course to which the
	// material belongs: adding the primary key from Course as a foreign key in CourseMaterial
	@JoinColumn(
			name = "course_id",
			referencedColumnName = "courseId"
			)
	@OneToOne (
			cascade = CascadeType.ALL
			)
	private Course course;

}
