package cs489.apsd.lab9.service;

import cs489.apsd.lab9.dto.address.AddressResponse2;
import cs489.apsd.lab9.model.Address;

import java.util.List;

public interface AddressService {
    List<AddressResponse2> getAllAddress();
    Address addNewAddress(Address address);
}
