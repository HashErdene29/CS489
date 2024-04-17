package cs489.apsd.lab9.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cs489.apsd.lab9.model.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
