package edu.miu.cs489.dentalsurgerysystemweb.service;

import edu.miu.cs489.dentalsurgerysystemweb.model.Address;
import edu.miu.cs489.dentalsurgerysystemweb.model.Patient;
import edu.miu.cs489.dentalsurgerysystemweb.repository.PatientRepository;
import edu.miu.cs489.dentalsurgerysystemweb.service.impl.PatientServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PatientServiceTest {

    @Mock
    private PatientRepository patientRepository;
    private PatientService patientService;

    @BeforeEach
    void setUp() {
        patientService = new PatientServiceImpl(patientRepository);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGetPatientById() {
        Patient gillian = Patient.builder()
                .id(1L)
                .firstName("Gillian").lastName("White")
                .phone("555-987-1234").email("gw@gmail.com")
                .dateOfBirth(LocalDate.of(1989, 12, 13))
                .address(new Address(null, "123 Oak Street", "Springfield", "IL", "62701"))
                .build();
        when(patientRepository.findById(1L)).thenReturn(Optional.of(gillian));
        assertEquals(gillian, patientService.getPatientById(1L));

        verify(patientRepository, times(1)).findById(1L);
        verifyNoMoreInteractions(patientRepository);
    }

    @Test
    void testGetPatientByIdWithInvalidId() {
        when(patientRepository.findById(1L)).thenThrow(EntityNotFoundException.class);
        assertThrows(EntityNotFoundException.class, () -> patientService.getPatientById(1L));

        verify(patientRepository, times(1)).findById(1L);
        verifyNoMoreInteractions(patientRepository);
    }
}