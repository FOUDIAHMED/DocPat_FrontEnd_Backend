package ahmed.foudi.DocPat.dto.embedded;

import ahmed.foudi.DocPat.entities.enums.PayementMethod;
import ahmed.foudi.DocPat.entities.enums.PayementStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PaymentDto {
    private Long id;
    private double amount;
    private String transaction;
    private LocalDate created_at;
    private PayementStatus status;
    private PayementMethod method;
    private PatientDto patient;
    private DoctorDto doctor;
} 