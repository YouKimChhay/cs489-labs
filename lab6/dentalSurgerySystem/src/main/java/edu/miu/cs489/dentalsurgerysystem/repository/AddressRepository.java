package edu.miu.cs489.dentalsurgerysystem.repository;

import edu.miu.cs489.dentalsurgerysystem.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
