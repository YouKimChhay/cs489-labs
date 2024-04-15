package edu.miu.cs489.dentalsurgerysystemweb.repository;

import edu.miu.cs489.dentalsurgerysystemweb.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> getPatientsByFirstNameContainingOrLastNameContainingOrPhoneContainingOrEmailContaining(String firstName,
                                                                                                           String lastName,
                                                                                                           String phone,
                                                                                                           String email);

}
