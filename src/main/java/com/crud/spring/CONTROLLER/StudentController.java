package com.crud.spring.CONTROLLER;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.spring.ENTITY.Student;
import com.crud.spring.SERVICE.StudentService;


@RestController
@RequestMapping("/api")
public class StudentController {

	 @Autowired
	  private StudentService studentService;

	    @GetMapping
	    public List<Student> getStudent() {
	        return studentService.getAllStudents();
	    }
	  @GetMapping("/std/{id}")  
	  public ResponseEntity<Student> getStudentById(@PathVariable int id) {
		 Student student = studentService.getStudentById(id);
		 
		 if(student==null) {
		return ResponseEntity.notFound().build();
		 }
		 return ResponseEntity.ok(student);
	  }
	    

	    @PostMapping
	    public Student createStudent(@RequestBody Student student){
	        return studentService.createStudent(student);
	    }

	    @PutMapping("/std/{id}")
	    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable int id)
	    {
	    Student student1 = studentService.getStudentById(id);	
	        if(student==null) {
	        	return ResponseEntity.notFound().build();	
	        }
	        student1.setFirstName(student.getFirstName());
	        student1.setLastName(student.getLastName());
	        student1.setCity(student.getCity());
	       Student updateStudent=studentService.updateStudent(student1);
	       return ResponseEntity.ok(updateStudent);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Student> deleteStudent(@PathVariable int id){
	    studentService.deleteStudent(id);
	  return new ResponseEntity<>(HttpStatus.OK);
	    	
	       
	    }

}
