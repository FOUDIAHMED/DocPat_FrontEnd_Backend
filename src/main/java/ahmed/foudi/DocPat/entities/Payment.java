package ahmed.foudi.DocPat.entities;

import ahmed.foudi.DocPat.entities.enums.PayementMethod;
import ahmed.foudi.DocPat.entities.enums.PayementStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Min(value = 0, message = "Amount cannot be negative")
    private double amount;

    private String transaction;

    @Column(updatable = false)
    private LocalDate created_at;

    @Enumerated(EnumType.STRING)
    private PayementStatus status;

    @Enumerated(EnumType.STRING)
    private PayementMethod method;

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
        status = PayementStatus.PENDING;
    }
}
