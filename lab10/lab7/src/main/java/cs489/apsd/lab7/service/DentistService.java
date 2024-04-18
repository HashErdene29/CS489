package cs489.apsd.lab7.service;

import cs489.apsd.lab7.model.Dentist;

import java.util.List;

public interface DentistService {
    List<Dentist> getDentists();
    Dentist getDentistById(Integer id);
    Dentist addDentist(Dentist dentist);
    Dentist updateDentist(Dentist dentist);
    void deleteDentist(Integer id);
}
