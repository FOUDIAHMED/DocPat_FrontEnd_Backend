package ahmed.foudi.DocPat.dto.response;

import ahmed.foudi.DocPat.entities.enums.AppRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    private String token;
    private String email;
    private String firstName;
    private String lastName;
    private AppRole role;
    private Long id;
} 