package ahmed.foudi.DocPat.services.interfaces;

import ahmed.foudi.DocPat.dto.response.DoctorResponse;
import ahmed.foudi.DocPat.entities.Doctor;

import java.util.List;

public interface DoctorService {
    DoctorResponse save(Doctor doctor);
    List<DoctorResponse> findAll();
    DoctorResponse findById(Long id);
    void deleteById(Long id);
    DoctorResponse findByEmail(String email);
}
