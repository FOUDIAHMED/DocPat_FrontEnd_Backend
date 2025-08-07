package ahmed.foudi.DocPat.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating cannot be more than 5")
    private int rating;

    @Size(min = 10, message = "Comment must be at least 10 characters")
    private String comment;

    @Column(updatable = false)
    private LocalDate createdAt;

    @ManyToOne
    @NotNull(message = "Patient is required")
    private Patient patient;

    @ManyToOne
    @NotNull(message = "Doctor is required")
    private Agent doctor;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDate.now();
    }
}
