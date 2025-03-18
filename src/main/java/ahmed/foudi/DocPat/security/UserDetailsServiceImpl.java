package ahmed.foudi.DocPat.security;

import ahmed.foudi.DocPat.dao.AdminRepository;
import ahmed.foudi.DocPat.dao.DoctorRepository;
import ahmed.foudi.DocPat.dao.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final AdminRepository adminRepository;

    @Autowired
    public UserDetailsServiceImpl(DoctorRepository doctorRepository, PatientRepository patientRepository,AdminRepository adminRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.adminRepository = adminRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        return doctorRepository.findByEmail(email)
                .map(UserDetailsImpl::new)
                .orElseGet(() ->

                        patientRepository.findByEmail(email)
                                .map(UserDetailsImpl::new)
                                .orElseGet(()->
                                        adminRepository.findByEmail(email).map(UserDetailsImpl::new)

                                .orElseThrow(() ->
                                        new UsernameNotFoundException("User not found with email: " + email)
                                ))

                );
    }
}
