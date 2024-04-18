package cs489.apsd.lab7.repository;

import cs489.apsd.lab7.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurgeryRepository extends JpaRepository<Surgery, String> {
}
