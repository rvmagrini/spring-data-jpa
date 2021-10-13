package com.rvmagrini.springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rvmagrini.springdatajpa.teacher.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
