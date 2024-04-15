package edu.miu.cs489.dentalsurgerysystemweb.controller;

import edu.miu.cs489.dentalsurgerysystemweb.dto.MessageResponse;
import edu.miu.cs489.dentalsurgerysystemweb.exception.IdMismatchException;
import edu.miu.cs489.dentalsurgerysystemweb.model.Patient;
import edu.miu.cs489.dentalsurgerysystemweb.service.PatientService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/adsweb/api/v1/patients")
public class PatientController {

    private final PatientService patientService;

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients(@RequestParam(defaultValue = "lastName") String sortBy, @RequestParam(defaultValue = "") String searchString) {
        if (searchString != null || !searchString.isEmpty())
            return ResponseEntity.ok(patientService.searchPatients(searchString));
        return ResponseEntity.ok(patientService.getAllPatients(sortBy));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) throws EntityNotFoundException {
        return ResponseEntity.ok(patientService.getPatientById(id));
    }

    @PostMapping
    public ResponseEntity<Patient> addNewPatient(@RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.addNewPatient(patient));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatientById(@PathVariable Long id, @RequestBody Patient updatePatient) throws
            EntityNotFoundException, IdMismatchException {
        return ResponseEntity.ok(patientService.updatePatientById(id, updatePatient));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deletePatientById(@PathVariable Long id) {
        patientService.deletePatientById(id);
        return ResponseEntity.ok(new MessageResponse("Success"));
    }

    @GetMapping("/addresses")
    public ResponseEntity<List<Patient>> getAllPatientsAddress(@RequestParam(defaultValue = "city") String sortBy) {
        return ResponseEntity.ok(patientService.getAllPatientsAddress(sortBy));
    }
}
