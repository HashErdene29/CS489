package cs489.apsd.lab10.service.impl;

import cs489.apsd.lab10.model.Appointment;
import cs489.apsd.lab10.repository.AppointmentRepository;
import cs489.apsd.lab10.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository repo){
        this.appointmentRepository = repo;
    }

    @Override
    public List<Appointment> getAppointments() {return appointmentRepository.findAll();}

    @Override
    public Appointment addAppointment(Appointment appointment) {return appointmentRepository.save(appointment);}

    @Override
    public Appointment getAppointment(Integer appointmentId) {
        return appointmentRepository.findById(appointmentId)
                .orElse(null);
    }

    @Override
    public Appointment updateAppointment(Appointment updateAppointment) {
        return appointmentRepository.save(updateAppointment);
    }

    @Override
    public void deleteAppointment(Integer appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }
}
