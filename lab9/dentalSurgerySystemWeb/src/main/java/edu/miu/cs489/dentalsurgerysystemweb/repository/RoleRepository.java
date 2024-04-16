package edu.miu.cs489.dentalsurgerysystemweb.repository;

import edu.miu.cs489.dentalsurgerysystemweb.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> getRoleByName(String roleName);
}
