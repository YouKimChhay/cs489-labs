package edu.miu.cs489.dentalsurgerysystemweb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentRequest {
    private LocalDateTime dateTime;
    private Long dentistId;
    private Long patientId;
    private Long surgeryId;
}
