package com.project9.Mediscreen_Patient_Microservice.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project9.Mediscreen_Patient_Microservice.domain.Patient;
import com.project9.Mediscreen_Patient_Microservice.services.PatientService;

@RestController
public class PatientController {

	@Autowired
	PatientService patientService;

	@RequestMapping("/patients")
	public List<Patient> patientsList() {
		return patientService.findAll();
	}

	@GetMapping("/patients/{lastname}")
	public Patient patientByFullname(@PathVariable("lastname") String lastname) {
		return patientService.findByLastname(lastname);
	}

	@PostMapping("/patients/validate")
	public Patient validate(@Valid Patient patient) {
		return patientService.save(patient);
	}

	@GetMapping("/patients/update/{id}")
	public Patient showUpdateForm(@PathVariable("id") Integer id, Model model) {
		return patientService.findById(id);
	}

	@PostMapping("/patients/update/{id}")
	public Patient updatePatient(@PathVariable("id") Integer id, @Valid Patient patient, BindingResult result,
			Model model) {
		return patientService.save(patient);
	}

	@GetMapping("/patients/delete/{id}")
	public void deletePatient(@PathVariable("id") Integer id) {
		patientService.deleteById(id);
	}

}
