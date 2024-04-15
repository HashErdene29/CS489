package cs489.apsd.lab6.service.impl;

import cs489.apsd.lab6.dto.address.AddressResponse;
import cs489.apsd.lab6.dto.patient.PatientRequest;
import cs489.apsd.lab6.dto.patient.PatientResponse;
import cs489.apsd.lab6.exception.PatientNotFoundException;
import cs489.apsd.lab6.model.Address;
import cs489.apsd.lab6.model.Patient;
import cs489.apsd.lab6.repository.PatientRepository;
import cs489.apsd.lab6.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<PatientResponse> getPatients() {
        return patientRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Patient::getLastName))
                .map(a -> new PatientResponse(
                        a.getId(),
                        a.getFirstName(),
                        a.getLastName(),
                        a.getPhoneNumber(),
                        a.getEmail(),
                        a.getDateOfBirth(),
                        (a.getAddress()!= null)?new AddressResponse(
                                a.getAddress().getId(),
                                a.getAddress().getStreet(),
                                a.getAddress().getCity(),
                                a.getAddress().getState(),
                                a.getAddress().getPostal_code(),
                                a.getAddress().getCountry()
                        ): null
                )).toList();
    }

    @Override
    public PatientResponse getPatientById(Integer patientId) throws PatientNotFoundException {
        Patient patient =  patientRepository.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException(String.format("Error: Patient with Id, %d, is not found",
                patientId)));
        return new PatientResponse(
                patient.getId(),
                patient.getFirstName(),
                patient.getLastName(),
                patient.getPhoneNumber(),
                patient.getEmail(),
                patient.getDateOfBirth(),
                (patient.getAddress()!= null)?new AddressResponse(
                        patient.getAddress().getId(),
                        patient.getAddress().getStreet(),
                        patient.getAddress().getCity(),
                        patient.getAddress().getState(),
                        patient.getAddress().getPostal_code(),
                        patient.getAddress().getCountry()
                ): null
        );
    }

    @Override
    public PatientResponse addPatient(PatientRequest patient) {
        var newPatient = new Patient(
                patient.firstName(),
                patient.lastName(),
                patient.phoneNumber(),
                patient.email(),
                patient.dateOfBirth(), new Address(
                    patient.primaryAddress().street(),
                    patient.primaryAddress().city(),
                    patient.primaryAddress().state(),
                    patient.primaryAddress().postalcode(),
                    patient.primaryAddress().country()
                ) );
        var savedPatient =  patientRepository.save(newPatient);
        return new PatientResponse(
                savedPatient.getId(),
                savedPatient.getFirstName(),
                savedPatient.getLastName(),
                savedPatient.getPhoneNumber(),
                savedPatient.getEmail(),
                savedPatient.getDateOfBirth(),
                new AddressResponse(
                        savedPatient.getAddress().getId(),
                        savedPatient.getAddress().getStreet(),
                        savedPatient.getAddress().getCity(),
                        savedPatient.getAddress().getState(),
                        savedPatient.getAddress().getPostal_code(),
                        savedPatient.getAddress().getCountry()
                )
        );
    }

    @Override
    public Patient updatePatient(Integer id, Patient updatePatient) {
        var patient = patientRepository.findById(id).orElse(null);
        if(patient != null ) {
            patient.setFirstName(updatePatient.getFirstName());
            patient.setLastName(updatePatient.getLastName());
            patient.setPhoneNumber(updatePatient.getPhoneNumber());
            patient.setEmail(updatePatient.getEmail());
            patient.setDateOfBirth(updatePatient.getDateOfBirth());
            if(updatePatient.getAddress() != null) {
                var address = patient.getAddress();
                address.setStreet(updatePatient.getAddress().getStreet());
                address.setCity(updatePatient.getAddress().getCity());
                address.setState(updatePatient.getAddress().getState());
                address.setPostal_code(updatePatient.getAddress().getPostal_code());
                address.setCountry(updatePatient.getAddress().getCountry());
            } else {
                var newAddress = new Address();
                newAddress.setStreet(updatePatient.getAddress().getStreet());
                newAddress.setCity(updatePatient.getAddress().getCity());
                newAddress.setState(updatePatient.getAddress().getState());
                newAddress.setPostal_code(updatePatient.getAddress().getPostal_code());
                newAddress.setCountry(updatePatient.getAddress().getCountry());
                patient.setAddress(newAddress);
            }
            return patientRepository.save(patient);
        } else {
            return null;
        }
    }

    @Override
    public void deletePatient(Integer patientId) {
        patientRepository.deleteById(patientId);
    }

    @Override
    public List<PatientResponse> searchPatient(String searchString){
        List<Patient> patients = patientRepository.findByFirstNameContainingOrLastNameContainingOrPhoneNumberContainingOrEmailContainingOrDateOfBirthContainingOrAddress_StreetContainingOrAddress_CityContainingOrAddress_StateContaining(
                searchString, searchString, searchString, searchString, searchString, searchString, searchString, searchString);
        return patients.stream()
                .map(a -> new PatientResponse(
                        a.getId(),
                        a.getFirstName(),
                        a.getLastName(),
                        a.getPhoneNumber(),
                        a.getEmail(),
                        a.getDateOfBirth(),
                        (a.getAddress()!= null)?new AddressResponse(
                                a.getAddress().getId(),
                                a.getAddress().getStreet(),
                                a.getAddress().getCity(),
                                a.getAddress().getState(),
                                a.getAddress().getPostal_code(),
                                a.getAddress().getCountry()
                        ): null
                )).toList();
    }
}
