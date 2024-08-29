package com.crud.spring.SERVICE;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.crud.spring.ENTITY.Student;
import com.crud.spring.REPOSITORY.StudentRepository;

@Service
public class StudentService {

	@Autowired
    private StudentRepository studentRepository;


    public Student createStudent(Student student){
     studentRepository.save(student);
       return student;
    }

  // @Cacheable(value = "student")
   //@Async("asyncExecutor")
    public List<Student> getAllStudents() {
    	
    	return studentRepository.findAll();
         
    }

    @Cacheable(value = "student", key="#id")
    public Student getStudentById(int id) {
    return studentRepository.findById(id).orElse(null);
    }
    
    
    public Student updateStudent(Student student1){
    	return studentRepository.save(student1);
        
    }

    public void deleteStudent(int id){
    studentRepository.deleteById(id);
	
    }
}
