package ahmed.foudi.DocPat.services.impl;

import ahmed.foudi.DocPat.dao.AppointmentRepository;
import ahmed.foudi.DocPat.dto.request.AppointmentRequest;
import ahmed.foudi.DocPat.dto.response.AppointmentResponse;
import ahmed.foudi.DocPat.entities.Appointment;
import ahmed.foudi.DocPat.mappers.AppointmentMapper;
import ahmed.foudi.DocPat.services.interfaces.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointementRepository;
    private final AppointmentMapper appointementMapper;

    @Override
    public AppointmentResponse save(AppointmentRequest appointement) {
        Appointment appointment=appointementMapper.toEntity(appointement);
        appointment.setAppointementDate(LocalDate.now());
        appointment.setAppointementTime(LocalDateTime.now());

        return appointementMapper.toResponse( appointementRepository.save(appointment));
    }

    @Override
    public List<AppointmentResponse> findAll() {
        return appointementMapper.toResponseList(appointementRepository.findAll()) ;
    }

    @Override
    public AppointmentResponse findById(Long id) {
        return appointementMapper.toResponse(appointementRepository.findById(id).orElse(null));
    }

    @Override
    public void deleteById(Long id) {
        appointementRepository.deleteById(id);
    }

    @Override
    public List<AppointmentResponse> findByDoctorId(Long doctorId) {
        return appointementMapper.toResponseList(appointementRepository.findAll().stream()
                .filter(a -> a.getDoctor().getId().equals(doctorId))
                .toList()) ;
    }

    @Override
    public List<AppointmentResponse> findByPatientId(Long patientId) {
        return appointementMapper.toResponseList(appointementRepository.findAll().stream()
                .filter(a -> a.getPatient().getId().equals(patientId))
                .toList()) ;
    }
}
