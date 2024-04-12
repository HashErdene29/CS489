package cs489.apsd.lab6.service.impl;

import cs489.apsd.lab6.model.Address;
import cs489.apsd.lab6.repository.AddressRepository;
import cs489.apsd.lab6.service.AddressService;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address addNewAddress(Address address) {return addressRepository.save(address);}
}
