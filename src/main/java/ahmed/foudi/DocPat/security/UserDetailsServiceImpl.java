package ahmed.foudi.DocPat.security;

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

    @Autowired
    public UserDetailsServiceImpl(DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        return doctorRepository.findByEmail(email)
                .map(UserDetailsImpl::new)
                .orElseGet(() ->

                        patientRepository.findByEmail(email)
                                .map(UserDetailsImpl::new)
                                .orElseThrow(() ->
                                        new UsernameNotFoundException("User not found with email: " + email)
                                )
                );
    }
}
