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
	public List<Patient> patientsList(Model model) {
		return patientService.findAll();
	}

	@GetMapping("/patients/add")
	public String addPatient(Patient patient) {
		return "patient/add";
	}

	@PostMapping("/patients/validate")
	public String validate(@Valid Patient patient, BindingResult result, Model model) {
		if (!result.hasErrors()) {
			patientService.save(patient);
			return "redirect:/patients/list";
		}
		return "patient/add";
	}

	@GetMapping("/patients/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		Patient patient = patientService.findById(id);
		model.addAttribute("patient", patient);
		return "patient/update";
	}

	@PostMapping("/patients/update/{id}")
	public String updatePatient(@PathVariable("id") Integer id, @Valid Patient patient, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "patient/update";
		}
		patient.setId(id);
		patientService.save(patient);
		model.addAttribute("patient", patientService.findAll());
		return "redirect:/patients/list";
	}

	@GetMapping("/patients/delete/{id}")
	public String deletePatient(@PathVariable("id") Integer id, Model model) {
		Patient patient = patientService.findById(id);
		if (patient != null) {
			patientService.delete(patient);
		}
		model.addAttribute("patient", patientService.findAll());
		return "redirect:/patients/list";
	}

}
