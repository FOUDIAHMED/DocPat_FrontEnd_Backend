package ahmed.foudi.DocPat.controllers;

import ahmed.foudi.DocPat.dto.response.RatingResponse;
import ahmed.foudi.DocPat.entities.Rating;
import ahmed.foudi.DocPat.services.interfaces.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ratings")
@RequiredArgsConstructor
public class RatingController {

    private final RatingService ratingService;

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<RatingResponse>> getDoctorRatings(@PathVariable Long doctorId) {
        return ResponseEntity.ok(ratingService.findByDoctorId(doctorId));
    }



    @GetMapping("/{id}")
    public ResponseEntity<RatingResponse> getRatingById(@PathVariable Long id) {
        return ResponseEntity.ok(ratingService.findById(id));
    }

    @PreAuthorize("hasRole('PATIENT')")
    @PostMapping
    public ResponseEntity<RatingResponse> createRating(@RequestBody Rating rating) {
        return ResponseEntity.ok(ratingService.save(rating));
    }

    @PreAuthorize("hasRole('PATIENT')")
    @PutMapping("/{id}")
    public ResponseEntity<RatingResponse> updateRating(@PathVariable Long id, @RequestBody Rating rating) {
        rating.setId(id);
        return ResponseEntity.ok(ratingService.save(rating));
    }

    @PreAuthorize("hasAnyRole('PATIENT', 'ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRating(@PathVariable Long id) {
        ratingService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

//    @GetMapping("/doctor/{doctorId}/average")
//    public ResponseEntity<Double> getDoctorAverageRating(@PathVariable Long doctorId) {
//        return ResponseEntity.ok(ratingService.getAverageRatingForDoctor(doctorId));
//    }
}