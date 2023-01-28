package com.project9.Mediscreen_Patient_Microservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.project9.Mediscreen_Patient_Microservice.domain.Patient;
import com.project9.Mediscreen_Patient_Microservice.repositories.PatientRepository;
import com.project9.Mediscreen_Patient_Microservice.services.PatientService;

@SpringBootTest
public class PatientServiceTest {

	@Autowired
	private PatientService patientServiceUnderTest;
	@MockBean
	private PatientRepository patientRepositoryMocked;

	private Patient patient1;
	private Patient patient2;
	private Patient patient3;
//	  private PatientDTO patientDTO1;
//	  private PatientDTO patientDTO2;
//	  private PatientDTO patientDTO3;

	@BeforeEach
	public void setUp() {
		patient1 = new Patient("lastname1", "firstname1", Date.valueOf("1965-01-01"), "M", null, null);
		patient2 = new Patient("lastname2", "firstname2", Date.valueOf("1965-01-02"), "F", null, null);
		patient3 = new Patient("lastname3", "firstname3", Date.valueOf("1965-01-03"), "M", null, null);
//	    patientDTO1 = new PatientDTO("lastname1", "firstname1", Date.valueOf("1965-01-01"), Gender.M, null, null);
//	    patientDTO2 = new PatientDTO("lastname2", "firstname2", Date.valueOf("1965-01-01"), Gender.M, null, null);
//	    patientDTO3 = new PatientDTO("lastname3", "firstname3", Date.valueOf("1965-01-01"), Gender.M, null, null);

	}

	@Test
	public void findAllTest() {
		List<Patient> givenPatients = new ArrayList<Patient>();
		givenPatients.add(patient1);
		givenPatients.add(patient2);
		givenPatients.add(patient3);
		when(patientRepositoryMocked.findAll()).thenReturn(givenPatients);
		List<Patient> result = patientServiceUnderTest.findAll();

		assertThat(result.get(0).getLastname()).isEqualTo("lastname1");
		assertThat(result.get(1).getLastname()).isEqualTo("lastname2");
		assertThat(result.get(2).getLastname()).isEqualTo("lastname3");
	}

	@Test
	public void findByIdTest() {
		Integer givenId = 1;
		when(patientRepositoryMocked.findById(givenId)).thenReturn(Optional.of(patient1));

		Patient result = patientServiceUnderTest.findById(givenId);

		assertThat(result).isEqualTo(patient1);
	}

	@Test
	public void findByLastnameTest() {
		String givenLastname = "lastname1";
		when(patientRepositoryMocked.findByLastname(givenLastname)).thenReturn((patient1));

		Patient result = patientServiceUnderTest.findByLastname(givenLastname);

		assertThat(result).isEqualTo(patient1);
	}

}
