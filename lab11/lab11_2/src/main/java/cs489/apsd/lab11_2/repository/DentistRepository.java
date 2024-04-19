package cs489.apsd.lab11_2.repository;

import cs489.apsd.lab11_2.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistRepository extends JpaRepository<Dentist, Integer> {
}
