package ahmed.foudi.DocPat.dto.embedded;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private String adresse;
    private String emergencyContact;
} 