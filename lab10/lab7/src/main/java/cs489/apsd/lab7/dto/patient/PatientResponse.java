package cs489.apsd.lab7.dto.patient;

import cs489.apsd.lab7.dto.address.AddressResponse;

public record PatientResponse (
        Integer id,
        String firstName,
        String lastName,
        String phoneNumber,
        String email,
        String dateOfBirth,
        AddressResponse primaryAddress
){
}
