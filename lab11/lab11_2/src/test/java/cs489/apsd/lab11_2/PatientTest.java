package cs489.apsd.lab11_2;

import cs489.apsd.lab11_2.controller.PatientController;
import cs489.apsd.lab11_2.dto.address.AddressResponse;
import cs489.apsd.lab11_2.dto.patient.PatientResponse;
import cs489.apsd.lab11_2.exception.PatientNotFoundException;
import cs489.apsd.lab11_2.model.Address;
import cs489.apsd.lab11_2.model.Patient;
import cs489.apsd.lab11_2.repository.PatientRepository;
import cs489.apsd.lab11_2.service.impl.PatientServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(value = MockitoJUnitRunner.class)
public class PatientTest {
    @Mock
    PatientRepository patientRepository;
    @Mock
    PatientController patientController;

    @InjectMocks
    PatientServiceImpl patientService;

    @Test
    public void findPatientByIdTest() throws PatientNotFoundException {
        int patientId = 23;
        Patient patient = new Patient();
        patient.setId(patientId);

        when(patientRepository.findById(patientId)).thenReturn(Optional.of(patient));
        PatientResponse foundPatient = patientService.getPatientById(patientId);

        assertNotNull(foundPatient);
        Assert.assertEquals(patientId, foundPatient.id());
    }

    @Test
    public void findAllPatientsTest() {
        AddressResponse add1 = new AddressResponse(1, "123 St", "Santa Fe", "NM", "87501", "US");
        AddressResponse add2 = new AddressResponse(2, "456 South", "Carolville", "IO", "52241", "US");
        AddressResponse add3 = new AddressResponse(3, "789 West", "Omaha", "NB", "68007", "US");

        PatientResponse pat1 = new PatientResponse(1, "Gillian", "White", "987-654-3210", "gillian.white@gmail.com", "01-Sep-1999", add1);
        PatientResponse pat2 = new PatientResponse(2, "Jill", "Bell", "431-231-5412", "jill.bell@gmail.com", "01-Oct-1999", add2);
        PatientResponse pat3 = new PatientResponse(3, "Ian", "MackKay", "902-231-5412", "ian.bmackey@gmail.com", "01-Oct-1999", add3);

        List<PatientResponse> patients = Arrays.asList(pat1, pat2, pat3);

        ResponseEntity<List<PatientResponse>> response = ResponseEntity.ok(patients);
        when(patientController.getPatients()).thenReturn(response);

        ResponseEntity<List<PatientResponse>> response1 = patientController.getPatients();
        Assert.assertEquals(patients, response1.getBody());
    }
}
