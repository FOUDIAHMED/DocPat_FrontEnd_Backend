package ahmed.foudi.DocPat.services.interfaces;

import ahmed.foudi.DocPat.entities.Payment;
import ahmed.foudi.DocPat.entities.enums.PayementStatus;

import java.util.List;

public interface PaymentService {
    Payment save(Payment payement);



    List<Payment> findAll();
    Payment findById(Long id);
    void deleteById(Long id);
    List<Payment> findByDoctorId(Long doctorId);
    List<Payment> findByPatientId(Long patientId);
    List<Payment> findByStatus(PayementStatus status);
    double getTotalPayements(Long doctorId);
}
