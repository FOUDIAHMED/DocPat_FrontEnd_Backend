package ahmed.foudi.DocPat.services.interfaces;

import ahmed.foudi.DocPat.dto.response.RatingResponse;
import ahmed.foudi.DocPat.entities.Rating;

import java.util.List;

public interface RatingService {
    RatingResponse save(Rating rating);
    List<RatingResponse> findAll();
    RatingResponse findById(Long id);
    void deleteById(Long id);
    List<RatingResponse> findByDoctorId(Long doctorId);

}
