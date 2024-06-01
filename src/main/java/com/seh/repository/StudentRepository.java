//DAO/Repository layer - connects to database tp get the data
package com.seh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.seh.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	//Student findByEmpcity(String emp_city);
	//Optional<List<Student>> findByEmpageGreaterThan(int emp_age);
	//Optional<Student> findOneByEmailAndPassword(String email, String password);
	//Student findByEmail(String email);
	//String enrollStudent(Student student);

}
