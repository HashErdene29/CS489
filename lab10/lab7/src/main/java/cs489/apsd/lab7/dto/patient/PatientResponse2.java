package cs489.apsd.lab7.dto.patient;

public record PatientResponse2 (
        Integer id,
        String firstName,
        String lastName,
        String phoneNumber,
        String email,
        String dateOfBirth
){
}
