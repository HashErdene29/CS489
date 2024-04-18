package cs489.apsd.lab7.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dentists")
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone_number;
    private String specilization;

    @OneToMany
    private List<Appointment> appointments;

    public Dentist(String first_name, String last_name, String email, String phone_number, String specilization, List<Appointment> appointments) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_number = phone_number;
        this.specilization = specilization;
        this.appointments = appointments;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Dentist{");
        sb.append("dentist_id=").append(id);
        sb.append(", first_name='").append(first_name).append('\'');
        sb.append(", last_name='").append(last_name).append('\'');
        sb.append(", phone_number='").append(phone_number).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", specilization='").append(specilization).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
