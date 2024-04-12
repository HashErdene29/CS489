package cs489.apsd.lab6.repository;

import cs489.apsd.lab6.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, String> {

}
