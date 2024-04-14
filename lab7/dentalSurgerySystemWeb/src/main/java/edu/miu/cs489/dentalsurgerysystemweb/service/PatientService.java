package edu.miu.cs489.dentalsurgerysystemweb.service;

import edu.miu.cs489.dentalsurgerysystemweb.exception.IdMismatchException;
import edu.miu.cs489.dentalsurgerysystemweb.model.Patient;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public interface PatientService {
    Patient addNewPatient(Patient patient);
    List<Patient> getAllPatients(String sortBy);
    List<Patient> searchPatients(String searchString);
    Patient getPatientById(Long id) throws EntityNotFoundException;
    Patient updatePatientById(Long id, Patient updatedPatient) throws EntityNotFoundException, IdMismatchException;
    void deletePatientById(Long id);
    List<Patient> getAllPatientsAddress(String sortBy);
}
