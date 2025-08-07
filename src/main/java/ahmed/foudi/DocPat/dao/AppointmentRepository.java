package ahmed.foudi.DocPat.dao;

import ahmed.foudi.DocPat.entities.PatientRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<PatientRequest, Long> {
}
