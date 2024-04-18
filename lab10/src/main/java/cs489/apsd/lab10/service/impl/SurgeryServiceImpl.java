package cs489.apsd.lab10.service.impl;

import cs489.apsd.lab10.model.Surgery;
import cs489.apsd.lab10.repository.SurgeryRepository;
import cs489.apsd.lab10.service.SurgeryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurgeryServiceImpl implements SurgeryService {
    private SurgeryRepository surgeryRepository;

    public SurgeryServiceImpl(SurgeryRepository surgeryRepository) {
        this.surgeryRepository = surgeryRepository;
    }

    @Override
    public List<Surgery> getSurgeryList() {
        return surgeryRepository.findAll();
    }

    @Override
    public Surgery getSurgeryById(String id) {
        return surgeryRepository.findById(id).orElse(null);
    }

    @Override
    public Surgery addSurgery(Surgery surgery) {
        return surgeryRepository.save(surgery);
    }

    @Override
    public Surgery updateSurgery(Surgery update) {
        return surgeryRepository.save(update);
    }

    @Override
    public void deleteSurgery(String id) {
        surgeryRepository.deleteById(id);
    }

}
