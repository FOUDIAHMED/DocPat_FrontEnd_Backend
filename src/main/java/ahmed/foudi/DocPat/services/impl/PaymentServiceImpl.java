package ahmed.foudi.DocPat.services.impl;

import ahmed.foudi.DocPat.entities.Payment;
import ahmed.foudi.DocPat.entities.enums.PayementStatus;
import ahmed.foudi.DocPat.dao.PaymentRepository;
import ahmed.foudi.DocPat.services.interfaces.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    
    private final PaymentRepository payementRepository;

    @Override
    public Payment save(Payment payement) {
        return payementRepository.save(payement);
    }

    @Override
    public List<Payment> findAll() {
        return payementRepository.findAll();
    }

    @Override
    public Payment findById(Long id) {
        return payementRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        payementRepository.deleteById(id);
    }

    @Override
    public List<Payment> findByDoctorId(Long doctorId) {
        return payementRepository.findAll().stream()
                .filter(p -> p.getDoctor().getId().equals(doctorId))
                .toList();
    }

    @Override
    public List<Payment> findByPatientId(Long patientId) {
        return payementRepository.findAll().stream()
                .filter(p -> p.getPatient().getId().equals(patientId))
                .toList();
    }

    @Override
    public List<Payment> findByStatus(PayementStatus status) {
        return payementRepository.findAll().stream()
                .filter(p -> p.getStatus().equals(status))
                .toList();
    }

    @Override
    public double getTotalPayements(Long doctorId) {
        return findByDoctorId(doctorId).stream()
                .mapToDouble(Payment::getAmount)
                .sum();
    }
} 