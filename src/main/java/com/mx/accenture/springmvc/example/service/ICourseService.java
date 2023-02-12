package com.mx.accenture.springmvc.example.service;

import com.mx.accenture.springmvc.example.dto.CourseDTO;
import java.util.List;
import java.util.Optional;

public interface ICourseService {

    public List<CourseDTO> listCourse();

    public void deleteCourse(Integer idCourse);
    
    public Optional<CourseDTO> findCourseById(Integer idCourse);
    
    public CourseDTO addCourse(CourseDTO courseDTO);
    
    public CourseDTO updateCourse(CourseDTO courseDTO);
}