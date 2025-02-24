package ahmed.foudi.DocPat.services.impl;

import ahmed.foudi.DocPat.dto.response.NotificationResponse;
import ahmed.foudi.DocPat.entities.Notification;
import ahmed.foudi.DocPat.mappers.NotificationMapper;
import ahmed.foudi.DocPat.dao.NotificationRepository;
import ahmed.foudi.DocPat.services.interfaces.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    
    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;

    @Override
    public NotificationResponse save(Notification notification) {
        return notificationMapper.toResponse(notificationRepository.save(notification));
    }

    @Override
    public List<NotificationResponse> findAll() {
        return notificationMapper.toResponseList(notificationRepository.findAll());
    }

    @Override
    public NotificationResponse findById(Long id) {
        return notificationMapper.toResponse(notificationRepository.findById(id).orElse(null));
    }

    @Override
    public void deleteById(Long id) {
        notificationRepository.deleteById(id);
    }

    @Override
    public List<NotificationResponse> findByDoctorId(Long doctorId) {
        return notificationMapper.toResponseList(notificationRepository.findAll().stream()
                .filter(n -> n.getDoctor().getId().equals(doctorId))
                .toList());
    }

    @Override
    public List<NotificationResponse> findByPatientId(Long patientId) {
        return notificationMapper.toResponseList(notificationRepository.findAll().stream()
                .filter(n -> n.getPatient().getId().equals(patientId))
                .toList());
    }


} 