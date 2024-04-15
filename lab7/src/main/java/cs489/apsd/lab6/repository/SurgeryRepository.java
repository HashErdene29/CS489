package cs489.apsd.lab6.repository;

import cs489.apsd.lab6.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurgeryRepository extends JpaRepository<Surgery, String> {
}
