package edu.miu.cs489.dentalsurgerysystemweb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private LocalDate dateOfBirth;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public void updatePatient(Patient updatedPatient) {
        setFirstName(updatedPatient.getFirstName());
        setLastName(updatedPatient.getLastName());
        setPhone(updatedPatient.getPhone());
        setEmail(updatedPatient.getEmail());
        setDateOfBirth(updatedPatient.getDateOfBirth());
        address.updateAddress(updatedPatient.getAddress());
    }
}
