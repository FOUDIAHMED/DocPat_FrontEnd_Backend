package ahmed.foudi.DocPat.entities;



import jakarta.persistence.*;

import java.time.LocalDate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import ahmed.foudi.DocPat.entities.enums.AppRole;




@MappedSuperclass
@Data
@RequiredArgsConstructor
@AllArgsConstructor

public abstract class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;


    private String address;

    private String profilePicture;

    @Email(message = "Invalid email format")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private AppRole appRole;

    private LocalDate created_at;
    private LocalDate updated_at;

    @PrePersist
    protected void onCreate() {
        created_at = LocalDate.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updated_at = LocalDate.now();
    }
}
