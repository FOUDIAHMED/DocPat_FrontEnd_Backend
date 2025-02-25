package ahmed.foudi.DocPat.controllers;

import ahmed.foudi.DocPat.dto.response.MedicalReportResponse;
import ahmed.foudi.DocPat.entities.MedicalReport;
import ahmed.foudi.DocPat.services.interfaces.MedicalReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medical-reports")
@RequiredArgsConstructor
public class MedicalReportController {

    private final MedicalReportService medicalReportService;

    @PreAuthorize("hasRole('DOCTOR')")
    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<MedicalReportResponse>> getDoctorReports(@PathVariable Long doctorId) {
        return ResponseEntity.ok(medicalReportService.findByDoctorId(doctorId));
    }

    @PreAuthorize("hasRole('PATIENT')")
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<MedicalReportResponse>> getPatientReports(@PathVariable Long patientId) {
        return ResponseEntity.ok(medicalReportService.findByPatientId(patientId));
    }

    @PreAuthorize("hasAnyRole('DOCTOR', 'PATIENT')")
    @GetMapping("/{id}")
    public ResponseEntity<MedicalReportResponse> getReportById(@PathVariable Long id) {
        return ResponseEntity.ok(medicalReportService.findById(id));
    }

    @PreAuthorize("hasRole('DOCTOR')")
    @PostMapping
    public ResponseEntity<MedicalReportResponse> createReport(@RequestBody MedicalReport report) {
        return ResponseEntity.ok(medicalReportService.save(report));
    }

    @PreAuthorize("hasRole('DOCTOR')")
    @PutMapping("/{id}")
    public ResponseEntity<MedicalReportResponse> updateReport(@PathVariable Long id, @RequestBody MedicalReport report) {

        return ResponseEntity.ok(medicalReportService.save(report));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable Long id) {
        medicalReportService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}