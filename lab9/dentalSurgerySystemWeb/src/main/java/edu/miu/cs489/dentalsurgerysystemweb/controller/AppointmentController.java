package edu.miu.cs489.dentalsurgerysystemweb.controller;

import edu.miu.cs489.dentalsurgerysystemweb.dto.request.AppointmentRequest;
import edu.miu.cs489.dentalsurgerysystemweb.model.Appointment;
import edu.miu.cs489.dentalsurgerysystemweb.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/adsweb/api/v1/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointment() {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }

    @PostMapping
    public ResponseEntity<Appointment> addNewAppointment(@RequestBody AppointmentRequest appointmentRequest) {
        return ResponseEntity.ok(appointmentService.addNewAppointment(appointmentRequest));
    }
}
