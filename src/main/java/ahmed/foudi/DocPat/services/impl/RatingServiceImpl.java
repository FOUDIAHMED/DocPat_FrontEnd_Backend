package ahmed.foudi.DocPat.services.impl;

import ahmed.foudi.DocPat.dao.DoctorRepository;
import ahmed.foudi.DocPat.dao.PatientRepository;
import ahmed.foudi.DocPat.dto.request.RatingRequest;
import ahmed.foudi.DocPat.dto.response.RatingResponse;
import ahmed.foudi.DocPat.entities.Doctor;
import ahmed.foudi.DocPat.entities.Patient;
import ahmed.foudi.DocPat.entities.Rating;
import ahmed.foudi.DocPat.mappers.RatingMapper;
import ahmed.foudi.DocPat.dao.RatingRepository;
import ahmed.foudi.DocPat.services.interfaces.DoctorService;
import ahmed.foudi.DocPat.services.interfaces.PatientService;
import ahmed.foudi.DocPat.services.interfaces.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {
    
    private final RatingRepository ratingRepository;
    private final RatingMapper ratingMapper;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Override
    public RatingResponse save(RatingRequest ratingrequest) {
        Doctor doctor=doctorRepository.findById(ratingrequest.getDoctorId()).get();
        Patient patient=patientRepository.findById(ratingrequest.getPatientId()).get();

        Rating rating=ratingMapper.toEntity(ratingrequest);
        rating.setDoctor(doctor);
        rating.setPatient(patient);
        return ratingMapper.toResponse( ratingRepository.save(rating));
    }

    @Override
    public List<RatingResponse> findAll() {
        return ratingMapper.toResponseList(ratingRepository.findAll());
    }

    @Override
    public RatingResponse findById(Long id) {
        return ratingMapper.toResponse(ratingRepository.findById(id).orElse(null));
    }

    @Override
    public void deleteById(Long id) {
        ratingRepository.deleteById(id);
    }

    @Override
    public List<RatingResponse> findByDoctorId(Long doctorId) {
        return ratingMapper.toResponseList(ratingRepository.findAll().stream()
                .filter(r -> r.getDoctor().getId().equals(doctorId))
                .toList());
    }





} 