package cs489.apsd.lab7.service;

import cs489.apsd.lab7.dto.address.AddressResponse2;
import cs489.apsd.lab7.model.Address;

import java.util.List;

public interface AddressService {
    List<AddressResponse2> getAllAddress();
    Address addNewAddress(Address address);
}
