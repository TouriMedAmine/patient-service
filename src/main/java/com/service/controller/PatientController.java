package com.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.entity.Patient;
import com.service.repository.PatientRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/patient")
public class PatientController {
	@Autowired
	public PatientRepository patientRepository;
	
	@PostMapping("/sauvegarder")
	public @ResponseBody Patient savePatient(@RequestBody Patient patient) {
		return patientRepository.save(patient);
	}
		
	
	@GetMapping("/{id}")
	public Patient trouverPatientParId(@PathVariable("id") Long id) {
		return patientRepository.findById(id).orElse(null);
	}
	
	@GetMapping("/cin/{cin}")
	public Patient trouverPatientParId(@PathVariable("cin") String cin) {
		return patientRepository.chercherPatientParCIN(cin);
	}
	
	
	
}
