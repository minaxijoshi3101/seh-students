package com.seh.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.seh.model.Student;
import com.seh.repository.StudentRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentRepository studentRepo;

    @PostMapping("/register")
    public Student enrollStudent(@RequestBody Student student) {

        logger.info("Received request to register student: {}", student);

        Student savedStudent = studentRepo.save(student);

        logger.info("Student registered successfully with ID: {}", savedStudent.getId());

        return savedStudent;
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllEmployees() {

        logger.info("Received request to fetch all students");

        List<Student> studentList = new ArrayList<>();
        studentRepo.findAll().forEach(studentList::add);

        logger.info("Returning {} students", studentList.size());

        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }
}
