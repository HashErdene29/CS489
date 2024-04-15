package cs489.apsd.lab6.dto.patient;

import cs489.apsd.lab6.dto.address.AddressResponse;

public record PatientResponse2 (
        Integer id,
        String firstName,
        String lastName,
        String phoneNumber,
        String email,
        String dateOfBirth
){
}
