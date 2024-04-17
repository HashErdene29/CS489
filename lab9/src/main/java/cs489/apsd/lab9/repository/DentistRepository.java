package cs489.apsd.lab9.repository;

import cs489.apsd.lab9.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistRepository extends JpaRepository<Dentist, Integer> {
}
