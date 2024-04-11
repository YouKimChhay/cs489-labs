package edu.miu.cs489.dentalsurgerysystem;

import edu.miu.cs489.dentalsurgerysystem.model.*;
import edu.miu.cs489.dentalsurgerysystem.service.AppointmentService;
import edu.miu.cs489.dentalsurgerysystem.service.DentistService;
import edu.miu.cs489.dentalsurgerysystem.service.PatientService;
import edu.miu.cs489.dentalsurgerysystem.service.SurgeryService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
@RequiredArgsConstructor
public class DentalSurgerySystemApplication implements CommandLineRunner {

	private final DentistService dentistService;
	private final PatientService patientService;
	private final SurgeryService surgeryService;
	private final AppointmentService appointmentService;

	public static void main(String[] args) {
		SpringApplication.run(DentalSurgerySystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("My Dental Surgery System");
		populateDentists();
		dentistService.getAllDentists().forEach(System.out::println);

//		Dentist d = new Dentist(null, "Mary", "Joe", "555-123-9986", "maryj@ads.com", "dental implant");
//		dentistService.addNewDentist(d);
//		d.setSpecialization("dental surgeon");
//		dentistService.updateDentistById(3L, d);

		populatePatients();
		patientService.getAllPatients().forEach(System.out::println);

		populateSurgeries();
		surgeryService.getAllSurgeries().forEach(System.out::println);

		populateAppointments();
		appointmentService.getAllAppointments().forEach(System.out::println);
	}

	private void populateDentists() {
		Dentist tony = Dentist.builder()
				.firstName("Tony").lastName("Smith")
				.phone("555-123-9988").email("tonys@ads.com")
				.specialization("dental implant")
				.build();
		dentistService.addNewDentist(tony);

		Dentist helen = Dentist.builder()
				.firstName("Helen").lastName("Pearson")
				.phone("555-123-9987").email("helenp@ads.com")
				.specialization("dental implant")
				.build();
		dentistService.addNewDentist(helen);

		Dentist robin = Dentist.builder()
				.firstName("Robin").lastName("Plevin")
				.phone("555-123-9986").email("robinp@ads.com")
				.specialization("dental implant")
				.build();
		dentistService.addNewDentist(robin);
	}

	private void populatePatients() {
		Patient gillian = Patient.builder()
				.firstName("Gillian").lastName("White")
				.phone("555-987-1234").email("gw@gmail.com")
				.dateOfBirth(LocalDate.of(1989, 12, 13))
				.address(new Address(null, "1000 N 4th St", "Fairfield", "IA", "52556"))
				.build();
		patientService.addNewPatient(gillian);

		Patient jill = Patient.builder()
				.firstName("Jill").lastName("Bell")
				.phone("555-987-4321").email("jb@gmail.com")
				.dateOfBirth(LocalDate.of(1990, 5, 15))
				.address(new Address(null, "900 N 4th St", "Fairfield", "IA", "52556"))
				.build();
		patientService.addNewPatient(jill);

		Patient ian = Patient.builder()
				.firstName("Ian").lastName("Mackay")
				.phone("555-987-1299").email("im@gmail.com")
				.dateOfBirth(LocalDate.of(1995, 3, 24))
				.address(new Address(null, "1000 N 6th St", "Fairfield", "IA", "52556"))
				.build();
		patientService.addNewPatient(ian);

		Patient john = Patient.builder()
				.firstName("John").lastName("Walker")
				.phone("555-987-4377").email("jw@gmail.com")
				.dateOfBirth(LocalDate.of(1990, 11, 11))
				.address(new Address(null, "1000 S 4th St", "Fairfield", "IA", "52556"))
				.build();
		patientService.addNewPatient(john);
	}

	private void populateSurgeries() {
		Surgery ads1 = Surgery.builder()
				.name("ADS 1")
				.phone("555-999-7070")
				.address(new Address(null, "1000 S 5th St", "Fairfield", "IA", "52556"))
				.build();
		surgeryService.addNewSurgery(ads1);

		Surgery ads2 = Surgery.builder()
				.name("ADS 2")
				.phone("555-999-7080")
				.address(new Address(null, "2701 W Burlington Ave", "Fairfield'", "IA", "52556"))
				.build();
		surgeryService.addNewSurgery(ads2);

		Surgery ads3 = Surgery.builder()
				.name("ADS 3")
				.phone("555-999-7090")
				.address(new Address(null, "1300 W Burlington Ave", "Fairfield'", "IA", "52556"))
				.build();
		surgeryService.addNewSurgery(ads3);
	}

	private void populateAppointments() {
		Dentist tony = dentistService.getDentistById(1L);
		Dentist helen = dentistService.getDentistById(2L);
		Dentist robin = dentistService.getDentistById(3L);

		Patient gillian = patientService.getPatientById(1L);
		Patient jill = patientService.getPatientById(2L);
		Patient ian = patientService.getPatientById(3L);
		Patient john = patientService.getPatientById(4L);

		Surgery ads1 = surgeryService.getSurgeryById(1L);
		Surgery ads2 = surgeryService.getSurgeryById(2L);
		Surgery ads3 = surgeryService.getSurgeryById(3L);

		Appointment a = Appointment.builder()
				.dateTime(LocalDateTime.of(2024, 9,13,10,00))
				.surgery(ads1)
				.dentist(tony)
				.patient(gillian)
				.build();
		appointmentService.addNewAppointment(a);

		Appointment b = Appointment.builder()
				.dateTime(LocalDateTime.of(2024, 9,13,12,00))
				.surgery(ads1)
				.dentist(tony)
				.patient(jill)
				.build();
		appointmentService.addNewAppointment(b);

		Appointment c = Appointment.builder()
				.dateTime(LocalDateTime.of(2024, 9,13,10,00))
				.surgery(ads2)
				.dentist(helen)
				.patient(ian)
				.build();
		appointmentService.addNewAppointment(c);

		Appointment d = Appointment.builder()
				.dateTime(LocalDateTime.of(2024, 9,14,14,00))
				.surgery(ads2)
				.dentist(helen)
				.patient(ian)
				.build();
		appointmentService.addNewAppointment(d);

		Appointment e = Appointment.builder()
				.dateTime(LocalDateTime.of(2024, 9,14,16,30))
				.surgery(ads1)
				.dentist(robin)
				.patient(jill)
				.build();
		appointmentService.addNewAppointment(e);

		Appointment f = Appointment.builder()
				.dateTime(LocalDateTime.of(2024, 9,15,18,00))
				.surgery(ads3)
				.dentist(robin)
				.patient(john)
				.build();
		appointmentService.addNewAppointment(f);
	}
}
