package cs489.apsd.lab11_2.repository;

import cs489.apsd.lab11_2.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
