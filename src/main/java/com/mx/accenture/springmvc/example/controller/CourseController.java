package com.mx.accenture.springmvc.example.controller;

import com.mx.accenture.springmvc.example.dto.CourseDTO;
import com.mx.accenture.springmvc.example.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @GetMapping("/list")
    public List<CourseDTO> listCourse(Model model){
        List<CourseDTO> listRepository = courseService.listCourse();
        return listRepository;
    }

    @GetMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> listCourseById(@PathVariable Integer id){
        Optional<CourseDTO> courseDTO = courseService.findCourseById(id);
        
        return new ResponseEntity<>(courseDTO.isPresent() ? courseDTO.get() : null, courseDTO.isPresent() ?  HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
    
   @PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
    public CourseDTO addCourse(@RequestBody CourseDTO course){
        return courseService.addCourse(course);
    }
   
   @PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
   public CourseDTO updateCourse(@RequestBody CourseDTO course){
       
	   return courseService.updateCourse(course);
   }
}
