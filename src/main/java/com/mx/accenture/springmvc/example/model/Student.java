package com.mx.accenture.springmvc.example.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "Student")
public class Student {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student")
    private int id;
    
    @Column(name = "name")
    private String name;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    		  name = "course_enrroll", 
    		  joinColumns = @JoinColumn(name = "id_student"), 
    		  inverseJoinColumns = @JoinColumn(name = "id_course"))
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
