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

import com.vn.entity.Teacher;
import com.vn.repository.TeacherRepository;

@RequestMapping("/teachers")
@RestController
public class TeacherController {
	@Autowired
	private TeacherRepository teacherRepository;

	@RequestMapping(value = "", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<Teacher> getTeachers() {
		List<Teacher> list = teacherRepository.findAll();
		return list;
	}

	@RequestMapping(value = "/{id}", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public Teacher getTeacher(@PathVariable("teacherId") int id) {
		return teacherRepository.getById(id);
	}

	@RequestMapping(value = "", //
			method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public Teacher addTeacher(@RequestBody Teacher teacher) {

		System.out.println("(Service Side) Creating Teacher: " + teacher.getId());

		return teacherRepository.save(teacher);
	}

	@RequestMapping(value = "", //
			method = RequestMethod.PUT, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public Teacher updateTeacher(@RequestBody Teacher teacher) {

		System.out.println("(Service Side) Editing Teacher: " + teacher.getId());

		return teacherRepository.save(teacher);
	}

	@RequestMapping(value = "/{id}", //
			method = RequestMethod.DELETE, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public void deleteTeacher(@PathVariable("id") int id) {

		System.out.println("(Service Side) Deleting Teacher: " + id);

		teacherRepository.deleteById(id);
	}
}