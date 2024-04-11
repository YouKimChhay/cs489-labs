package edu.miu.cs489.dentalsurgerysystem.service.impl;

import edu.miu.cs489.dentalsurgerysystem.model.Appointment;
import edu.miu.cs489.dentalsurgerysystem.repository.AppointmentRepository;
import edu.miu.cs489.dentalsurgerysystem.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Override
    public Appointment addNewAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        //check for a valid id
        return appointmentRepository.findById(id).get();
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
