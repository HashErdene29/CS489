package cs489.apsd.lab11_2.service;

import cs489.apsd.lab11_2.dto.address.AddressResponse2;
import cs489.apsd.lab11_2.model.Address;

import java.util.List;

public interface AddressService {
    List<AddressResponse2> getAllAddress();
    Address addNewAddress(Address address);
}
