package com.mx.accenture.springmvc.example.controller;

import com.mx.accenture.springmvc.example.model.Student;
import com.mx.accenture.springmvc.example.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping
    public List<Student> listAllStudents(){
        List<Student> studentList = studentService.listAllStudents();
        return studentList;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Integer id){
    	studentService.deleteStudent(id);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> findStudentById(@PathVariable Integer id){

        return studentService.findStudentById(id)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
   @PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
    public Student addCourse(@RequestBody Student  student){
        return studentService.addStudent(student);
    }
   
   @PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
   public Student updateCourse(@RequestBody Student student){
       
	   return studentService.updateStudent(student);
   }
   
   @GetMapping("/{id}/courses")
   public ResponseEntity<?> getCoursesByStudentId(@PathVariable Integer id){
       Optional<Student> student = studentService.findStudentById(id);
       
       if(student.isEmpty()) {
    	   new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
       
       return new ResponseEntity<>(student.get().getEnrrolledCourses(),HttpStatus.OK);
   }
}
