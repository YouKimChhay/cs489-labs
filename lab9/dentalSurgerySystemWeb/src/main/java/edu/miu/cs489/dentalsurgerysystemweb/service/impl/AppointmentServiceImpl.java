package edu.miu.cs489.dentalsurgerysystemweb.service.impl;

import edu.miu.cs489.dentalsurgerysystemweb.dto.request.AppointmentRequest;
import edu.miu.cs489.dentalsurgerysystemweb.model.Appointment;
import edu.miu.cs489.dentalsurgerysystemweb.repository.AppointmentRepository;
import edu.miu.cs489.dentalsurgerysystemweb.service.AppointmentService;
import edu.miu.cs489.dentalsurgerysystemweb.service.DentistService;
import edu.miu.cs489.dentalsurgerysystemweb.service.PatientService;
import edu.miu.cs489.dentalsurgerysystemweb.service.SurgeryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final DentistService dentistService;
    private final PatientService patientService;
    private final SurgeryService surgeryService;

    private final AppointmentRepository appointmentRepository;

    @Override
    public Appointment addNewAppointment(AppointmentRequest appointmentRequest) {
        Appointment appointment = Appointment.builder()
                .dateTime(appointmentRequest.getDateTime())
                .dentist(dentistService.getDentistById(appointmentRequest.getDentistId()))
                .patient(patientService.getPatientById(appointmentRequest.getPatientId()))
                .surgery(surgeryService.getSurgeryById(appointmentRequest.getSurgeryId()))
                .build();
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment getAppointmentById(Long id) throws EntityNotFoundException {
        return appointmentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Appointment id " + id + " not found"));
    }

    @Override
    public Appointment updateAppointmentById(Long id, Appointment updatedAppointment) {
        //check for a valid id
        return appointmentRepository.save(updatedAppointment);
    }

    @Override
    public void deleteAppointmentById(Long id) {
        appointmentRepository.deleteById(id);
    }
}
