package ahmed.foudi.DocPat.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MedicalReportRequest {
    @NotBlank(message = "Prescription is required")
    private String prescription;
    
    private String testResults;
    private String notes;

    @NotNull(message = "Patient ID is required")
    private Long patientId;

    @NotNull(message = "Doctor ID is required")
    private Long doctorId;
} 