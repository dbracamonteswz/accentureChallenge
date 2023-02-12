package com.mx.accenture.springmvc.example.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.mx.accenture.springmvc.example.model.Course;
import com.mx.accenture.springmvc.example.model.Student;

public class StudentDto {
	
private int id;
    private String name;
    List<Course> enrrolledCourses;
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Course> getEnrrolledCourses() {
		return enrrolledCourses;
	}
	public void setEnrrolledCourses(List<Course> enrrolledCourses) {
		this.enrrolledCourses = enrrolledCourses;
	}

}
