package com.example.CrudOpearations.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CrudOpearations.Model.Student;
import com.example.CrudOpearations.Repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	public Student saveStudent(Student student) {
		System.out.println("Inside Service");
		Student std = null;
		System.out.println("student : " + student);
		try {

			if (studentRepository.existsById(student.getStudentId())) {
				System.out.println("Record already exists");

			} else {
				std = studentRepository.save(student);
				System.out.println("Succssfully Inserted!!!!");
			}

			return std;

		} catch (Exception e) {
			System.err.println("error : "+e);
			return null;

		}

	}

}
