package com.example.CrudOpearations.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CrudOpearations.Model.Student;
import com.example.CrudOpearations.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController 
{
	@Autowired
	private StudentService Service;
	
	@PostMapping("/add")
	public Student addStudent(@RequestBody Student student)
	{
		System.out.println("Inside Controller");
		System.out.println("student : "+student);
		return Service.saveStudent(student);
		
	}
	
	

}
