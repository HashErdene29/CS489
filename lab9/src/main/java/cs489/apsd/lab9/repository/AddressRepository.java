package cs489.apsd.lab9.repository;

import cs489.apsd.lab9.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
