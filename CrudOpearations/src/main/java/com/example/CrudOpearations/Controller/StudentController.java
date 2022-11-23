package com.example.CrudOpearations.Controller;

import java.util.List;
import java.util.Optional;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CrudOpearations.Model.Student;
import com.example.CrudOpearations.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@PostMapping("/add")
	public Student addStudent(@RequestBody Student student) {
		System.out.println("Inside Controller");
		System.out.println("student : " + student);
		return studentService.saveStudent(student);

	}

	@GetMapping("/getAllStud")
	public List<Student> getAllStudents() {
		System.out.println("Inside Controller");

		return studentService.getAllStudRec();

	}

	@GetMapping("/getStud/{id}")
	public Optional<Student> getStudById(@PathVariable String id) {
		return studentService.getStudById(id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable String id) {
		return studentService.deleteStudByID(id);

	}

	@PutMapping("/update")
	public String updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);

	}

	@PutMapping("/updatename")
	public String updateStudById(@RequestBody JSONObject tempObj) {
		try {
			System.out.println("  tempObj :  " + tempObj.toString());

			String studName = (String) tempObj.get("studentName");
			String studId = (String) tempObj.get("studentId");
			System.out.println("studName : " + studName);
			System.out.println("studId : " + studId);
			return studentService.updateStudentNameBYId(studName, studId);

		} catch (Exception e) {
			return e.toString();
		}

	}
}
