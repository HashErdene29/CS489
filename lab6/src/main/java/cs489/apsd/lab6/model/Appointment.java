package cs489.apsd.lab6.model;

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
    private Integer id;
    private String appointment_date;
    private String appointment_type;

    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Surgery surgery;
    @ManyToOne
    private Dentist dentist;

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
