package cs489.apsd.lab6.repository;

import cs489.apsd.lab6.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    public List<Patient> findByFirstNameContainingOrLastNameContainingOrPhoneNumberContainingOrEmailContainingOrDateOfBirthContainingOrAddress_StreetContainingOrAddress_CityContainingOrAddress_StateContaining(
            String firstname, String lastname, String phonenumber, String email, String dateofbirth, String Street, String City, String State);

}
