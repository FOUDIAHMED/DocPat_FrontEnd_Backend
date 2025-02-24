package ahmed.foudi.DocPat.dto.embedded;

import ahmed.foudi.DocPat.entities.enums.NotificationStatus;
import ahmed.foudi.DocPat.entities.enums.NotificationType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class NotificationDto {
    private Long id;
    private String message;
    private LocalDate created_at;
    private NotificationStatus status;
    private NotificationType type;
    private PatientDto patient;
    private DoctorDto doctor;
} 