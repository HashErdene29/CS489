package cs489.apsd.lab11_2.repository;

import cs489.apsd.lab11_2.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurgeryRepository extends JpaRepository<Surgery, String> {
}
