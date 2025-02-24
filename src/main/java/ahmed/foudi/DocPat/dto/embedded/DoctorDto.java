package ahmed.foudi.DocPat.dto.embedded;

import lombok.Data;

@Data
public class DoctorDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String licenceNumber;
    private int yearsOfExperience;
    private double consultation;
} 