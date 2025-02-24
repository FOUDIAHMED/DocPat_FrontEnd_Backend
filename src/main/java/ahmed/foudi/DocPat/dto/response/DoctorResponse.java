package ahmed.foudi.DocPat.dto.response;

import ahmed.foudi.DocPat.dto.embedded.AppointementDto;
import ahmed.foudi.DocPat.dto.embedded.MedicalReportDto;
import ahmed.foudi.DocPat.dto.embedded.NotificationDto;
import ahmed.foudi.DocPat.dto.embedded.RatingDto;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class DoctorResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String licenceNumber;
    private int yearsOfExperience;
    private double consultation;
    private LocalDate created_at;
    private LocalDate updated_at;
    private List<AppointementDto> appointements;
    private List<NotificationDto> notifications;
    private List<RatingDto> ratings;
    private List<MedicalReportDto> medicalReports;
} 