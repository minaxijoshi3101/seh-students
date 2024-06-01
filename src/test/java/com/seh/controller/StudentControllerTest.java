package com.seh.controller;

import com.seh.model.Student;
import com.seh.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class StudentControllerTest {

    @Mock
    private StudentRepository studentRepo;

    @InjectMocks
    private StudentController studentController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testEnrollStudent() {
        // Arrange
        Student student = new Student();
        student.setStudent_name("John Doe");

        when(studentRepo.save(any(Student.class))).thenReturn(student);

        // Act
        Student result = studentController.enrollStudent(student);

        // Assert
        assertEquals(student.getStudent_name(), result.getStudent_name());
        verify(studentRepo, times(1)).save(student);
    }

    @Test
    void testGetAllEmployees() {
        // Arrange
        Student student1 = new Student();
        student1.setStudent_name("John Doe");

        Student student2 = new Student();
        student2.setStudent_name("Jane Doe");

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);

        when(studentRepo.findAll()).thenReturn(studentList);

        // Act
        ResponseEntity<List<Student>> response = studentController.getAllEmployees();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
        assertEquals(studentList, response.getBody());
        verify(studentRepo, times(1)).findAll();
    }
}
