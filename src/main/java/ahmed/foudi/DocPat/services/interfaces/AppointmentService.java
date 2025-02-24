package ahmed.foudi.DocPat.services.interfaces;

import ahmed.foudi.DocPat.dto.request.AppointmentRequest;
import ahmed.foudi.DocPat.dto.response.AppointmentResponse;

import java.util.List;

public interface AppointmentService {
    AppointmentResponse save(AppointmentRequest appointementRequest);
    List<AppointmentResponse> findAll();
    AppointmentResponse findById(Long id);
    void deleteById(Long id);
    List<AppointmentResponse> findByDoctorId(Long doctorId);
    List<AppointmentResponse> findByPatientId(Long patientId);
}
