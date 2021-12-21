package com.vn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vn.entity.Student;
import com.vn.repository.StudentRepository;

@RequestMapping("/students")
@RestController
public class StudentController {
	@Autowired
	private StudentRepository studentRepository;

	@RequestMapping(value = "", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<Student> getStudents() {
		List<Student> list = studentRepository.findAll();
		return list;
	}

	@RequestMapping(value = "/{id}", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public Student getStudent(@PathVariable("studentId") int id) {
		return studentRepository.getById(id);
	}

	@RequestMapping(value = "", //
			method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public Student addStudent(@RequestBody Student student) {

		System.out.println("(Service Side) Creating Student: " + student.getId());

		return studentRepository.save(student);
	}

	@RequestMapping(value = "", //
			method = RequestMethod.PUT, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public Student updateStudent(@RequestBody Student student) {

		System.out.println("(Service Side) Editing Student: " + student.getId());

		return studentRepository.save(student);
	}

	@RequestMapping(value = "/{id}", //
			method = RequestMethod.DELETE, //
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public void deleteStudent(@PathVariable("id") int id) {

		System.out.println("(Service Side) Deleting Student: " + id);

		studentRepository.deleteById(id);
	}
}