package edu.miu.cs489.dentalsurgerysystemweb.service;

import edu.miu.cs489.dentalsurgerysystemweb.dto.request.AppointmentRequest;
import edu.miu.cs489.dentalsurgerysystemweb.model.Appointment;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public interface AppointmentService {
    Appointment addNewAppointment(AppointmentRequest appointmentRequest);
    List<Appointment> getAllAppointments();
    Appointment getAppointmentById(Long id) throws EntityNotFoundException;
    Appointment updateAppointmentById(Long id, Appointment updatedAppointment);
    void deleteAppointmentById(Long id);
}
