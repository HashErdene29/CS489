package cs489.apsd.lab6.service;

import cs489.apsd.lab6.model.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> getPatients();
    Patient getPatientById(String id);
    Patient addPatient(Patient patient);
    Patient updatePatient(Patient patient);
    void deletePatient(String id);
}
