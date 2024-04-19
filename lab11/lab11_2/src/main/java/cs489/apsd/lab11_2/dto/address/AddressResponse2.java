package cs489.apsd.lab11_2.dto.address;

import cs489.apsd.lab11_2.dto.patient.PatientResponse2;

public record AddressResponse2 (
        Integer addressId,
        String street,
        String city,
        String state,
        String postalcode,
        String country,
        PatientResponse2 patient
) {
}
