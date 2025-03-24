package ahmed.foudi.DocPat.dto.request;

import ahmed.foudi.DocPat.entities.enums.MedicalSpecialty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data

public class DoctorRequest {
    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;
    private String profilePicture;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Invalid phone number format")
    private String phoneNumber;

    @NotNull(message = "Speciality is required it should be GENERAL_MEDICINE,   // General Medicine\n" +
            "    CARDIOLOGY,         // Cardiology (Heart)\n" +
            "    DERMATOLOGY,        // Dermatology (Skin)\n" +
            "    PEDIATRICS,         // Pediatrics (Children)\n" +
            "    GYNECOLOGY,         // Gynecology (Women's Health)\n" +
            "    ORTHOPEDICS,        // Orthopedics (Bones and Joints)\n" +
            "    PSYCHIATRY,         // Psychiatry (Mental Health)\n" +
            "    OPHTHALMOLOGY,      // Ophthalmology (Eyes)\n" +
            "    ENT,                // ENT (Ear, Nose, and Throat)\n" +
            "    NEUROLOGY ")
    private MedicalSpecialty medicalSpecialty;

    @NotBlank(message = "License number is required")
    private String licenceNumber;

    private int yearsOfExperience;

    @NotNull(message = "Consultation fee is required")
    private double consultation;
} 