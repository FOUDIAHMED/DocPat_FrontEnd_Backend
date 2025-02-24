package ahmed.foudi.DocPat.services.impl;

import ahmed.foudi.DocPat.dto.response.DoctorResponse;
import ahmed.foudi.DocPat.entities.Doctor;
import ahmed.foudi.DocPat.mappers.DoctorMapper;
import ahmed.foudi.DocPat.dao.DoctorRepository;
import ahmed.foudi.DocPat.services.interfaces.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    
    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    @Override
    public DoctorResponse save(Doctor doctor) {
        return doctorMapper.toResponse(doctorRepository.save(doctor));
    }

    @Override
    public List<DoctorResponse> findAll() {
        return doctorMapper.toResponseList(doctorRepository.findAll());
    }

    @Override
    public DoctorResponse findById(Long id) {
        return doctorMapper.toResponse(doctorRepository.findById(id).orElse(null));
    }

    @Override
    public void deleteById(Long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public DoctorResponse findByEmail(String email) {
        return doctorMapper.toResponse(doctorRepository.findByEmail(email).get());
    }
} 