package edu.miu.cs489.dentalsurgerysystemweb.service.impl;

import edu.miu.cs489.dentalsurgerysystemweb.exception.IdMismatchException;
import edu.miu.cs489.dentalsurgerysystemweb.model.Patient;
import edu.miu.cs489.dentalsurgerysystemweb.repository.PatientRepository;
import edu.miu.cs489.dentalsurgerysystemweb.service.PatientService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public Patient addNewPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatients(String sortBy) {
        return patientRepository.findAll(Sort.by(sortBy));
    }

    @Override
    public List<Patient> searchPatients(String searchString) {
        return patientRepository.getPatientsByFirstNameContainingOrLastNameContainingOrPhoneContainingOrEmailContaining(
                searchString, searchString, searchString, searchString);
    }

    @Override
    public Patient getPatientById(Long id) throws EntityNotFoundException {
        return patientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Patient id " + id + " not found."));
    }

    @Override
    public Patient updatePatientById(Long id, Patient updatedPatient) throws EntityNotFoundException, IdMismatchException {
        if (updatedPatient.getId() != id)
            throw new IdMismatchException("Patient id mismatched.");

        Patient patient = getPatientById(id);
        if (patient.getAddress().getId() != updatedPatient.getAddress().getId())
            throw new IdMismatchException("Address id mismatched.");

        patient.updatePatient(updatedPatient);
        return patientRepository.save(patient);
    }

    @Override
    public void deletePatientById(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public List<Patient> getAllPatientsAddress(String sortBy) {
        return patientRepository.findAll(Sort.by("address." + sortBy));
    }
}
