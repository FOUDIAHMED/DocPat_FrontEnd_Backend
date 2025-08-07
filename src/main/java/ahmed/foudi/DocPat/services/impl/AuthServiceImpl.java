package ahmed.foudi.DocPat.services.impl;

import ahmed.foudi.DocPat.dao.AdminRepository;
import ahmed.foudi.DocPat.dao.DoctorRepository;
import ahmed.foudi.DocPat.dao.PatientRepository;
import ahmed.foudi.DocPat.dto.request.DoctorRequest;
import ahmed.foudi.DocPat.dto.request.LoginRequest;
import ahmed.foudi.DocPat.dto.request.PatientRequest;
import ahmed.foudi.DocPat.dto.response.AuthResponse;
import ahmed.foudi.DocPat.entities.Admin;
import ahmed.foudi.DocPat.entities.Agent;
import ahmed.foudi.DocPat.entities.Doctor;
import ahmed.foudi.DocPat.entities.Patient;
import ahmed.foudi.DocPat.entities.enums.AppRole;
import ahmed.foudi.DocPat.exception.DuplicateResourceException;
import ahmed.foudi.DocPat.exception.UnauthorizedAccessException;
import ahmed.foudi.DocPat.security.JwtService;
import ahmed.foudi.DocPat.services.interfaces.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    @Override
    public AuthResponse login(LoginRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );

            var userDetails = (UserDetails) authentication.getPrincipal();
            String email = userDetails.getUsername(); // Retrieve the email from UserDetails

            // Check if the user is a Doctor
            var doctorOptional = doctorRepository.findByEmail(email);
            if (doctorOptional.isPresent()) {
                Doctor doctor = doctorOptional.get();
                var token = jwtService.generateToken(userDetails);
                return AuthResponse.builder()
                        .token(token)
                        .email(email)
                        .role(AppRole.AGENT) // Get role from the database
                        .id(doctor.getId())
                        .firstName(doctor.getFirstName())
                        .lastName(doctor.getLastName())
                        .build();
            }

            // Check if the user is a Patient
            var patientOptional = patientRepository.findByEmail(email);
            if (patientOptional.isPresent()) {
                Patient patient = patientOptional.get();
                var token = jwtService.generateToken(userDetails);
                return AuthResponse.builder()
                        .token(token)
                        .email(email)
                        .role(AppRole.MODERATOR) // Get role from the database
                        .id(patient.getId())
                        .firstName(patient.getFirstName())
                        .lastName(patient.getLastName())
                        .build();
            }
            var admin = adminRepository.findByEmail(email);
            if (admin.isPresent()) {
                Admin patient = admin.get();
                var token = jwtService.generateToken(userDetails);
                return AuthResponse.builder()
                        .token(token)
                        .email(email)
                        .role(patient.getAppRole()) // Get role from the database
                        .id(patient.getId())
                        .firstName(patient.getFirstName())
                        .lastName(patient.getLastName())
                        .build();
            }

            throw UnauthorizedAccessException.invalidCredentials();
        } catch (Exception e) {
            throw UnauthorizedAccessException.invalidCredentials();
        }
    }

    @Override
    @Transactional
    public AuthResponse registerDoctor(DoctorRequest request) {
        if (doctorRepository.findByEmail(request.getEmail()).isPresent() ||
                patientRepository.findByEmail(request.getEmail()).isPresent()) {
            throw DuplicateResourceException.emailAlreadyExists(request.getEmail());
        }
//        if (doctorRepository.findByLicenseNumber(request.getLicenceNumber()).isPresent()) {
//            throw DuplicateResourceException.licenseNumberExists(request.getLicenceNumber());
//        }
        Agent doctor=new Agent();
        doctor.setEmail(request.getEmail());
        doctor.setPassword(passwordEncoder.encode(request.getPassword()));
        doctor.setFirstName(request.getFirstName());
        doctor.setLastName(request.getLastName());
        doctor.setPhoneNumber(request.getPhoneNumber());
        doctor.setAddress(request.getAddress());
        doctor.setUpdated_at(LocalDate.now());
        doctor.setProfilePicture(request.getProfilePicture());
        doctor.setAppRole(AppRole.AGENT);
        doctor=doctorRepository.save(doctor);
        UserDetails doc = User.withUsername(doctor.getEmail())
                .password(doctor.getPassword())
                .roles("AGENT")
                .build();
        String token=jwtService.generateToken(doc);

        return AuthResponse.builder()
                .token(token)
                .email(doctor.getEmail())
                .firstName(doctor.getFirstName())
                .lastName(doctor.getLastName())
                .role(AppRole.AGENT)
                .id(doctor.getId())
                .build();
    }

    @Override
    @Transactional
    public AuthResponse registerPatient(PatientRequest request) {
        if (doctorRepository.findByEmail(request.getEmail()).isPresent() ||
                patientRepository.findByEmail(request.getEmail()).isPresent()) {
            throw DuplicateResourceException.emailAlreadyExists(request.getEmail());
        }
        Patient patient=new Patient();
        patient.setEmail(request.getEmail());
        patient.setPassword(passwordEncoder.encode(request.getPassword()));
        patient.setFirstName(request.getFirstName());
        patient.setLastName(request.getLastName());
        patient.setPhoneNumber(request.getPhoneNumber());
        patient.setDateOfBirth(request.getDateOfBirth());
        patient.setAddress(request.getAddress());
        patient.setProfilePicture(request.getProfilePicture());
        patient.setEmergencyContact(request.getEmergencyContact());
        patient.setAppRole(AppRole.MODERATOR);
        patient=patientRepository.save(patient);
        UserDetails doc = User.withUsername(patient.getEmail())
                .password(patient.getPassword())
                .roles("MODERATOR") // Ensure roles are set correctly
                .build();
        String token=jwtService.generateToken(doc);
        return AuthResponse.builder()
                .token(token)
                .firstName(patient.getFirstName())
                .lastName(patient.getLastName())
                .role(AppRole.MODERATOR)
                .id(patient.getId())
                .email(patient.getEmail())
                .build();

    }
}
