package ahmed.foudi.DocPat.controllers;

import ahmed.foudi.DocPat.dto.embedded.DoctorDto;
import ahmed.foudi.DocPat.dto.response.DoctorResponse;
import ahmed.foudi.DocPat.entities.Doctor;
import ahmed.foudi.DocPat.services.interfaces.DoctorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping
    public ResponseEntity<List<DoctorResponse>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.findAll());
    }
    @GetMapping("/all")
    public ResponseEntity<List<DoctorResponse>> getAllDoctorsPublic() {
        return ResponseEntity.ok(doctorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorResponse> getDoctorById(@PathVariable Long id) {
        return ResponseEntity.ok(doctorService.findById(id));
    }



    @PreAuthorize("hasAnyRole('DOCTOR', 'ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<DoctorResponse> updateDoctor(
            @PathVariable Long id,
            @Valid @RequestBody Doctor request) {
        return ResponseEntity.ok(doctorService.save(request));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        doctorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}