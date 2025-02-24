package ahmed.foudi.DocPat.dto.request;

import ahmed.foudi.DocPat.entities.enums.NotificationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NotificationRequest {
    @NotBlank(message = "Message is required")
    private String message;
    
    @NotNull(message = "Notification type is required")
    private NotificationType type;

    @NotNull(message = "Patient ID is required")
    private Long patientId;

    @NotNull(message = "Doctor ID is required")
    private Long doctorId;
} 