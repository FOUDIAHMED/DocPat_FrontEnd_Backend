package ahmed.foudi.DocPat.dto.response;

import ahmed.foudi.DocPat.dto.embedded.DoctorDto;
import ahmed.foudi.DocPat.dto.embedded.PatientDto;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MedicalReportResponse {
    private Long id;
    private String prescription;
    private String testResults;
    private String notes;
    private LocalDate created_at;
    private PatientDto patient;
    private DoctorDto doctor;
} 