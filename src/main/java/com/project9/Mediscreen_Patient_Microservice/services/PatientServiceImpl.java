package com.project9.Mediscreen_Patient_Microservice.services;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project9.Mediscreen_Patient_Microservice.domain.Patient;
import com.project9.Mediscreen_Patient_Microservice.repositories.PatientRepository;

@Component
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientRepository patientRepository;

	@Override
	public Patient save(Patient patient) {
		return patientRepository.save(patient);
	}

	@Override
	public List<Patient> findAll() {
		List<Patient> result = new ArrayList<>();
		Iterable<Patient> findAll = patientRepository.findAll();
		for (Iterator<Patient> iterator = findAll.iterator(); iterator.hasNext();) {
			result.add(iterator.next());
		}
		return result;
	}

	@Override
	public Patient findByLastname(String lastname) {
		return patientRepository.findByLastname(lastname);
	}

	@Override
	public Patient findById(Integer id) {
		return patientRepository.findById(id).get();
	}

	@Override
	public void delete(Patient patient) {
		patientRepository.delete(patient);

	}

	@Override
	public void deleteById(Integer id) {
		patientRepository.deleteById(id);

	}

	@Override
	public int ageOfPatient(String lastname) {
		int age;
		Patient patient = findByLastname(lastname);
		age = Period.between(patient.getBirthdate().toLocalDate(), LocalDate.now()).getYears();
		return age;
	}

}
