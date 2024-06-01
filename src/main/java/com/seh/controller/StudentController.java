//Presentation Layer - controllers to accept the requests from the client
package com.seh.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.seh.model.Student;
import com.seh.repository.StudentRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/student")
//@RequestMapping("/api")
public class StudentController {
	@Autowired 
	StudentRepository studentRepo; 
	
	@PostMapping("/register")
    public Student enrollStudent(@RequestBody Student student)
    {
        studentRepo.save(student);
        return student;
    }
	
	//Get all the student details
	@GetMapping("/students")
	/*public String home() {
		return "welcome!!";
	}*/
	public ResponseEntity<List<Student>> getAllEmployees() {
		List<Student> studentList = new ArrayList<>();
		studentRepo.findAll().forEach(studentList::add);
		return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
	}

}
