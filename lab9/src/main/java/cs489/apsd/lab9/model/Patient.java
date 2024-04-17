package cs489.apsd.lab9.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String dateOfBirth;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    @OneToMany
    private List<Appointment> appointments;

    public Patient(String first_name, String last_name, String phone_number, String email, String date_of_birth, Address address) {
        this.firstName = first_name;
        this.lastName = last_name;
        this.phoneNumber = phone_number;
        this.email = email;
        this.dateOfBirth = date_of_birth;
        this.address = address;
    }

}
