package ahmed.foudi.DocPat.entities;

import ahmed.foudi.DocPat.entities.enums.AppointementStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Appointment date is required")

    private LocalDate appointementDate;

    @NotNull(message = "Appointment time is required")
    private LocalTime appointementTime;

    private String notes;

    @Column(updatable = false)
    private LocalDate created_at;

    @Enumerated(EnumType.STRING)
    private AppointementStatus status;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    @NotNull(message = "Patient is required")
    private Patient patient;

    @ManyToOne
    @NotNull(message = "Doctor is required")
    private Doctor doctor;

    @PrePersist
    protected void onCreate() {
        created_at = LocalDate.now();
        status = AppointementStatus.SCHEDULED;
    }
}
