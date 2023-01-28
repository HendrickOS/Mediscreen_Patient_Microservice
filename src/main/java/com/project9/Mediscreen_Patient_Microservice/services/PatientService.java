package com.project9.Mediscreen_Patient_Microservice.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project9.Mediscreen_Patient_Microservice.domain.Patient;

@Service
public interface PatientService {

	Patient save(Patient patient);

	List<Patient> findAll();

	Patient findByLastname(String lastname);

	int ageOfPatient(String lastname);

	Patient findById(Integer id);

	void delete(Patient patient);

}
