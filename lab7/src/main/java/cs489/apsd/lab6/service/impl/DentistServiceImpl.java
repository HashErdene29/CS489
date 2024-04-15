package cs489.apsd.lab6.service.impl;

import cs489.apsd.lab6.model.Dentist;
import cs489.apsd.lab6.repository.DentistRepository;
import cs489.apsd.lab6.service.DentistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistServiceImpl implements DentistService {
    private DentistRepository dentistRepository;

    public DentistServiceImpl(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    @Override
    public Dentist addDentist(Dentist dentist) {
        return dentistRepository.save(dentist);
    }

    @Override
    public List<Dentist> getDentists() {
        return dentistRepository.findAll();
    }

    @Override
    public Dentist updateDentist(Dentist updateDentist) {
        return dentistRepository.save(updateDentist);
    }

    @Override
    public Dentist getDentistById(Integer dentistId) {
        return dentistRepository.findById(dentistId).orElse(null);
    }

    @Override
    public void deleteDentist(Integer dentistId) {
        dentistRepository.deleteById(dentistId);
    }

}
