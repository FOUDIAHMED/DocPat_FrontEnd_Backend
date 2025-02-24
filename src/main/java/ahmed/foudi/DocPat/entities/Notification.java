package ahmed.foudi.DocPat.entities;

import ahmed.foudi.DocPat.entities.enums.NotificationStatus;
import ahmed.foudi.DocPat.entities.enums.NotificationType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Message is required")
    private String message;

    @Column(updatable = false)
    private LocalDate created_at;

    @Enumerated(EnumType.STRING)
    private NotificationStatus status;

    @Enumerated(EnumType.STRING)
    private NotificationType type;

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
        status = NotificationStatus.UNREAD;
    }
}
