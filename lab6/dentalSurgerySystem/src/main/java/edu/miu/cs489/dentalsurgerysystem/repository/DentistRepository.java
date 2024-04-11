package edu.miu.cs489.dentalsurgerysystem.repository;

import edu.miu.cs489.dentalsurgerysystem.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DentistRepository extends JpaRepository<Dentist, Long> {
}
