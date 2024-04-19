package cs489.apsd.lab11_2.service;

import cs489.apsd.lab11_2.model.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment> getAppointments();
    Appointment addAppointment(Appointment appointment);
    Appointment updateAppointment(Appointment appointment);
    Appointment getAppointment(Integer id);
    void deleteAppointment(Integer id);

}
