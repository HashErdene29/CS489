package cs489.apsd.lab9.service;

import cs489.apsd.lab9.dto.patient.PatientRequest;
import cs489.apsd.lab9.dto.patient.PatientResponse;
import cs489.apsd.lab9.exception.PatientNotFoundException;
import cs489.apsd.lab9.model.Patient;

import java.util.List;

public interface PatientService {
    List<PatientResponse> getPatients();
    PatientResponse getPatientById(Integer id) throws PatientNotFoundException;
    PatientResponse addPatient(PatientRequest patient);
    Patient updatePatient(Integer id, Patient patient);
    void deletePatient(Integer id);
    List<PatientResponse> searchPatient(String searchString);
}
