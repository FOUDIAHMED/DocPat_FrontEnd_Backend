package ahmed.foudi.DocPat.services.interfaces;

import ahmed.foudi.DocPat.dto.response.PatientResponse;
import ahmed.foudi.DocPat.entities.Patient;

import java.util.List;

public interface PatientService {
    PatientResponse save(Patient patient);

    List<PatientResponse> findAll();

    PatientResponse findById(Long id);

    void deleteById(Long id);

    PatientResponse findByEmail(String email);
}
