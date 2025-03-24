package ahmed.foudi.DocPat.services.interfaces;

import ahmed.foudi.DocPat.dto.request.RatingRequest;
import ahmed.foudi.DocPat.dto.response.RatingResponse;
import ahmed.foudi.DocPat.entities.Rating;

import java.util.List;

public interface RatingService {
    RatingResponse save(RatingRequest rating);
    List<RatingResponse> findAll();
    RatingResponse findById(Long id);
    void deleteById(Long id);
    List<RatingResponse> findByDoctorId(Long doctorId);

}
