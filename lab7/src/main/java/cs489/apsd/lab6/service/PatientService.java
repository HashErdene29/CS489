package cs489.apsd.lab6.service;

import cs489.apsd.lab6.dto.patient.PatientRequest;
import cs489.apsd.lab6.dto.patient.PatientResponse;
import cs489.apsd.lab6.exception.PatientNotFoundException;
import cs489.apsd.lab6.model.Patient;

import java.util.List;

public interface PatientService {
    List<PatientResponse> getPatients();
    PatientResponse getPatientById(Integer id) throws PatientNotFoundException;
    PatientResponse addPatient(PatientRequest patient);
    Patient updatePatient(Integer id, Patient patient);
    void deletePatient(Integer id);
    List<PatientResponse> searchPatient(String searchString);
}
