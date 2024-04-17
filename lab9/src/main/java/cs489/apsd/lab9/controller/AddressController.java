package cs489.apsd.lab9.controller;

import cs489.apsd.lab9.dto.address.AddressResponse2;
import cs489.apsd.lab9.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ads/api/v1/address")
public class AddressController {
    private AddressService addressService;
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<AddressResponse2>> getAllAddresses() {
        return ResponseEntity.ok(addressService.getAllAddress());
    }


}
