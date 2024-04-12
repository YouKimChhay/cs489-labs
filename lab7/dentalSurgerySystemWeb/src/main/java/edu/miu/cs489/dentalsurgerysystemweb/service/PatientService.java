package edu.miu.cs489.dentalsurgerysystemweb.service;

import edu.miu.cs489.dentalsurgerysystemweb.model.Patient;

import java.util.List;

public interface PatientService {
    Patient addNewPatient(Patient patient);
    List<Patient> getAllPatients();
    Patient getPatientById(Long id);
    Patient updatePatientById(Long id, Patient updatedPatient);
    void deletePatientById(Long id);
}
