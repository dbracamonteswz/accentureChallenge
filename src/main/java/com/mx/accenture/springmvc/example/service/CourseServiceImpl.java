package com.mx.accenture.springmvc.example.service;

import com.mx.accenture.springmvc.example.dao.CourseRepository;
import com.mx.accenture.springmvc.example.dto.CourseDTO;
import com.mx.accenture.springmvc.example.model.Course;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<CourseDTO> listCourse() {
        List<Course> cursos = courseRepository.findAll();
        List<CourseDTO> customersDTO=cursos.stream()
                .map((customer)-> mapCourseToCourseDTO(customer))
                .collect(Collectors.toList());
        return customersDTO;
    }

    @Override
    public void deleteCourse(Integer idCourse) {
        courseRepository.deleteById(idCourse);
    }

    private CourseDTO mapCourseToCourseDTO(Course course){
        CourseDTO filteredCustomer = new CourseDTO(course.getIdCourse(), course.getNameCourse(), course.getTypeCourse(),
                course.getNameTeacher(), course.getNumberStudents(), course.getNumberLessons());
        return filteredCustomer;
    }
    

    @Override
    public Optional<CourseDTO> findCourseById(Integer idCourse) {
        return courseRepository.findById(idCourse).map((customer)-> mapCourseToCourseDTO(customer));
    }
    
    @Override
    public CourseDTO addCourse(CourseDTO courseDTO) {
    	Course course = new Course();
    	BeanUtils.copyProperties(courseDTO, course);
    	course = courseRepository.save(course);
    	CourseDTO persistCourseDto = new CourseDTO();
    	BeanUtils.copyProperties(course, persistCourseDto);
        return persistCourseDto;
    }
    
    @Override
    public CourseDTO updateCourse(CourseDTO courseDTO) {
    	Course course = courseRepository.getById(courseDTO.getIdCourse());
    	course.setNameCourse(courseDTO.getNameCourse());
    	course.setNameTeacher(courseDTO.getNameTeacher());
    	course.setNumberLessons(course.getNumberLessons());
    	course.setNumberStudents(courseDTO.getNumberStudents());
    	course.setTypeCourse(courseDTO.getTypeCourse());
    	course = courseRepository.save(course);
    	CourseDTO persistedCourseDTO = new CourseDTO();
    	
    	BeanUtils.copyProperties(course, persistedCourseDTO);
        return persistedCourseDTO;
    }

}