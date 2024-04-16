package edu.miu.cs489.dentalsurgerysystemweb.repository;

import edu.miu.cs489.dentalsurgerysystemweb.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
