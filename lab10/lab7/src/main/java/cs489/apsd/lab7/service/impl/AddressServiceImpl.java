package cs489.apsd.lab7.service.impl;

import cs489.apsd.lab7.dto.address.AddressResponse2;
import cs489.apsd.lab7.dto.patient.PatientResponse2;
import cs489.apsd.lab7.model.Address;
import cs489.apsd.lab7.model.Patient;
import cs489.apsd.lab7.repository.AddressRepository;
import cs489.apsd.lab7.repository.PatientRepository;
import cs489.apsd.lab7.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    private final PatientRepository patientRepository;
    private AddressRepository addressRepository;
    public AddressServiceImpl(AddressRepository addressRepository, PatientRepository patientRepository) {
        this.addressRepository = addressRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public Address addNewAddress(Address address) {return addressRepository.save(address);}

    @Override
    public List<AddressResponse2> getAllAddress() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(a -> new AddressResponse2(
                        a.getAddress().getId(),
                        a.getAddress().getStreet(),
                        a.getAddress().getCity(),
                        a.getAddress().getState(),
                        a.getAddress().getPostal_code(),
                        a.getAddress().getCountry(),
                        new PatientResponse2(
                                a.getId(),
                                a.getFirstName(),
                                a.getLastName(),
                                a.getPhoneNumber(),
                                a.getEmail(),
                                a.getDateOfBirth()
                        )
                ))
                .sorted(Comparator.comparing(AddressResponse2::city))
                .toList();
    }
}
