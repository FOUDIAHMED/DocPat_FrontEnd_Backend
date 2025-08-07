package ahmed.foudi.DocPat.dao;

import ahmed.foudi.DocPat.entities.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {
    Optional<Agent> findByLicenceNumber(String licenseNumber);
    Optional<Agent> findByEmail(String email);
}
