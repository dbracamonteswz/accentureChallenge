package com.mx.accenture.springmvc.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mx.accenture.springmvc.example.model.Student;

@Repository
public interface StudentRepository extends JpaRepository <Student, Integer> {

}
