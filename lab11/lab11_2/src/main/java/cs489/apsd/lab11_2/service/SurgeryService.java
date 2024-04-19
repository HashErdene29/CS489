package cs489.apsd.lab11_2.service;

import cs489.apsd.lab11_2.model.Surgery;

import java.util.List;

public interface SurgeryService {
    List<Surgery> getSurgeryList();
    Surgery getSurgeryById(String id);
    Surgery addSurgery(Surgery surgery);
    Surgery updateSurgery(Surgery surgery);
    void deleteSurgery(String id);

}
