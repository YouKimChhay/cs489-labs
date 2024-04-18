package edu.miu.cs489.dentalsurgerysystemweb.repository;

import edu.miu.cs489.dentalsurgerysystemweb.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurgeryRepository extends JpaRepository<Surgery, Long> {
}
