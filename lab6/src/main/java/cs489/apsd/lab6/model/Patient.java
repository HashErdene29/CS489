package cs489.apsd.lab6.model;

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
    private String id;

    private String first_name;
    private String last_name;
    private String phone_number;
    private String email;
    private String date_of_birth;

    @OneToOne
    private Address address;
    @OneToMany
    private List<Appointment> appointments;

//    public Patient(String id, String first_name, String last_name, String phone_number, String email, String date_of_birth, Address address) {
//        this.id = id;
//        this.first_name = first_name;
//        this.last_name = last_name;
//        this.phone_number = phone_number;
//        this.email = email;
//        this.date_of_birth = date_of_birth;
//        this.address = address;
//    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Patient{");
        sb.append("patient_id=").append(id);
        sb.append(", first_name='").append(first_name).append('\'');
        sb.append(", last_name='").append(last_name).append('\'');
        sb.append(", phone_number='").append(phone_number).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", date_of_birth='").append(date_of_birth).append('\'');
        sb.append(", address=").append(address).append('\'');
        sb.append(", appointments=").append(appointments);
        sb.append('}');
        return sb.toString();
    }
}
