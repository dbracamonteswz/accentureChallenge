package com.mx.accenture.springmvc.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.accenture.springmvc.example.dao.StudentRepository;
import com.mx.accenture.springmvc.example.model.Student;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> listAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Optional<Student> findStudentById(Integer id) {
		return studentRepository.findById(id);
	}

	@Override
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student updateStudent(Student student) {
		Student preUpdateStudent = studentRepository.findById(student.getId()).get();
		preUpdateStudent.setName(student.getName());
		preUpdateStudent.setEnrrolledCourses(student.getEnrrolledCourses());
		
		
		
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudent(Integer id) {
		studentRepository.deleteById(id);
	}

	// listStudentCourses

}
