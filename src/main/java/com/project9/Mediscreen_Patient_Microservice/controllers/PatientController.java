package com.project9.Mediscreen_Patient_Microservice.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
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

//	@GetMapping("/patients/update/{id}")
//	public Patient showUpdateForm(@PathVariable("id") Integer id) {
//		return patientService.findById(id);
//		Patient patient = patientService.findById(id);
//		model.addAttribute("patient", patient);
//		return "patient/update";
//	}

	@PostMapping("/patients/update/{id}")
	public Patient updatePatient(@PathVariable("id") Integer id, @Valid Patient patient, BindingResult result,
			Model model) {
		return patientService.save(patient);
//		if (result.hasErrors()) {
//			return "patient/update";
//		}
//		patient.setId(id);
//		patientService.save(patient);
//		model.addAttribute("patient", patientService.findAll());
//		return "redirect:/patients/list";
	}

	@DeleteMapping("/patients/delete")
	public void deletePatient(@PathVariable("id") Integer id) {
		Patient patient = patientService.findById(id);
		patientService.delete(patient);

//		if (patient != null) {
//			patientService.delete(patient);
//		}
//		model.addAttribute("patient", patientService.findAll());
//		return "redirect:/patients/list";
	}

}
