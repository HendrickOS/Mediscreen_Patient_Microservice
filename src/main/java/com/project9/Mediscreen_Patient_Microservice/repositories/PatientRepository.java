package com.project9.Mediscreen_Patient_Microservice.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.project9.Mediscreen_Patient_Microservice.domain.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>, CrudRepository<Patient, Integer> {

	Patient findByLastname(String lastname);

	Optional<Patient> findById(Integer id);
//	Patient findById(Integer id);

	void deleteById(Integer id);

}
