package com.mx.accenture.springmvc.example.service;

import java.util.List;
import java.util.Optional;

import com.mx.accenture.springmvc.example.model.Student;

public interface IStudentService {

	List<Student> listAllStudents();
	
	Optional<Student> findStudentById(Integer id);
	
	Student addStudent(Student student);
	
	Student updateStudent(Student student);
	
	void deleteStudent(Integer id);
}
