package ahmed.foudi.DocPat.services.interfaces;

import ahmed.foudi.DocPat.dto.request.DoctorRequest;
import ahmed.foudi.DocPat.dto.request.LoginRequest;
import ahmed.foudi.DocPat.dto.request.PatientRequest;
import ahmed.foudi.DocPat.dto.response.AuthResponse;

public interface AuthService {
    AuthResponse login(LoginRequest request);
    AuthResponse registerDoctor(DoctorRequest request);
    AuthResponse registerPatient(PatientRequest request);
}
