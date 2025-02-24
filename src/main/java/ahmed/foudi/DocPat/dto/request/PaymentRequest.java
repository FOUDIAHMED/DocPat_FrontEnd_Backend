package ahmed.foudi.DocPat.dto.request;

import ahmed.foudi.DocPat.entities.enums.PayementMethod;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PaymentRequest {
    @Min(value = 0, message = "Amount cannot be negative")
    private double amount;
    
    private String transaction;

    @NotNull(message = "Payment method is required")
    private PayementMethod method;

    @NotNull(message = "Patient ID is required")
    private Long patientId;

    @NotNull(message = "Doctor ID is required")
    private Long doctorId;
} 