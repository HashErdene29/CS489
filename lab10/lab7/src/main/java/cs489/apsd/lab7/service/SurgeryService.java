package cs489.apsd.lab7.service;

import cs489.apsd.lab7.model.Surgery;

import java.util.List;

public interface SurgeryService {
    List<Surgery> getSurgeryList();
    Surgery getSurgeryById(String id);
    Surgery addSurgery(Surgery surgery);
    Surgery updateSurgery(Surgery surgery);
    void deleteSurgery(String id);

}
