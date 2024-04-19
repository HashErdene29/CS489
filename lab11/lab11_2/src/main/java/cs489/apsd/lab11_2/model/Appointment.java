package cs489.apsd.lab11_2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String appointment_date;
    private String appointment_type;

    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Surgery surgery;
    @ManyToOne
    private Dentist dentist;

    public Appointment(String appointment_date, String appointment_type, Patient patient, Surgery surgery, Dentist dentist) {
        this.appointment_date = appointment_date;
        this.appointment_type = appointment_type;
        this.patient = patient;
        this.surgery = surgery;
        this.dentist = dentist;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id=").append(id);
        sb.append(", appointment_date='").append(appointment_date).append('\'');
        sb.append(", appointment_type='").append(appointment_type).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
