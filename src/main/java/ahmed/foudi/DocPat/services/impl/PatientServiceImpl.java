package ahmed.foudi.DocPat.services.impl;

import ahmed.foudi.DocPat.dto.response.PatientResponse;
import ahmed.foudi.DocPat.entities.Patient;
import ahmed.foudi.DocPat.mappers.PatientMapper;
import ahmed.foudi.DocPat.dao.PatientRepository;
import ahmed.foudi.DocPat.services.interfaces.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    @Override
    public PatientResponse save(Patient patient) {
        return patientMapper.toResponse(patientRepository.save(patient));
    }

    @Override
    public List<PatientResponse> findAll() {
        return patientMapper.toResponseList(patientRepository.findAll());
    }

    @Override
    public PatientResponse findById(Long id) {
        return patientMapper.toResponse(patientRepository.findById(id).orElse(null));
    }

    @Override
    public void deleteById(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public PatientResponse findByEmail(String email) {
        return patientMapper.toResponse(patientRepository.findByEmail(email).get()) ;
    }
} 