package ahmed.foudi.DocPat.services.impl;

import ahmed.foudi.DocPat.dto.response.MedicalReportResponse;
import ahmed.foudi.DocPat.entities.MedicalReport;
import ahmed.foudi.DocPat.mappers.MedicalReportMapper;
import ahmed.foudi.DocPat.dao.MedicalReportRepository;
import ahmed.foudi.DocPat.services.interfaces.MedicalReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicalReportServiceImpl implements MedicalReportService {
    
    private final MedicalReportRepository medicalReportRepository;
    private final MedicalReportMapper medicalReportMapper;

    @Override
    public MedicalReportResponse save(MedicalReport medicalReport) {
        return medicalReportMapper.toResponse(medicalReportRepository.save(medicalReport));
    }

    @Override
    public List<MedicalReportResponse> findAll() {
        return medicalReportMapper.toResponseList(medicalReportRepository.findAll());
    }

    @Override
    public MedicalReportResponse findById(Long id) {
        return medicalReportMapper.toResponse(medicalReportRepository.findById(id).orElse(null));
    }

    @Override
    public void deleteById(Long id) {
        medicalReportRepository.deleteById(id);
    }

    @Override
    public List<MedicalReportResponse> findByDoctorId(Long doctorId) {
        return medicalReportMapper.toResponseList(medicalReportRepository.findAll().stream()
                .filter(m -> m.getDoctor().getId().equals(doctorId))
                .toList());
    }

    @Override
    public List<MedicalReportResponse> findByPatientId(Long patientId) {
        return medicalReportMapper.toResponseList(medicalReportRepository.findAll().stream()
                .filter(m -> m.getPatient().getId().equals(patientId))
                .toList());
    }
} 