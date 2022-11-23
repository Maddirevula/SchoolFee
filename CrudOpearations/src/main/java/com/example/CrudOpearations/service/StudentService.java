package com.example.CrudOpearations.service;

import java.util.List;
import java.util.Optional;

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
			System.err.println("error : " + e);
			return null;

		}

	}

	public List<Student> getAllStudRec() {
		return studentRepository.findAll();

	}

	public Optional<Student> getStudById(String id) {
		return studentRepository.findById(id);

	}

	public String deleteStudByID(String id) {
		try {

			if (studentRepository.existsById(id)) {
				studentRepository.deleteById(id);

				System.out.println("Record deleted successfully!!!");
				return "Record deleted successfully!!!";

			} else {

				System.out.println("Record does not exist!!");
				return "Record does not exist!!";
			}
		} catch (Exception e) {
			// TODO: handle exception
			return e.toString();
		}

	}

	public String updateStudent(Student student) {
		try {

			if (studentRepository.existsById(student.getStudentId())) {
				studentRepository.save(student);
				return "record updated successfully";
			} else {
				return "Record not found";
			}

		} catch (Exception e) {
			return e.toString();
		}

	}

	public String updateStudentNameBYId(String studName, String studId) {
		try {

			if (studentRepository.existsById(studId)) {
				System.out.println("Inside service : updateStudentNameBYId()");
				studentRepository.updateStudById(studName, studId);// own method created in repository
				return "record updated successfully";
			} else {
				return "record not found";
			}
		} catch (Exception e) {

			return e.toString();
		}
	}
}
