package ahmed.foudi.DocPat.entities;

import ahmed.foudi.DocPat.entities.enums.RequestStatus;
import ahmed.foudi.DocPat.entities.enums.RequestType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class PatientRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Appointment date is required")
    private LocalDate StartDate;
    @NotNull(message = "Appointment date is required")
    private LocalDate EndDate;



    private String notes;

    @Column(updatable = false)
    private LocalDate created_at;

    @Enumerated(EnumType.STRING)
    private RequestStatus status;

    @Enumerated(EnumType.STRING)
    private RequestType type;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    @NotNull(message = "Patient is required")
    private Patient patient;

    @ManyToOne
    @NotNull(message = "Agent is required")
    private Agent agent;

    @PrePersist
    protected void onCreate() {
        created_at = LocalDate.now();
        status = RequestStatus.NEW;
    }
}
