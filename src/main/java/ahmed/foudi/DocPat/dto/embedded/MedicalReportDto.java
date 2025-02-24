package ahmed.foudi.DocPat.dto.embedded;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MedicalReportDto {
    private Long id;
    private String prescription;
    private String testResults;
    private String notes;
    private LocalDate created_at;
    private PatientDto patient;
    private DoctorDto doctor;
} 