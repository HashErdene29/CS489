package cs489.apsd.lab6.service.impl;

import cs489.apsd.lab6.model.Patient;
import cs489.apsd.lab6.repository.PatientRepository;
import cs489.apsd.lab6.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(String patientId) {
        return patientRepository.findById(patientId).orElse(null);
    }

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Patient updatePatient) {
        return patientRepository.save(updatePatient);
    }

    @Override
    public void deletePatient(String patientId) {
        patientRepository.deleteById(patientId);
    }
}
