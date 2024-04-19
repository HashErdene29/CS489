package cs489.apsd.lab11_2.repository;

import cs489.apsd.lab11_2.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}
