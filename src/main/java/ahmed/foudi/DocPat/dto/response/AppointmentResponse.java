package ahmed.foudi.DocPat.dto.response;

import ahmed.foudi.DocPat.dto.embedded.DoctorDto;
import ahmed.foudi.DocPat.dto.embedded.PatientDto;
import ahmed.foudi.DocPat.entities.enums.AppointementStatus;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AppointmentResponse {
    private Long id;
    private LocalDate appointementDate;
    private LocalTime appointementTime;
    private String notes;
    private LocalDate created_at;
    private AppointementStatus status;
    private PatientDto patient;
    private DoctorDto doctor;
} 