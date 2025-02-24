package ahmed.foudi.DocPat.services.interfaces;

import ahmed.foudi.DocPat.dto.response.MedicalReportResponse;
import ahmed.foudi.DocPat.entities.MedicalReport;

import java.util.List;

public interface MedicalReportService {
    MedicalReportResponse save(MedicalReport medicalReport);

    List<MedicalReportResponse> findAll();

    MedicalReportResponse findById(Long id);

    void deleteById(Long id);

    List<MedicalReportResponse> findByDoctorId(Long doctorId);

    List<MedicalReportResponse> findByPatientId(Long patientId);
}
