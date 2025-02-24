package ahmed.foudi.DocPat.entities;

import ahmed.foudi.DocPat.entities.enums.AppRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor extends AppUser{
    @NotBlank(message = "License number is required")
    @Column(unique = true)
    private String licenceNumber;

    @Min(value = 0, message = "Years of experience cannot be negative")
    private int yearsOfExperience;

    @Min(value = 0, message = "Consultation fee cannot be negative")
    private double consultation;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Appointment> appointements;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Notification> notifications;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Payment> Payements;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Rating> ratings;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<MedicalReport> medicalReports;


}
