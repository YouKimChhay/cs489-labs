package edu.miu.cs489.dentalsurgerysystem.repository;

import edu.miu.cs489.dentalsurgerysystem.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
