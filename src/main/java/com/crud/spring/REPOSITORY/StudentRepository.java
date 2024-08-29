package com.crud.spring.REPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.spring.ENTITY.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
