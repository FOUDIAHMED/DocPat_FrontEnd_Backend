package ahmed.foudi.DocPat.dto.embedded;

import ahmed.foudi.DocPat.entities.enums.AppointementStatus;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AppointementDto {
    private Long id;
    private LocalDate appointementDate;
    private LocalDateTime appointementTime;
    private String notes;
    private AppointementStatus status;
    private PatientDto patient;
    private DoctorDto doctor;
} 