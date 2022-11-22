package com.example.CrudOpearations.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CrudOpearations.Model.Student;



public interface StudentRepository extends JpaRepository<Student,String>
{
	
	
	

}
