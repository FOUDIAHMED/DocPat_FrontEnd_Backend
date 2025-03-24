package ahmed.foudi.DocPat.controllers;

import ahmed.foudi.DocPat.dto.response.PatientResponse;
import ahmed.foudi.DocPat.entities.Patient;
import ahmed.foudi.DocPat.services.interfaces.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {

    private final PatientService patientService;
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<PatientResponse>> getAllPatients() {
        return ResponseEntity.ok(patientService.findAll());
    }

    @PreAuthorize("hasRole('PATIENT')")
    @GetMapping("/{id}")
    public ResponseEntity<PatientResponse> getPatientById(@PathVariable Long id) {
        System.out.println("hahahahaha");
        return ResponseEntity.ok(patientService.findById(id));
    }
    @PreAuthorize("hasRole('PATIENT')")
    @GetMapping("/hahas")
    public String haha() {
        return "hahahahaha";

    }


    @PreAuthorize("hasRole('PATIENT')")
    @PostMapping
    public ResponseEntity<PatientResponse> createPatient(@Valid @RequestBody Patient request) {
        return ResponseEntity.ok(patientService.save(request));
    }

    @PreAuthorize("hasAnyRole('PATIENT', 'ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<PatientResponse> updatePatient(
            @PathVariable Long id,
            @Valid @RequestBody Patient request) {
        return ResponseEntity.ok(patientService.save(request));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}