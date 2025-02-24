package ahmed.foudi.DocPat.dto.embedded;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RatingDto {
    private Long id;
    private int rating;
    private String comment;
    private LocalDate createdAt;
    private PatientDto patient;
    private DoctorDto doctor;
} 