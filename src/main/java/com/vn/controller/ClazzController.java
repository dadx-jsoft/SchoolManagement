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

import com.vn.entity.Clazz;
import com.vn.repository.ClazzRepositoty;

@RequestMapping("/classes")
@RestController
public class ClazzController {
	@Autowired
	private ClazzRepositoty clazzRepository;

	@RequestMapping(value = "", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<Clazz> getClazzs() {
		List<Clazz> list = clazzRepository.findAll();
		return list;
	}

	@RequestMapping(value = "/{id}", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public Clazz getClazz(@PathVariable("clazzId") int id) {
		return clazzRepository.getById(id);
	}

	@RequestMapping(value = "", //
			method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public Clazz addClazz(@RequestBody Clazz clazz) {

		System.out.println("(Service Side) Creating Clazz: " + clazz.getId());

		return clazzRepository.save(clazz);
	}

	@RequestMapping(value = "", //
			method = RequestMethod.PUT, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public Clazz updateClazz(@RequestBody Clazz clazz) {

		System.out.println("(Service Side) Editing Clazz: " + clazz.getId());

		return clazzRepository.save(clazz);
	}

	@RequestMapping(value = "/{id}", //
			method = RequestMethod.DELETE, //
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public void deleteClazz(@PathVariable("id") int id) {

		System.out.println("(Service Side) Deleting Clazz: " + id);

		clazzRepository.deleteById(id);
	}
}
