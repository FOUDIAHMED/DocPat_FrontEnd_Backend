package ahmed.foudi.DocPat.dto.response;

import ahmed.foudi.DocPat.dto.embedded.DoctorDto;
import ahmed.foudi.DocPat.dto.embedded.PatientDto;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RatingResponse {
    private Long id;
    private int rating;
    private String comment;
    private LocalDate createdAt;
    private PatientDto patient;
    private DoctorDto doctor;
} 