package cs489.apsd.lab6;

import cs489.apsd.lab6.model.*;
import cs489.apsd.lab6.repository.*;
import cs489.apsd.lab6.service.AddressService;
import cs489.apsd.lab6.service.PatientService;
import cs489.apsd.lab6.service.SurgeryService;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Lab6Application implements CommandLineRunner {
    private final PatientService patientService;
    private final AddressRepository addressRepository;
    private final PatientRepository patientRepository;
    private final DentistRepository dentistRepository;
    private final SurgeryRepository surgeryRepository;
    private final AppointmentRepository appointmentRepository;

    public Lab6Application(PatientService patientService, AddressRepository addressRepository, PatientRepository patientRepository, DentistRepository dentistRepository, SurgeryRepository surgeryRepository, AppointmentRepository appointmentRepository) {
        this.patientService = patientService;
        this.addressRepository = addressRepository;
        this.patientRepository = patientRepository;
        this.dentistRepository = dentistRepository;
        this.surgeryRepository = surgeryRepository;
        this.appointmentRepository = appointmentRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Lab6Application.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        System.out.println("Hello Data Persistence using Spring Data JPA");

        Address addr1 = new Address("123 Main St", "New York", "NY", "10001", "US");
        Address addr2 = new Address("456 Park Ave", "Los Angeles", "CA", "90001", "US");
        Address addr3 = new Address("789 Broadway", "Chicago", "IL", "60601", "US");
        Address addr4 = new Address("101 Elm St", "Houston", "TX", "77001", "US");
        Address addr5 = new Address("202 Cedar Ln", "Phoenix", "AZ", "85001", "US");
        Address addr6 = new Address("303 Pine Rd", "Philadelphia", "PA", "19101", "US");
        Address addr7 = new Address("404 Willow Ave", "San Antonio", "TX", "78201", "US");

        addressRepository.saveAll(Arrays.asList(addr1, addr2, addr3, addr4, addr5, addr6, addr7));

        Patient pat1 = new Patient("P100", "Gillian", "White", "987-654-3210", "gillian.white@gmail.com", "01-Sep-1999", addr1, null);
        Patient pat2 = new Patient("P105", "Jill", "Bell", "431-231-5412", "jill.bell@gmail.com", "01-Oct-1999", addr2, null);
        Patient pat3 = new Patient("P108", "Ian", "MackKay", "902-231-5412", "ian.bmackey@gmail.com", "01-Oct-1999", addr3, null);
        Patient pat4 = new Patient("P110", "John", "Walker", "202-431-5412", "john.walker@gmail.com", "01-Oct-1989", addr4, null);

        patientRepository.saveAll(Arrays.asList(pat1, pat2, pat3, pat4));

        Dentist dentist1 = new Dentist(1, "Tony", "Smith", "123-456-7890", "tony.smith@gmail.com", "Spec1", null);
        Dentist dentist2 = new Dentist(2, "Helen", "Pearson", "123-123-7890", "helen.pearson@gmail.com", "Spec2", null);
        Dentist dentist3 = new Dentist(3, "Robin", "Plevin", "123-789-7810", "robin.plevin@gmail.com", "Spec3", null);

        dentistRepository.saveAll(Arrays.asList(dentist1, dentist2, dentist3));

        Surgery surgery1 = new Surgery("S15", "Clinic One", "432-231-6809", "13-Mar-2024", addr5);
        Surgery surgery2 = new Surgery("S10", "Clinic Two", "432-231-6129", "28-Jun-2024", addr6);
        Surgery surgery3 = new Surgery("S13", "Clinic Three", "432-231-6309", "01-May-2014", addr7);

        surgeryRepository.saveAll(Arrays.asList(surgery1, surgery2, surgery3));


        Appointment app1 = new Appointment(1, "12-Sep-13 10:00", "Phone", pat1, surgery1, dentist1);
        Appointment app2 = new Appointment(2,"12-Sep-13 12:00", "Phone", pat2, surgery1, dentist1);
        Appointment app3 = new Appointment(3,"12-Sep-13 10:00", "Online", pat3, surgery2, dentist2);
        Appointment app4 = new Appointment(4,"14-Sep-13 14:00", "Phone", pat3, surgery2, dentist2);
        Appointment app5 = new Appointment(5,"14-Sep-13 16:30", "Online", pat2, surgery1, dentist3);
        Appointment app6 = new Appointment(6,"15-Sep-13 18:00", "Phone", pat4, surgery3, dentist3);

        appointmentRepository.saveAll(Arrays.asList(app1, app2, app3, app4, app5, app6));

        dentist1.setAppointments(Arrays.asList(app1, app2));
        dentist2.setAppointments(Arrays.asList(app3, app4));
        dentist3.setAppointments(Arrays.asList(app5, app6));

        pat1.setAppointments(Arrays.asList(app1));
        pat2.setAppointments(Arrays.asList(app2, app5));
        pat3.setAppointments(Arrays.asList(app3, app4));
        pat4.setAppointments(Arrays.asList(app6));

        surgery1.setAppointments(Arrays.asList(app1, app2, app5));
        surgery2.setAppointments(Arrays.asList(app3, app4));
        surgery3.setAppointments(Arrays.asList(app6));


        dentistRepository.saveAll(Arrays.asList(dentist1, dentist2, dentist3));
        patientRepository.saveAll(Arrays.asList(pat1, pat2, pat3, pat4));
        surgeryRepository.saveAll(Arrays.asList(surgery1, surgery2, surgery3));

        // PATIENT
        printAllPatient();
//        getPatient("P100");
//        updatePatient("P100");
//        patientService.deletePatient("P100");
    }

    private void printAllPatient(){
        patientService.getPatients().forEach(System.out::println);
    }

    private Patient getPatient(String id) {
        return patientService.getPatientById(id);
    }

    private Patient updatePatient(String id) {
        var patientFound = getPatient(id);
        if(patientFound != null) {
            patientFound.setFirst_name("Gillian updated");
            return patientService.updatePatient(patientFound);
        } else {
            return null;
        }
    }
}
