package ahmed.foudi.DocPat.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class MedicalReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Prescription is required")
    private String prescription;

    private String testResults;

    private String notes;

    @Column(updatable = false)
    private LocalDate created_at;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    @NotNull(message = "Patient is required")
    private Patient patient;

    @ManyToOne
    @NotNull(message = "Doctor is required")
    private Agent agent;

    @PrePersist
    protected void onCreate() {
        created_at = LocalDate.now();
    }
}
