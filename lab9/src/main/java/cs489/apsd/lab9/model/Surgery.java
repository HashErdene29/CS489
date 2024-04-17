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
@Table(name = "surgeries")
public class Surgery {
    @Id
    private String id;
    private String surgery_name;
    private String phone_number;
    private String surgery_date;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToMany
    private List<Appointment> appointments;

    public Surgery(String id, String surgery_name, String phone_number, String surgery_date, Address address) {
        this.id = id;
        this.surgery_name = surgery_name;
        this.phone_number = phone_number;
        this.surgery_date = surgery_date;
        this.address = address;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Surgery{");
        sb.append("surgery_id=").append(id);
        sb.append(", surgery_name='").append(surgery_name).append('\'');
        sb.append(", phone_number='").append(phone_number).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
