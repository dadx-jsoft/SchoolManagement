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

import com.vn.entity.Professional;
import com.vn.repository.ProfessionalRepository;

@RequestMapping("/professionals")
@RestController
public class ProfessionalController {
	@Autowired
	private ProfessionalRepository professionalRepository;

	@RequestMapping(value = "", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<Professional> getProfessionals() {
		List<Professional> list = professionalRepository.findAll();
		return list;
	}

	@RequestMapping(value = "/{id}", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public Professional getProfessional(@PathVariable("professionalId") int id) {
		return professionalRepository.getById(id);
	}

	@RequestMapping(value = "", //
			method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public Professional addProfessional(@RequestBody Professional professional) {

		System.out.println("(Service Side) Creating Professional: " + professional.getId());

		return professionalRepository.save(professional);
	}

	@RequestMapping(value = "", //
			method = RequestMethod.PUT, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public Professional updateProfessional(@RequestBody Professional professional) {

		System.out.println("(Service Side) Editing Professional: " + professional.getId());

		return professionalRepository.save(professional);
	}

	@RequestMapping(value = "/{id}", //
			method = RequestMethod.DELETE, //
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public void deleteProfessional(@PathVariable("id") int id) {

		System.out.println("(Service Side) Deleting Professional: " + id);

		professionalRepository.deleteById(id);
	}
}