package edu.miu.cs489.dentalsurgerysystemweb.repository;

import edu.miu.cs489.dentalsurgerysystemweb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> getUserByUsername(String username);
}
