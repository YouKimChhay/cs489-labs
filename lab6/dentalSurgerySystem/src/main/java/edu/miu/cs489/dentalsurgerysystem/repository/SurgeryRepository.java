package edu.miu.cs489.dentalsurgerysystem.repository;

import edu.miu.cs489.dentalsurgerysystem.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SurgeryRepository extends JpaRepository<Surgery, Long> {
}
