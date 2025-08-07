package ahmed.foudi.DocPat.services.impl;

import ahmed.foudi.DocPat.dao.AppointmentRepository;
import ahmed.foudi.DocPat.dto.request.AppointmentRequest;
import ahmed.foudi.DocPat.dto.response.AppointmentResponse;
import ahmed.foudi.DocPat.entities.PatientRequest;
import ahmed.foudi.DocPat.mappers.AppointmentMapper;
import ahmed.foudi.DocPat.services.interfaces.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointementRepository;
    private final AppointmentMapper appointmentMapper;

    @Override
    public AppointmentResponse save(AppointmentRequest appointement) {
        PatientRequest appointment= appointmentMapper.toEntity(appointement);


        return appointmentMapper.toResponse( appointementRepository.save(appointment));
    }

    @Override
    public List<AppointmentResponse> findAll() {
        return appointmentMapper.toResponseList(appointementRepository.findAll()) ;
    }

    @Override
    public AppointmentResponse findById(Long id) {
        return appointmentMapper.toResponse(appointementRepository.findById(id).orElse(null));
    }

    @Override
    public void deleteById(Long id) {
        appointementRepository.deleteById(id);
    }

    @Override
    public List<AppointmentResponse> findByDoctorId(Long doctorId) {
        return appointmentMapper.toResponseList(appointementRepository.findAll().stream()
                .filter(a -> a.getAgent().getId().equals(doctorId))
                .toList()) ;
    }

    @Override
    public List<AppointmentResponse> findByPatientId(Long patientId) {
        return appointmentMapper.toResponseList(appointementRepository.findAll().stream()
                .filter(a -> a.getPatient().getId().equals(patientId))
                .toList()) ;
    }
}
