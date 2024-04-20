package cs489.apsd.lab11_2.dto.patient;

import cs489.apsd.lab11_2.dto.address.AddressResponse;

public record PatientResponse (
        int id,
        String firstName,
        String lastName,
        String phoneNumber,
        String email,
        String dateOfBirth,
        AddressResponse primaryAddress
){
}
