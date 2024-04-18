package cs489.apsd.lab10.repository;

import cs489.apsd.lab10.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}
