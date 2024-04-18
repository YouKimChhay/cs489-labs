package edu.miu.cs489.dentalsurgerysystemweb.controller;

import edu.miu.cs489.dentalsurgerysystemweb.model.Address;
import edu.miu.cs489.dentalsurgerysystemweb.model.Patient;
import edu.miu.cs489.dentalsurgerysystemweb.service.PatientService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PatientControllerTest {

    @Mock
    private PatientService patientService;
    private PatientController patientController;

    @BeforeEach
    void setUp() {
        patientController = new PatientController(patientService);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllPatients() {
        Patient gillian = Patient.builder()
                .id(1L)
                .firstName("Gillian").lastName("White")
                .phone("555-987-1234").email("gw@gmail.com")
                .dateOfBirth(LocalDate.of(1989, 12, 13))
                .address(new Address(null, "123 Oak Street", "Springfield", "IL", "62701"))
                .build();

        Patient jill = Patient.builder()
                .id(2L)
                .firstName("Jill").lastName("Bell")
                .phone("555-987-4321").email("jb@gmail.com")
                .dateOfBirth(LocalDate.of(1990, 5, 15))
                .address(new Address(null, "456 Maple Avenue", "Denver", "CO", "80202"))
                .build();

        List<Patient> patients = List.of(jill, gillian);
        when(patientService.getAllPatients("lastName")).thenReturn(patients);

        ResponseEntity<List<Patient>> expected = ResponseEntity.ok(patients);
        assertEquals(expected, patientController.getAllPatients("lastName", ""));

        verify(patientService, times(1)).getAllPatients("lastName");
        verifyNoMoreInteractions(patientService);
    }
}