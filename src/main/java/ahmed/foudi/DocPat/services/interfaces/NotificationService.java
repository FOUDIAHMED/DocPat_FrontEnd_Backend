package ahmed.foudi.DocPat.services.interfaces;

import ahmed.foudi.DocPat.dto.response.NotificationResponse;
import ahmed.foudi.DocPat.entities.Notification;

import java.util.List;

public interface NotificationService {
    NotificationResponse save(Notification notification);

    List<NotificationResponse> findAll();

    NotificationResponse findById(Long id);

    void deleteById(Long id);

    List<NotificationResponse> findByDoctorId(Long doctorId);

    List<NotificationResponse> findByPatientId(Long patientId);
}
