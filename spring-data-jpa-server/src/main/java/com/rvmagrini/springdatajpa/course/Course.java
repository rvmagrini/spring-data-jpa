package com.rvmagrini.springdatajpa.course;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.rvmagrini.springdatajpa.student.Student;
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
	//'mapped by' tells that the OneToOne relationship is already defined in CourseMaterial Class.
	@OneToOne(
			mappedBy = "course"
			)
	private CourseMaterial courseMaterial;
	
	// Many courses available that could be set to any one of the teachers
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(
			name = "teacher_id",
			referencedColumnName = "teacherId"
			)
	private Teacher teacher;
	
	// Joining new Table with many Students and many Courses
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "student_course",
			joinColumns = @JoinColumn(
					name = "course_id",
					referencedColumnName = "courseId"
					),
			inverseJoinColumns = @JoinColumn(
					name = "student_id",
					referencedColumnName = "studentId"
					)
			)
	private List<Student> students;
	
	
	public void addStudent(Student student) {
		if (students == null) {
			students = new ArrayList<>();
		}
		
		students.add(student);
	}

}
