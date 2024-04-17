package cs489.apsd.lab9.repository;

import cs489.apsd.lab9.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurgeryRepository extends JpaRepository<Surgery, String> {
}
