package ahmed.foudi.DocPat.controllers;


import ahmed.foudi.DocPat.entities.Payment;
import ahmed.foudi.DocPat.services.interfaces.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor

public class PaymentController {

    private final PaymentService paymentService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {
        return ResponseEntity.ok(paymentService.findAll());
    }

    @PreAuthorize("hasRole('DOCTOR')")
    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<Payment>> getDoctorPayments(@PathVariable Long doctorId) {
        return ResponseEntity.ok(paymentService.findByDoctorId(doctorId));
    }

    @PreAuthorize("hasRole('PATIENT')")
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Payment>> getPatientPayments(@PathVariable Long patientId) {
        return ResponseEntity.ok(paymentService.findByPatientId(patientId));
    }

    @PreAuthorize("hasAnyRole('DOCTOR', 'PATIENT', 'ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
        return ResponseEntity.ok(paymentService.findById(id));
    }

    @PreAuthorize("hasRole('PATIENT')")
    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        return ResponseEntity.ok(paymentService.save(payment));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @RequestBody Payment payment) {
        payment.setId(id);
        return ResponseEntity.ok(paymentService.save(payment));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        paymentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

//    @PreAuthorize("hasRole('PATIENT')")
//    @PostMapping("/{id}/process")
//    public ResponseEntity<Payement> processPayment(@PathVariable Long id) {
//        return ResponseEntity.ok(paymentService.processPayment(id));
//    }

//    @PreAuthorize("hasRole('ADMIN')")
//    @PostMapping("/{id}/refund")
//    public ResponseEntity<Payement> refundPayment(@PathVariable Long id) {
//        return ResponseEntity.ok(paymentService.refundPayment(id));
//    }


}