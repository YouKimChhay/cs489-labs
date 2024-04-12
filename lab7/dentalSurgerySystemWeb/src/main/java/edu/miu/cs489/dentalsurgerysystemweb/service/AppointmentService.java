package edu.miu.cs489.dentalsurgerysystemweb.service;

import edu.miu.cs489.dentalsurgerysystemweb.model.Appointment;

import java.util.List;

public interface AppointmentService {
    Appointment addNewAppointment(Appointment appointment);
    List<Appointment> getAllAppointments();
    Appointment getAppointmentById(Long id);
    Appointment updateAppointmentById(Long id, Appointment updatedAppointment);
    void deleteAppointmentById(Long id);
}
