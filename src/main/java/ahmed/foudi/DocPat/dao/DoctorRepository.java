package ahmed.foudi.DocPat.dao;

import ahmed.foudi.DocPat.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findByLicenceNumber(String licenseNumber);
    Optional<Doctor> findByEmail(String email);
}
