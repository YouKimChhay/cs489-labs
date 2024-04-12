package edu.miu.cs489.dentalsurgerysystemweb.service.impl;

import edu.miu.cs489.dentalsurgerysystemweb.model.Patient;
import edu.miu.cs489.dentalsurgerysystemweb.repository.PatientRepository;
import edu.miu.cs489.dentalsurgerysystemweb.service.PatientService;
import lombok.RequiredArgsConstructor;
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
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Long id) {
        //check for a valid id
        return patientRepository.findById(id).get();
    }

    @Override
    public Patient updatePatientById(Long id, Patient updatedPatient) {
        //check for a valid id
        return patientRepository.save(updatedPatient);
    }

    @Override
    public void deletePatientById(Long id) {
        patientRepository.deleteById(id);
    }
}
