package edu.miu.cs489.dentalsurgerysystemweb.repository;

import edu.miu.cs489.dentalsurgerysystemweb.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
